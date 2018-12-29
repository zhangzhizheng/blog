/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50640
Source Host           : 127.0.0.1:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2018-12-28 17:20:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_table
-- ----------------------------
DROP TABLE IF EXISTS `blog_table`;
CREATE TABLE `blog_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `tag` int(4) DEFAULT NULL,
  `content` text,
  `lasttime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int(4) DEFAULT NULL,
  `readnum` int(11) DEFAULT NULL,
  `good` int(4) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tag_table
-- ----------------------------
DROP TABLE IF EXISTS `tag_table`;
CREATE TABLE `tag_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_title` varchar(20) DEFAULT NULL,
  `status` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_table
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `pwd` varchar(20) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
