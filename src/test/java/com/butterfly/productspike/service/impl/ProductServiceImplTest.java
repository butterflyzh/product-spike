package com.butterfly.productspike.service.impl;

import com.butterfly.productspike.dto.APIResponse;
import com.butterfly.productspike.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {
    @Resource
    private ProductService productService;

    @Test
    void exportSeckillUrl() {
        String bussinessId = "5225346";
        APIResponse apiResponse = productService.exportSeckillUrl(bussinessId);
        System.out.println(apiResponse);
    }

    @Test
    void executeSeckill() {
    }
}