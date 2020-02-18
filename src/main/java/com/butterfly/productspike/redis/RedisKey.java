package com.butterfly.productspike.redis;

public interface RedisKey {

    /**
     * 秒杀商品缓存key
     */
    String PRODUCT_BUSSINESS_ID_KEY = "product_bussiness_id_%s";

    /**
     * 抢购成功的用户
     */
    String SECKILL_USER_PHONE_KEY = "seckill_user_phone_%s";
}
