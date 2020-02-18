package com.butterfly.productspike.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisConfigTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testString(){
        stringRedisTemplate.opsForValue().set("test-string-value", "Hello Redis");
        String value = stringRedisTemplate.opsForValue().get("test-string-value");
        System.out.println(value);
    }
}
