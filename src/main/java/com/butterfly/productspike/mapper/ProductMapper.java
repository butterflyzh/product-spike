package com.butterfly.productspike.mapper;

import com.butterfly.productspike.bean.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ProductMapper {

    /**
     * 查询所有秒杀商品信息，秒杀商品不多，可以一次性查询
     * @return
     */
    List<Product> queryAll();

    /**
     * 查询秒杀商品信息
     * @param bussinessId
     * @return
     */
    Product queryById(@Param("bussinessId") String bussinessId);

    /**
     * 成功秒杀后，对商品减库存
     * @param bussinessId
     * @param seckillTime
     * @return
     */
    int reduceProduct(@Param("bussinessId") String bussinessId,
                      @Param("seckillTime") LocalDateTime seckillTime);



}
