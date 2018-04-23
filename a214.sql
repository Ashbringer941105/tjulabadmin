/*
Navicat MySQL Data Transfer

Source Server         : spring
Source Server Version : 50634
Source Host           : localhost:3306
Source Database       : a214

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2018-04-23 09:10:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `activity_id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(255) DEFAULT NULL,
  `activity_introduction` text,
  `activity_imagepath` varchar(255) DEFAULT NULL,
  `activity_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', '参加中国计算机视觉大会', '2017年10月12日，实验室成员集体参加了中国计算机视觉大会。', 'images/prcv.jpg', '2017.10.12');
INSERT INTO `activity` VALUES ('2', '冬季滑雪活动', '2017年12月16日，实验室组织了集体滑雪活动。', 'video/video.mp4', '2017.12.16');
INSERT INTO `activity` VALUES ('3', '2017脑机媒体会议', '2017年10月15日，实验室举办了脑机媒体会议', 'images/naojimeiti.jpg', '2017.10.15');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gender` varchar(255) DEFAULT NULL,
  `homepage` varchar(255) DEFAULT NULL,
  `imagepath` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rolename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', '男', 'https://zhengwangtju.github.io/', 'images/teacherwang.png', '王征', '教师');
INSERT INTO `member` VALUES ('2', '女', 'http://www.escience.cn/people/sunmeijun/index.html', 'images/teachersun.JPG', '孙美君', '教师');
INSERT INTO `member` VALUES ('3', '男', null, 'images/lianboyang.jpg', '连伯杨', '在校研究生');
INSERT INTO `member` VALUES ('4', '男', null, 'images/jinyadong.jpg', '靳亚东', '在校研究生');
INSERT INTO `member` VALUES ('5', '男', null, 'images/songzongyao.jpg', '宋宗垚', '在校研究生');
INSERT INTO `member` VALUES ('6', '女', null, 'images/zhangxue.png', '张雪', '在校研究生');
INSERT INTO `member` VALUES ('7', '女', null, 'images/zhouziqi.png', '周子淇', '在校研究生');
INSERT INTO `member` VALUES ('8', '男', null, 'images/lipan.jpg', '李攀', '在校研究生');
INSERT INTO `member` VALUES ('9', '女', null, 'images/yanxinyu.jpg', '闫馨宇', '在校研究生');

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `paper_id` int(11) NOT NULL,
  `paper_name` varchar(255) DEFAULT NULL,
  `paper_author` varchar(255) DEFAULT NULL,
  `paper_imagepath` varchar(255) DEFAULT NULL,
  `paper_introduction` text,
  `paper_link` varchar(255) DEFAULT NULL,
  `paper_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`paper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper
-- ----------------------------

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `project_id` int(11) NOT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `project_imagepath` varchar(255) DEFAULT NULL,
  `project_introduction` text,
  `project_link` varchar(255) DEFAULT NULL,
  `project_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------

-- ----------------------------
-- Table structure for sliderimage
-- ----------------------------
DROP TABLE IF EXISTS `sliderimage`;
CREATE TABLE `sliderimage` (
  `sliderimage_imagepath` varchar(255) DEFAULT NULL COMMENT '轮播图片路径，应该写在项目中的相对路径',
  `sliderimage_id` int(11) NOT NULL AUTO_INCREMENT,
  `sliderimage_info` varchar(255) DEFAULT '' COMMENT '轮播图片信息',
  `sliderimage_link` varchar(255) DEFAULT '',
  `sliderimage_date` varchar(255) DEFAULT '',
  PRIMARY KEY (`sliderimage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sliderimage
-- ----------------------------
INSERT INTO `sliderimage` VALUES ('images/banner.jpg', '1', '脑机媒体会议图片', '', '2018/4/12');
INSERT INTO `sliderimage` VALUES ('images/tju.jpg', '2', '天津大学卫津路东门', '', '2018/4/12');
