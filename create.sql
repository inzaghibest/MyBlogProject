DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT '',
  `address` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL COMMENT '加密key',
  `create_user_id` int(11) DEFAULT NULL,
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) DEFAULT NULL COMMENT '状态: 0:可用 1:禁用',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
