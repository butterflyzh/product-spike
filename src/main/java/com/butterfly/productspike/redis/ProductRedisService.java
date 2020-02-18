package com.butterfly.productspike.redis;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.butterfly.productspike.bean.Product;
import com.butterfly.productspike.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@Slf4j
@Service
public class ProductRedisService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void setProduct(String bussinessId, ProductVo product){
        String key = String.format(RedisKey.PRODUCT_BUSSINESS_ID_KEY, bussinessId);
        String value = JSON.toJSONString(product);
        stringRedisTemplate.opsForValue().set(key, value, 5, TimeUnit.MINUTES);
    }

    public ProductVo getProduct(String bussinessId){
        String key = String.format(RedisKey.PRODUCT_BUSSINESS_ID_KEY, bussinessId);
        String value = stringRedisTemplate.opsForValue().get(key);
        if (value != null){
            return  JSON.parseObject(value, ProductVo.class);
        }
        return null;
    }

    public boolean delProduct(String bussinessId){
        String key = String.format(RedisKey.PRODUCT_BUSSINESS_ID_KEY, bussinessId);
        return stringRedisTemplate.delete(key);
    }

    public void putUser(String userPhone){
        String key = String.format(RedisKey.SECKILL_USER_PHONE_KEY, userPhone);
        stringRedisTemplate.opsForValue().set(key, "1", 5, TimeUnit.MINUTES);
    }

    public boolean userExist(String userPhone){
        String key = String.format(RedisKey.SECKILL_USER_PHONE_KEY, userPhone);
        return stringRedisTemplate.hasKey(key);
    }
}
