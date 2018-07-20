/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : cjm

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-07-20 19:20:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for forum_attachment
-- ----------------------------
DROP TABLE IF EXISTS `forum_attachment`;
CREATE TABLE `forum_attachment` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `tid` bigint(19) DEFAULT NULL,
  `pid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `tableid` int(1) DEFAULT NULL,
  `downloads` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment
-- ----------------------------
INSERT INTO `forum_attachment` VALUES ('1', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('2', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('3', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('4', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('5', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('6', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('7', '11', '8', '999999', '1', '0');
INSERT INTO `forum_attachment` VALUES ('8', '11', '8', '10', '1', '0');
INSERT INTO `forum_attachment` VALUES ('9', '12', '9', '10', '2', '0');

-- ----------------------------
-- Table structure for forum_attachment_0
-- ----------------------------
DROP TABLE IF EXISTS `forum_attachment_0`;
CREATE TABLE `forum_attachment_0` (
  `aid` bigint(19) NOT NULL DEFAULT '0',
  `tid` bigint(19) DEFAULT NULL,
  `pid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `filesize` bigint(19) DEFAULT NULL,
  `attachment` varchar(255) DEFAULT NULL,
  `thumachment` varchar(255) DEFAULT NULL,
  `waterattachment` varchar(255) DEFAULT NULL,
  `remote` int(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `readperm` int(1) DEFAULT NULL,
  `price` int(6) DEFAULT NULL,
  `isimage` int(1) DEFAULT NULL,
  `width` int(6) DEFAULT NULL,
  `picid` bigint(19) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_0
-- ----------------------------

-- ----------------------------
-- Table structure for forum_attachment_1
-- ----------------------------
DROP TABLE IF EXISTS `forum_attachment_1`;
CREATE TABLE `forum_attachment_1` (
  `aid` bigint(19) NOT NULL DEFAULT '0',
  `tid` bigint(19) DEFAULT NULL,
  `pid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `filesize` bigint(19) DEFAULT NULL,
  `attachment` varchar(255) DEFAULT NULL,
  `thumachment` varchar(255) DEFAULT NULL,
  `waterattachment` varchar(255) DEFAULT NULL,
  `remote` int(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `readperm` int(1) DEFAULT NULL,
  `price` int(6) DEFAULT NULL,
  `isimage` int(1) DEFAULT NULL,
  `width` int(6) DEFAULT NULL,
  `picid` bigint(19) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_1
-- ----------------------------
INSERT INTO `forum_attachment_1` VALUES ('7', '11', '8', '999999', '1528039085267', 'QQ图片20180602214630.png', '37920', 'group1/M00/00/01/rBKphlsUByeAOKHOAACUIDGLrgE684.png', 'group1/M00/00/01/rBKphlsUByeAOKHOAACUIDGLrgE684_200x80.png', '', '0', '', '0', '0', '1', '1218', null);
INSERT INTO `forum_attachment_1` VALUES ('8', '11', '8', '10', '1528039130966', 'VID20180603230811.mp4', '10265716', 'group1/M00/00/01/rBKphlsUB0yAf5C7AJykdAReKkA560.mp4', null, null, '0', '', '0', '0', '2', null, null);

-- ----------------------------
-- Table structure for forum_attachment_2
-- ----------------------------
DROP TABLE IF EXISTS `forum_attachment_2`;
CREATE TABLE `forum_attachment_2` (
  `aid` bigint(19) NOT NULL DEFAULT '0',
  `tid` bigint(19) DEFAULT NULL,
  `pid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `filesize` bigint(19) DEFAULT NULL,
  `attachment` varchar(255) DEFAULT NULL,
  `thumachment` varchar(255) DEFAULT NULL,
  `waterattachment` varchar(255) DEFAULT NULL,
  `remote` int(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `readperm` int(1) DEFAULT NULL,
  `price` int(6) DEFAULT NULL,
  `isimage` int(1) DEFAULT NULL,
  `width` int(6) DEFAULT NULL,
  `picid` bigint(19) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_2
-- ----------------------------
INSERT INTO `forum_attachment_2` VALUES ('9', '12', '9', '10', '1528041679551', 'VID20180603230811.mp4', '10265716', 'group1/M00/00/01/rBKphlsUEUuAKnA9AJykdAReKkA204.mp4', null, null, '0', '', '0', '0', '2', null, null);

-- ----------------------------
-- Table structure for forum_attachment_3
-- ----------------------------
DROP TABLE IF EXISTS `forum_attachment_3`;
CREATE TABLE `forum_attachment_3` (
  `aid` bigint(19) NOT NULL DEFAULT '0',
  `tid` bigint(19) DEFAULT NULL,
  `pid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `filesize` bigint(19) DEFAULT NULL,
  `attachment` varchar(255) DEFAULT NULL,
  `thumachment` varchar(255) DEFAULT NULL,
  `waterattachment` varchar(255) DEFAULT NULL,
  `remote` int(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `readperm` int(1) DEFAULT NULL,
  `price` int(6) DEFAULT NULL,
  `isimage` int(1) DEFAULT NULL,
  `width` int(6) DEFAULT NULL,
  `picid` bigint(19) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_3
-- ----------------------------

-- ----------------------------
-- Table structure for forum_attachment_4
-- ----------------------------
DROP TABLE IF EXISTS `forum_attachment_4`;
CREATE TABLE `forum_attachment_4` (
  `aid` bigint(19) NOT NULL DEFAULT '0',
  `tid` bigint(19) DEFAULT NULL,
  `pid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `filesize` bigint(19) DEFAULT NULL,
  `attachment` varchar(255) DEFAULT NULL,
  `thumachment` varchar(255) DEFAULT NULL,
  `waterattachment` varchar(255) DEFAULT NULL,
  `remote` int(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `readperm` int(1) DEFAULT NULL,
  `price` int(6) DEFAULT NULL,
  `isimage` int(1) DEFAULT NULL,
  `width` int(6) DEFAULT NULL,
  `picid` bigint(19) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_4
-- ----------------------------

-- ----------------------------
-- Table structure for forum_attachment_5
-- ----------------------------
DROP TABLE IF EXISTS `forum_attachment_5`;
CREATE TABLE `forum_attachment_5` (
  `aid` bigint(19) NOT NULL DEFAULT '0',
  `tid` bigint(19) DEFAULT NULL,
  `pid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `filesize` bigint(19) DEFAULT NULL,
  `attachment` varchar(255) DEFAULT NULL,
  `thumachment` varchar(255) DEFAULT NULL,
  `waterattachment` varchar(255) DEFAULT NULL,
  `remote` int(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `readperm` int(1) DEFAULT NULL,
  `price` int(6) DEFAULT NULL,
  `isimage` int(1) DEFAULT NULL,
  `width` int(6) DEFAULT NULL,
  `picid` bigint(19) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_5
-- ----------------------------

-- ----------------------------
-- Table structure for forum_attachment_6
-- ----------------------------
DROP TABLE IF EXISTS `forum_attachment_6`;
CREATE TABLE `forum_attachment_6` (
  `aid` bigint(19) NOT NULL DEFAULT '0',
  `tid` bigint(19) DEFAULT NULL,
  `pid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `filesize` bigint(19) DEFAULT NULL,
  `attachment` varchar(255) DEFAULT NULL,
  `thumachment` varchar(255) DEFAULT NULL,
  `waterattachment` varchar(255) DEFAULT NULL,
  `remote` int(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `readperm` int(1) DEFAULT NULL,
  `price` int(6) DEFAULT NULL,
  `isimage` int(1) DEFAULT NULL,
  `width` int(6) DEFAULT NULL,
  `picid` bigint(19) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_6
-- ----------------------------

-- ----------------------------
-- Table structure for forum_attachment_7
-- ----------------------------
DROP TABLE IF EXISTS `forum_attachment_7`;
CREATE TABLE `forum_attachment_7` (
  `aid` bigint(19) NOT NULL DEFAULT '0',
  `tid` bigint(19) DEFAULT NULL,
  `pid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `filesize` bigint(19) DEFAULT NULL,
  `attachment` varchar(255) DEFAULT NULL,
  `thumachment` varchar(255) DEFAULT NULL,
  `waterattachment` varchar(255) DEFAULT NULL,
  `remote` int(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `readperm` int(1) DEFAULT NULL,
  `price` int(6) DEFAULT NULL,
  `isimage` int(1) DEFAULT NULL,
  `width` int(6) DEFAULT NULL,
  `picid` bigint(19) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_7
-- ----------------------------

-- ----------------------------
-- Table structure for forum_attachment_8
-- ----------------------------
DROP TABLE IF EXISTS `forum_attachment_8`;
CREATE TABLE `forum_attachment_8` (
  `aid` bigint(19) NOT NULL DEFAULT '0',
  `tid` bigint(19) DEFAULT NULL,
  `pid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `filesize` bigint(19) DEFAULT NULL,
  `attachment` varchar(255) DEFAULT NULL,
  `thumachment` varchar(255) DEFAULT NULL,
  `waterattachment` varchar(255) DEFAULT NULL,
  `remote` int(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `readperm` int(1) DEFAULT NULL,
  `price` int(6) DEFAULT NULL,
  `isimage` int(1) DEFAULT NULL,
  `width` int(6) DEFAULT NULL,
  `picid` bigint(19) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_8
-- ----------------------------

-- ----------------------------
-- Table structure for forum_attachment_9
-- ----------------------------
DROP TABLE IF EXISTS `forum_attachment_9`;
CREATE TABLE `forum_attachment_9` (
  `aid` bigint(19) NOT NULL DEFAULT '0',
  `tid` bigint(19) DEFAULT NULL,
  `pid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `filesize` bigint(19) DEFAULT NULL,
  `attachment` varchar(255) DEFAULT NULL,
  `thumachment` varchar(255) DEFAULT NULL,
  `waterattachment` varchar(255) DEFAULT NULL,
  `remote` int(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `readperm` int(1) DEFAULT NULL,
  `price` int(6) DEFAULT NULL,
  `isimage` int(1) DEFAULT NULL,
  `width` int(6) DEFAULT NULL,
  `picid` bigint(19) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_9
-- ----------------------------

-- ----------------------------
-- Table structure for forum_attachment_unused
-- ----------------------------
DROP TABLE IF EXISTS `forum_attachment_unused`;
CREATE TABLE `forum_attachment_unused` (
  `aid` bigint(19) NOT NULL DEFAULT '0',
  `tid` bigint(19) DEFAULT NULL,
  `pid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `filesize` bigint(19) DEFAULT NULL,
  `attachment` varchar(255) DEFAULT NULL,
  `thumachment` varchar(255) DEFAULT NULL,
  `waterattachment` varchar(255) DEFAULT NULL,
  `remote` int(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `readperm` int(1) DEFAULT NULL,
  `price` int(6) DEFAULT NULL,
  `isimage` int(1) DEFAULT NULL,
  `width` int(6) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_unused
-- ----------------------------
INSERT INTO `forum_attachment_unused` VALUES ('1', null, null, '999999', '1527612080251', 'logo1.png', '11614', 'group1/M00/00/00/rBKphlsNgyaAa_i2AAAtXgOqF2k702.png', 'group1/M00/00/00/rBKphlsNgyaAa_i2AAAtXgOqF2k702_200x80.png', '', '0', null, null, null, '1', '234');
INSERT INTO `forum_attachment_unused` VALUES ('2', null, null, '999999', '1527612240803', 'QQ图片20170603211403.jpg', '38006', 'group1/M00/00/00/rBKphlsNg8iAZGdXAACUdhzoQVU221.jpg', 'group1/M00/00/00/rBKphlsNg8iAZGdXAACUdhzoQVU221_200x80.jpg', '', '0', null, null, null, '1', '1081');
INSERT INTO `forum_attachment_unused` VALUES ('3', null, null, '999999', '1527612244751', 'logo1.png', '11614', 'group1/M00/00/01/rBKphlsNg8yARzJvAAAtXgOqF2k318.png', 'group1/M00/00/01/rBKphlsNg8yARzJvAAAtXgOqF2k318_200x80.png', '', '0', null, null, null, '1', '234');
INSERT INTO `forum_attachment_unused` VALUES ('4', null, null, '999999', '1527776480150', 'logo1.png', '11614', 'group1/M00/00/01/rBKphlsQBViAJ7HAAAAtXgOqF2k949.png', 'group1/M00/00/01/rBKphlsQBViAJ7HAAAAtXgOqF2k949_200x80.png', '', '0', null, null, null, '1', '234');
INSERT INTO `forum_attachment_unused` VALUES ('5', null, null, '999999', '1528032563475', 'QQ图片20180602214630.png', '37920', 'group1/M00/00/01/rBKphlsT7ZmARa8dAACUIDGLrgE873.png', 'group1/M00/00/01/rBKphlsT7ZmARa8dAACUIDGLrgE873_200x80.png', '', '0', null, null, null, '1', '1218');
INSERT INTO `forum_attachment_unused` VALUES ('6', null, null, '999999', '1528032824141', 'QQ图片20180602214630.png', '37920', 'group1/M00/00/01/rBKphlsT7qyAD7uAAACUIDGLrgE835.png', 'group1/M00/00/01/rBKphlsT7qyAD7uAAACUIDGLrgE835_200x80.png', '', '0', null, null, null, '1', '1218');

-- ----------------------------
-- Table structure for forum_forum
-- ----------------------------
DROP TABLE IF EXISTS `forum_forum`;
CREATE TABLE `forum_forum` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `threads` bigint(19) DEFAULT NULL,
  `commonts` bigint(19) DEFAULT NULL,
  `addtime` bigint(13) DEFAULT NULL,
  `addbaseid` bigint(19) DEFAULT NULL,
  `updatetime` bigint(13) DEFAULT NULL,
  `updatebaseid` bigint(19) DEFAULT NULL,
  `isdelete` int(1) DEFAULT NULL,
  `sort` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_forum
-- ----------------------------
INSERT INTO `forum_forum` VALUES ('2', 'java', '1', '0', '0', '1527784216142', '10', '1527784261405', '10', '0', '0');
INSERT INTO `forum_forum` VALUES ('3', 'golang', '1', '0', '0', '1528000072569', '10', null, null, '0', '0');
INSERT INTO `forum_forum` VALUES ('4', 'javascript', '1', '0', '0', '1528000080864', '10', null, null, '0', '0');
INSERT INTO `forum_forum` VALUES ('5', '关于我', '1', '0', '0', '1528000092116', '10', null, null, '0', '2');
INSERT INTO `forum_forum` VALUES ('6', '首页', '1', '0', '0', '1528000098384', '10', null, null, '0', '10');
INSERT INTO `forum_forum` VALUES ('7', '相册', '1', '0', '0', '1528000107713', '10', null, null, '0', '0');
INSERT INTO `forum_forum` VALUES ('8', '视频', '1', '0', '0', '1528000117318', '10', null, null, '0', '0');
INSERT INTO `forum_forum` VALUES ('9', '音乐', '1', '0', '0', '1528000126932', '10', null, null, '0', '1');
INSERT INTO `forum_forum` VALUES ('10', 'java22', '1', '0', '0', '1528214934683', '10', null, null, '0', '0');

-- ----------------------------
-- Table structure for forum_post
-- ----------------------------
DROP TABLE IF EXISTS `forum_post`;
CREATE TABLE `forum_post` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `fid` bigint(19) DEFAULT NULL,
  `tid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `subject` varchar(100) DEFAULT NULL,
  `content` mediumtext,
  `status` int(1) DEFAULT NULL,
  `addtime` bigint(13) DEFAULT NULL,
  `updatetime` bigint(13) DEFAULT NULL,
  `updatebaseid` bigint(19) DEFAULT NULL,
  `isdelete` int(1) DEFAULT NULL,
  `useip` varchar(50) DEFAULT NULL,
  `attachment` int(3) DEFAULT NULL,
  `usesig` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_post
-- ----------------------------
INSERT INTO `forum_post` VALUES ('1', '2', '2', '10', '20180603主题保存', '今天是发个号日子啊', '-1', '1528030711528', null, null, '0', null, '0', '0');
INSERT INTO `forum_post` VALUES ('2', '2', '8', '10', '20180603主题保存', '今天是发个号日子啊', '0', '1528030842399', null, null, '0', '192.168.1.5', '0', '0');
INSERT INTO `forum_post` VALUES ('4', '2', '4', '10', '20180603主题保存', '今天是发个号日子啊', '0', '1528031111765', null, null, '0', '192.168.1.5', '0', '0');
INSERT INTO `forum_post` VALUES ('5', '2', '2', '10', '20180603主题保存', '今天是发个号日子啊<p>     [attach]6[/attach] </p>', '-1', '1528033027619', null, null, '0', '192.168.1.5', '1', '0');
INSERT INTO `forum_post` VALUES ('8', '2', '11', '10', '20180603主题测试', '的说法是的范德萨<p>     [attach]7[/attach]     [attach]8[/attach] </p>', '0', '1528043945238', null, null, '0', '192.168.1.5', '2', '0');
INSERT INTO `forum_post` VALUES ('9', '2', '12', '10', '20180603主题测试', '的说法是的范德萨[attach]9[/attach]', '0', '1528044014770', null, null, '0', '192.168.1.5', '1', '0');
INSERT INTO `forum_post` VALUES ('10', '2', '13', '10', '测试主题', '的范德萨范德萨', '0', '1528044161938', null, null, '0', '192.168.1.5', '0', '0');

-- ----------------------------
-- Table structure for forum_thraad_tag_link
-- ----------------------------
DROP TABLE IF EXISTS `forum_thraad_tag_link`;
CREATE TABLE `forum_thraad_tag_link` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `tagid` bigint(19) DEFAULT NULL,
  `tid` bigint(19) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_thraad_tag_link
-- ----------------------------

-- ----------------------------
-- Table structure for forum_thread
-- ----------------------------
DROP TABLE IF EXISTS `forum_thread`;
CREATE TABLE `forum_thread` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `fid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `subject` varchar(80) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `lastpost` bigint(13) DEFAULT NULL,
  `lastposter` bigint(19) DEFAULT NULL,
  `views` int(8) DEFAULT NULL,
  `replies` int(8) DEFAULT NULL,
  `digest` int(1) DEFAULT NULL,
  `attachment` int(1) DEFAULT NULL,
  `moderated` int(1) DEFAULT NULL,
  `likes` int(6) DEFAULT NULL,
  `unlikes` int(6) DEFAULT NULL,
  `favtimes` int(6) DEFAULT NULL,
  `sharetimes` int(6) DEFAULT NULL,
  `status` int(6) DEFAULT NULL,
  `isdelete` int(1) DEFAULT NULL,
  `sort` int(3) DEFAULT NULL,
  `threadtype` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_thread
-- ----------------------------
INSERT INTO `forum_thread` VALUES ('1', '2', '10', '20180603主题保存', '1528030711528', null, null, '0', '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '1');
INSERT INTO `forum_thread` VALUES ('2', '2', '10', '20180603主题保存', '1528030842399', null, null, '4', '0', '0', '0', '0', '0', '0', '0', '0', '-1', '1', '0', '1');
INSERT INTO `forum_thread` VALUES ('4', '2', '10', '20180603主题保存', '1528031111765', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1');
INSERT INTO `forum_thread` VALUES ('8', '2', '10', '20180603主题保存', '1528033027619', null, null, '5', '0', '0', '2', '1', '2', '0', '0', '0', '0', '0', '0', '1');
INSERT INTO `forum_thread` VALUES ('11', '2', '10', '20180603主题测试', '1528043945238', null, null, '0', '0', '0', '2', '1', '0', '0', '0', '0', '0', '0', '0', '1');
INSERT INTO `forum_thread` VALUES ('12', '2', '10', '20180603主题测试', '1528044014770', null, null, '0', '0', '0', '2', '1', '3', '0', '0', '0', '0', '0', '0', '1');
INSERT INTO `forum_thread` VALUES ('13', '2', '10', '测试主题', '1528044161938', null, null, '0', '9', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1');

-- ----------------------------
-- Table structure for forum_thread_operation
-- ----------------------------
DROP TABLE IF EXISTS `forum_thread_operation`;
CREATE TABLE `forum_thread_operation` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `tid` bigint(19) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `userip` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_thread_operation
-- ----------------------------
INSERT INTO `forum_thread_operation` VALUES ('1', '13', '1', 'AUDITSU', '1528215617475', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('2', '4', '1', 'AUDITSU', '1528215858700', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('3', '8', '1', 'AUDITSU', '1528215864381', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('4', '11', '1', 'AUDITSU', '1528215869757', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('5', '13', '1', 'AUDITFA', '1528269854839', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('7', '4', '1', 'AUDITFA', '1528269967652', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('8', '8', '1', 'AUDITFA', '1528269967669', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('9', '11', '1', 'AUDITFA', '1528269967682', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('10', '4', '1', 'AUDITFA', '1528269992636', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('11', '8', '1', 'AUDITFA', '1528269992645', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('12', '11', '1', 'AUDITFA', '1528269992655', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('13', '4', '1', 'AUDITFA', '1528270031732', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('14', '8', '1', 'AUDITFA', '1528270031773', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('15', '11', '1', 'AUDITFA', '1528270031823', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('16', '4', '1', 'AUDITFA', '1528270057664', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('17', '8', '1', 'AUDITFA', '1528270057672', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('18', '11', '1', 'AUDITFA', '1528270057684', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('19', '11', '1', 'UPD', '1528270880496', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('20', '11', '1', 'DEL', '1528270897493', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('21', '11', '1', 'UPD', '1528270916331', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('22', '12', '1', 'UPD', '1528271100308', '10', 'bus3406', '192.168.1.5');
INSERT INTO `forum_thread_operation` VALUES ('23', '13', '1', 'UPD', '1528271100312', '10', 'bus3406', '192.168.1.5');

-- ----------------------------
-- Table structure for forum_thread_tag
-- ----------------------------
DROP TABLE IF EXISTS `forum_thread_tag`;
CREATE TABLE `forum_thread_tag` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `uid` bigint(19) DEFAULT NULL,
  `isdelete` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_thread_tag
-- ----------------------------

-- ----------------------------
-- Table structure for friendlink
-- ----------------------------
DROP TABLE IF EXISTS `friendlink`;
CREATE TABLE `friendlink` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `displayorder` int(1) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `description` mediumtext,
  `logo` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friendlink
-- ----------------------------

-- ----------------------------
-- Table structure for system_resource
-- ----------------------------
DROP TABLE IF EXISTS `system_resource`;
CREATE TABLE `system_resource` (
  `resourceid` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `resourceurl` varchar(100) DEFAULT NULL COMMENT '资源ID',
  `resourcename` varchar(100) DEFAULT NULL COMMENT '资源名称',
  `sort` int(6) DEFAULT '0' COMMENT '排序编号',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `parentid` bigint(19) DEFAULT '0' COMMENT '父资源ID',
  `type` int(1) DEFAULT '1' COMMENT '类型 （1为菜单 2 按钮）',
  `permission` varchar(100) DEFAULT NULL COMMENT '权限',
  `link` varchar(50) DEFAULT NULL COMMENT '路由url',
  `hide` tinyint(1) DEFAULT '1' COMMENT '是否隐藏',
  `icon` varchar(50) DEFAULT NULL,
  `externallink` varchar(100) DEFAULT NULL COMMENT '外部链接',
  `target` varchar(30) DEFAULT NULL COMMENT '链接打开方式  ''_blank'' | ''_self'' | ''_parent'' | ''_top''',
  PRIMARY KEY (`resourceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_resource
-- ----------------------------

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
  `roleid` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `rolename` varchar(50) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_role
-- ----------------------------
INSERT INTO `system_role` VALUES ('1', '管理员');
INSERT INTO `system_role` VALUES ('2', '管理员');
INSERT INTO `system_role` VALUES ('3', '管理员');
INSERT INTO `system_role` VALUES ('4', '管理员');
INSERT INTO `system_role` VALUES ('5', '普通管理员');

-- ----------------------------
-- Table structure for system_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `system_role_resource`;
CREATE TABLE `system_role_resource` (
  `roleid` bigint(19) DEFAULT NULL COMMENT '角色id',
  `resourceid` bigint(19) DEFAULT NULL COMMENT '资源id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_role_resource
-- ----------------------------

-- ----------------------------
-- Table structure for system_user_role
-- ----------------------------
DROP TABLE IF EXISTS `system_user_role`;
CREATE TABLE `system_user_role` (
  `roleid` bigint(19) DEFAULT NULL COMMENT '角色id',
  `userid` bigint(19) DEFAULT NULL COMMENT '用户id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `mobilestatus` int(1) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `emailstatus` int(1) DEFAULT NULL,
  `userno` bigint(19) DEFAULT NULL,
  `regtime` bigint(13) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL,
  `signature` varchar(200) DEFAULT NULL,
  `relaname` varchar(50) DEFAULT NULL,
  `idcardnumber` varchar(50) DEFAULT NULL,
  `relastatus` int(1) DEFAULT NULL,
  `regip` varchar(50) DEFAULT NULL,
  `device` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10', 'bus3406', '13553869013', '1', null, '0', null, '1525962629832', null, null, null, null, '0', '192.168.1.2', 'UNKNOWN');
INSERT INTO `user` VALUES ('11', 'bus1243', '13553869015', '1', null, '0', null, '1525966002464', null, null, null, null, '0', '192.168.1.2', 'UNKNOWN');
INSERT INTO `user` VALUES ('12', 'bus5280', '13553869012', '1', null, '0', null, '1529922798913', null, null, null, null, '0', '113.116.158.149', 'UNKNOWN');
INSERT INTO `user` VALUES ('13', 'bus0348', '13553869018', '1', null, '0', null, '1529923467671', null, null, null, null, '0', '113.116.158.149', 'UNKNOWN');
INSERT INTO `user` VALUES ('16', '123533', '13553896025', '1', null, '0', null, '1531304577046', null, null, null, null, '0', '192.168.0.135', 'UNKNOWN');
INSERT INTO `user` VALUES ('17', 'bus5555', '13553869256', '1', null, '0', null, '1531305478416', null, null, null, null, '0', '192.168.0.135', 'UNKNOWN');

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `baseid` bigint(19) DEFAULT NULL,
  `balance` decimal(19,2) DEFAULT NULL,
  `freezebalance` decimal(19,2) DEFAULT NULL,
  `totalbalance` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_account
-- ----------------------------
INSERT INTO `user_account` VALUES ('3', '10', '0.00', '0.00', '0.00');
INSERT INTO `user_account` VALUES ('4', '11', '0.00', '0.00', '0.00');
INSERT INTO `user_account` VALUES ('5', '12', '0.00', '0.00', '0.00');
INSERT INTO `user_account` VALUES ('6', '13', '0.00', '0.00', '0.00');
INSERT INTO `user_account` VALUES ('7', '14', '0.00', '0.00', '0.00');
INSERT INTO `user_account` VALUES ('8', '15', '0.00', '0.00', '0.00');
INSERT INTO `user_account` VALUES ('9', '16', '0.00', '0.00', '0.00');
INSERT INTO `user_account` VALUES ('10', '17', '0.00', '0.00', '0.00');

-- ----------------------------
-- Table structure for user_safety
-- ----------------------------
DROP TABLE IF EXISTS `user_safety`;
CREATE TABLE `user_safety` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `baseid` bigint(19) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `regtime` bigint(13) DEFAULT NULL,
  `regip` varchar(50) DEFAULT NULL,
  `errorcount` int(2) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `isdelete` int(1) DEFAULT NULL,
  `lastlogintime` bigint(13) DEFAULT NULL,
  `lastloginip` varchar(30) DEFAULT NULL,
  `isadmin` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_safety
-- ----------------------------
INSERT INTO `user_safety` VALUES ('3', '10', '$2a$10$ACjqzR0Ofpv7XhvFFjzX/.bp858SmLQWc/50UBpidlt2bb2oGv4cK', '1525962629832', '192.168.1.2', '0', '0', '0', '1529894542525', '116.30.192.154', '1');
INSERT INTO `user_safety` VALUES ('4', '11', '$2a$10$eL6LLzvX0CGQP2HOGtwNBueDsqrSsBZOJ6c7F1OsrpRr/OhNWquRe', '1525966002464', '192.168.1.2', '0', '0', '0', '1531303965923', '192.168.0.135', '1');
INSERT INTO `user_safety` VALUES ('5', '12', '$2a$10$AS4A.9EHQRSKI6ricrzjceAvvcBl/Xz8q4mEgzDeEPiqQ.Nt3M3Ka', '1529922798913', '113.116.158.149', '0', '0', '0', '1532078982127', '192.168.0.135', '0');
INSERT INTO `user_safety` VALUES ('6', '13', '$2a$10$Aya1mS17TevU.o7YMTvrH.enAL6QYnTDSaTgjvzld7SFi8gzL47i.', '1529923467671', '113.116.158.149', '0', '0', '0', null, null, '0');
INSERT INTO `user_safety` VALUES ('7', '14', '$2a$10$KuyN5c29G/YJaMVSayTksuEhE3vx2sx.vYuIVnWup2A.aV4E7rO4C', '1531304039336', '192.168.0.135', '0', '0', '0', null, null, '0');
INSERT INTO `user_safety` VALUES ('8', '15', '$2a$10$gFy5fwAvRWQtkkIT2muDrO3jQWvOqmEwl/ZsrFPaAaAwovQ/wGaJC', '1531304039369', '192.168.0.135', '0', '0', '0', null, null, '0');
INSERT INTO `user_safety` VALUES ('9', '16', '$2a$10$g5Yo5VgJooF9ucCmllJEDuGsV8Jf3SWkG7nM/7ZnFAYYWs77P8z4S', '1531304577046', '192.168.0.135', '0', '0', '0', null, null, '0');
INSERT INTO `user_safety` VALUES ('10', '17', '$2a$10$C0WGKkrMDNXvvvIj1.o5V.yK50TYMVHmPYVyFkCXWM/lguYVA.aPq', '1531305478416', '192.168.0.135', '0', '0', '0', null, null, '0');

-- ----------------------------
-- Table structure for web_forum_forum
-- ----------------------------
DROP TABLE IF EXISTS `web_forum_forum`;
CREATE TABLE `web_forum_forum` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `fid` bigint(19) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  `addtime` bigint(13) DEFAULT NULL,
  `addbaseid` bigint(19) DEFAULT NULL,
  `updatetime` bigint(19) DEFAULT NULL,
  `updatebaseid` bigint(19) DEFAULT NULL,
  `isshow` int(1) DEFAULT NULL,
  `isdelete` int(1) DEFAULT NULL,
  `sort` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_forum_forum
-- ----------------------------
