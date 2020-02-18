package com.butterfly.productspike.mapper;

import com.butterfly.productspike.bean.SuccessSeckill;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class SuccessSeckillMapperTest {

    @Resource
    private SuccessSeckillMapper successSeckillMapper;

    @Test
    void insertSuccessSeckill() {
        SuccessSeckill successSeckill = new SuccessSeckill();
        successSeckill.setBussinessId("5225346");
        successSeckill.setUserPhone("13267837678");
        successSeckill.setCreateTime(LocalDateTime.now());
        successSeckill.setState(1);

        int result = successSeckillMapper.insertSuccessSeckill(successSeckill);
        log.info("插入结果：", result);

        this.querySuccessSeckill();
    }

    @Test
    void querySuccessSeckill() {
        SuccessSeckill successSeckill = successSeckillMapper.querySuccessSeckill("13267837678");
        log.info(successSeckill.toString());
    }
}