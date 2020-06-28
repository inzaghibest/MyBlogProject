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

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(50) NOT NULL COMMENT '文章标题',
  `description` text COMMENT '文章描述',
  `author` varchar(50) DEFAULT NULL COMMENT '文章作者',
  `content` longtext COMMENT '文章内容',
  `content_format` longtext COMMENT 'html的content',
  `read_num` int(11) DEFAULT '0' COMMENT '阅读量',
  `comment_num` int(11) DEFAULT '0' COMMENT '评论量',
  `like_num` int(11) DEFAULT '0' COMMENT '点赞量',
  `cover_type` int(11) DEFAULT NULL COMMENT '文章展示类别,1:普通，2：大图片，3：无图片',
  `cover` text COMMENT '封面',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `recommend` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否推荐文章',
  `category_id` varchar(50) DEFAULT NULL COMMENT '分类类别存在多级分类，用逗号隔开',
  `publish` tinyint(4) DEFAULT '0' COMMENT '发布状态',
  `top` tinyint(1) DEFAULT '0' COMMENT '是否置顶',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='文章';

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '一个C++程序员的转型和思考', '学习', '张晓平', '由于最近公司项目大多采用vue+spring cloud的前后端分离技术架构，深为一个C++程序员需要学习相关知识，不断进步~', '<p>由于最近公司项目大多采用vue+spring cloud的前后端分离技术架构，深为一个C++程序员需要学习相关知识，不断进步~</p>\n', '39', '0', '2', '2', null, '2020-05-01 13:07:27', '2020-05-01 13:10:05', '1', '1,2,3', '1', '0');
