CREATE TABLE `sucess_seckill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_phone` varchar(50) NOT NULL COMMENT '用户手机号',
  `state` tinyint(4) NOT NULL COMMENT '秒杀状态',
  `bussiness_id` varchar(20) NOT NULL COMMENT '秒杀商品编号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_user_phone` (`user_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=5985 DEFAULT CHARSET=utf8mb4;