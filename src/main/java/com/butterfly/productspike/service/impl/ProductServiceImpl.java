package com.butterfly.productspike.service.impl;

import com.butterfly.productspike.bean.Product;
import com.butterfly.productspike.bean.SuccessSeckill;
import com.butterfly.productspike.dto.APIResponse;
import com.butterfly.productspike.exception.SeckillException;
import com.butterfly.productspike.mapper.ProductMapper;
import com.butterfly.productspike.mapper.SuccessSeckillMapper;
import com.butterfly.productspike.redis.ProductRedisService;
import com.butterfly.productspike.service.ProductService;
import com.butterfly.productspike.util.PackageProduct;
import com.butterfly.productspike.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final String salt = "qzmp@wpxm";

    @Resource
    private ProductRedisService productRedisService;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private SuccessSeckillMapper successSeckillMapper;

    /**
     * 在秒杀开启时输出秒杀接口地址
     * @param bussinessId
     * @return
     */
    @Override
    public APIResponse exportSeckillUrl(String bussinessId) {
        ProductVo productVo = productRedisService.getProduct(bussinessId);
        if (productVo == null){
            Product product = productMapper.queryById(bussinessId);
            if (product == null){
                return new APIResponse(404, "没有该商品");
            }
            productVo = PackageProduct.packageProductVo(product);
            productRedisService.setProduct(product.getBussinessId(), productVo);
        }

        LocalDateTime startTime = LocalDateTime.parse(productVo.getStartTime());
        LocalDateTime endTime = LocalDateTime.parse(productVo.getEndTime());
        LocalDateTime nowTime = LocalDateTime.now();
        if (nowTime.isAfter(startTime) && nowTime.isBefore(endTime)){
            //秒杀开启
            String address = getMD5(bussinessId);
            productVo.setExportUrl(address);
            return new APIResponse(productVo);
        }
        return new APIResponse(productVo);
    }

    private String getMD5(String bussinessId){
        String base = bussinessId + "/" + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public APIResponse executeSeckill(String bussinessId, String userPhone, String address) {
        if (address == null || !address.equals(getMD5(bussinessId))){
            log.error("数据被篡改，用户手机为：", userPhone);
            throw new SeckillException("data have error");
        }
        LocalDateTime nowTime = LocalDateTime.now();
        SuccessSeckill successSeckill = new SuccessSeckill();
        successSeckill.setUserPhone(userPhone);
        successSeckill.setBussinessId(bussinessId);
        successSeckill.setCreateTime(nowTime);
        successSeckill.setState(0);
        try {
            boolean flag = productRedisService.userExist(userPhone);
            if (flag){
                //log.info("用户已经抢购成功：{}", userPhone);
                return new APIResponse("user take parted in active");
            }
            productRedisService.delProduct(bussinessId);
            int insertCount = successSeckillMapper.insertSuccessSeckill(successSeckill);
            if (insertCount <= 0){
                throw new SeckillException("user take parted in active");
            } else{
                int updateCount = productMapper.reduceProduct(bussinessId, nowTime);
                if (updateCount <= 0){
                    //log.warn("商品已经销售完了");
                    throw new SeckillException("product is buyed finised");
                }
            }
            Product product = productMapper.queryById(bussinessId);
            ProductVo productVo = PackageProduct.packageProductVo(product);
            productRedisService.setProduct(product.getBussinessId(), productVo);

            productRedisService.putUser(userPhone);
        }catch (Exception e){
            throw e;
        }
        return new APIResponse("Congratulations!");
    }
}
