package com.butterfly.productspike.mapper;

import com.butterfly.productspike.bean.SuccessSeckill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SuccessSeckillMapper {

    int insertSuccessSeckill(SuccessSeckill successSeckill);

    SuccessSeckill querySuccessSeckill(@Param("userPhone") String userPhone);
}
