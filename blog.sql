/*
 Navicat Premium Data Transfer

 Source Server         : 122.114.197.64
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : 122.114.197.64
 Source Database       : blog

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 08/03/2017 22:25:35 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `blog_article`
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article` (
  `recid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '文章标题',
  `content` longtext COMMENT '文章内容',
  `createtime` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '创建时间',
  `updatetime` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '更新时间',
  `status` int(11) DEFAULT NULL COMMENT '有效值',
  PRIMARY KEY (`recid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='博文表';

-- ----------------------------
--  Table structure for `blog_article_msg`
-- ----------------------------
DROP TABLE IF EXISTS `blog_article_msg`;
CREATE TABLE `blog_article_msg` (
  `recid` int(11) NOT NULL AUTO_INCREMENT,
  `msgid` int(11) DEFAULT NULL,
  `articleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`recid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `blog_article_tag`
-- ----------------------------
DROP TABLE IF EXISTS `blog_article_tag`;
CREATE TABLE `blog_article_tag` (
  `recid` int(11) NOT NULL AUTO_INCREMENT,
  `tagid` int(11) DEFAULT NULL,
  `articleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`recid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='标签与文章关联表';

-- ----------------------------
--  Table structure for `blog_article_type`
-- ----------------------------
DROP TABLE IF EXISTS `blog_article_type`;
CREATE TABLE `blog_article_type` (
  `recid` int(11) NOT NULL AUTO_INCREMENT,
  `typeid` int(11) DEFAULT NULL,
  `articleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`recid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='文章类型关联表';

-- ----------------------------
--  Table structure for `blog_links`
-- ----------------------------
DROP TABLE IF EXISTS `blog_links`;
CREATE TABLE `blog_links` (
  `recid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '友情链接名称',
  `url` varchar(255) DEFAULT NULL COMMENT '友情链接地址',
  `sort` int(11) DEFAULT NULL COMMENT '排序标志，数字从大到小',
  PRIMARY KEY (`recid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='友情链接';

-- ----------------------------
--  Table structure for `blog_msg`
-- ----------------------------
DROP TABLE IF EXISTS `blog_msg`;
CREATE TABLE `blog_msg` (
  `recid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `msg` varchar(255) DEFAULT NULL COMMENT '消息内容',
  `createtime` varchar(50) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`recid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博文留言表';

-- ----------------------------
--  Table structure for `blog_tag`
-- ----------------------------
DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag` (
  `recid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `createtime` varchar(50) DEFAULT NULL,
  `updatetime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`recid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='标签表';

-- ----------------------------
--  Table structure for `blog_type`
-- ----------------------------
DROP TABLE IF EXISTS `blog_type`;
CREATE TABLE `blog_type` (
  `recid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '类型名称',
  `createtime` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `updatetime` varchar(50) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`recid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='博文种类';

-- ----------------------------
--  Table structure for `blog_user`
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `recId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `wechat` int(11) DEFAULT NULL COMMENT '微信id',
  `oicq` int(11) DEFAULT NULL COMMENT 'qq号码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `icon` varchar(100) DEFAULT NULL COMMENT '头像url地址',
  `logo` varchar(100) DEFAULT NULL COMMENT 'logo的url地址',
  `lasttime` varchar(50) DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`recId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='博主信息表';

SET FOREIGN_KEY_CHECKS = 1;
