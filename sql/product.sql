CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bussiness_id` varchar(20) NOT NULL COMMENT '秒杀商品编号',
  `product_name` varchar(50) NOT NULL COMMENT '秒杀商品名称',
  `product_price` decimal(11,2) NOT NULL COMMENT '秒杀商品价格',
  `product_amount` int(11) NOT NULL COMMENT '秒杀商品数量',
  `start_time` datetime NOT NULL COMMENT '秒杀活动开始时间',
  `end_time` datetime NOT NULL COMMENT '秒杀活动结束时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_bussiness_id` (`bussiness_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;