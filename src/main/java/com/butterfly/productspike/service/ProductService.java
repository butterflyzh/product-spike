package com.butterfly.productspike.service;

import com.butterfly.productspike.dto.APIResponse;

public interface ProductService {

    APIResponse exportSeckillUrl(String bussinessId);

    APIResponse executeSeckill(String bussinessId, String userPhone, String address);
}
