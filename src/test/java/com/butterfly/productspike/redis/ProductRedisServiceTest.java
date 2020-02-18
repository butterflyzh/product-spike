package com.butterfly.productspike.redis;

import com.butterfly.productspike.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductRedisServiceTest {

    @Resource
    private ProductRedisService productRedisService;

    @Test
    void setProduct() {
        ProductVo productVo = new ProductVo();
        productVo.setId(1L);
        productVo.setProductName("产品1");
        productVo.setProductAmount(100);
        productVo.setProductPrice("99.00");
        productVo.setStartTime("2020-02-10 15:12:12");
        productVo.setEndTime("2020-02-10 15:12:12");
        productRedisService.setProduct("12345", productVo);

        getProduct();
    }

    @Test
    void getProduct() {
        String bussinessId = "12345";
        ProductVo productVo = productRedisService.getProduct(bussinessId);
        log.info("从缓存获取商品信息：", productVo.toString());
        //System.out.println(productVo.toString());
    }
}