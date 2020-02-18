package com.butterfly.productspike.mapper;

import com.butterfly.productspike.bean.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductMapperTest {

    @Resource
    private ProductMapper productMapper;

    @Test
    void queryAll() {
        List<Product> productList = productMapper.queryAll();
        for (Product product : productList){
            log.info(product.toString());
        }
    }

    @Test
    void queryById() {
        String bussinessId = "5225346";
        Product product = productMapper.queryById(bussinessId);
        log.info(product.toString());
    }

    @Test
    void reduceProduct() {
        //2020-02-15T15:51:43
        String bussinessId = "5225346";
        LocalDateTime seckillTime = LocalDateTime.now();
        Integer result = productMapper.reduceProduct(bussinessId, seckillTime);
        log.info("返回结果：", result);
    }


}