package com.butterfly.productspike.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "success_seckill")
@Data
public class SuccessSeckill {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户手机号码
     */
    private String userPhone;

    /**
     * 秒杀状态
     */
    private Integer state;

    /**
     * 秒杀商品编号
     */
    private String bussinessId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
