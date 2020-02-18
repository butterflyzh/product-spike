package com.butterfly.productspike.controller;

import com.butterfly.productspike.dto.APIResponse;
import com.butterfly.productspike.exception.SeckillException;
import com.butterfly.productspike.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/seckill")
public class ProductController {

    @Resource
    private ProductService productService;

    @RequestMapping(value = "/{bussinessId}/exposer", method = RequestMethod.GET)
    public APIResponse exposer(@PathVariable("bussinessId") String bussinessId){
        return productService.exportSeckillUrl(bussinessId);
    }

    @RequestMapping(value = "/{bussinessId}/{address}/execution", method = RequestMethod.POST)
    public APIResponse execute(@PathVariable("bussinessId") String bussinessId,
                               @Param("userPhone") String userPhone,
                               @PathVariable("address") String address){
        System.out.println(userPhone);
        if (userPhone == null || userPhone.equals("")){
            return new APIResponse("用户没有注册");
        }
        try {
            return productService.executeSeckill(bussinessId, userPhone, address);
        }catch (SeckillException e){
            return new APIResponse(e.getMessage());
        }catch (Exception e){
            return new APIResponse(e.getMessage());
        }
    }
}
