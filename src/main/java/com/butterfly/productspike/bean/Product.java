package com.butterfly.productspike.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 秒杀商品编号
     */
    private String bussinessId;

    /**
     * 秒杀商品名称
     */
    private String productName;

    /**
     * 秒杀商品价格
     */
    private BigDecimal productPrice;

    /**
     * 秒杀商品的数量
     */
    private Integer productAmount;

    /**
     * 秒杀活动开始时间
     */
    private LocalDateTime startTime;

    /**
     * 秒杀活动结束时间
     */
    private LocalDateTime endTime;
}
