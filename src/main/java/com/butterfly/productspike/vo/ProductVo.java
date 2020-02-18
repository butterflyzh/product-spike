package com.butterfly.productspike.vo;

import lombok.Data;

@Data
public class ProductVo {
    private Long id;

    private String productName;

    private String productPrice;

    private Integer productAmount;

    private String startTime;

    private String endTime;

    private String exportUrl;
}
