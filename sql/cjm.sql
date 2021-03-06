/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : cjm

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2018-08-25 12:30:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `forum_attachment`
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

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
INSERT INTO `forum_attachment` VALUES ('10', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('11', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('12', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('13', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('14', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('15', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('16', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('17', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('18', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('19', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('20', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('21', '18', '15', '999999', '8', '0');
INSERT INTO `forum_attachment` VALUES ('22', '19', '16', '999999', '9', '0');
INSERT INTO `forum_attachment` VALUES ('23', '19', '16', '999999', '9', '0');
INSERT INTO `forum_attachment` VALUES ('24', '19', '16', '10', '9', '0');
INSERT INTO `forum_attachment` VALUES ('25', '47', '44', '999999', '7', '0');
INSERT INTO `forum_attachment` VALUES ('26', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('27', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('28', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('29', '0', '0', '999999', '127', '0');
INSERT INTO `forum_attachment` VALUES ('30', '0', '0', '999999', '127', '0');

-- ----------------------------
-- Table structure for `forum_attachment_0`
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
  `isdelete` int(1) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_0
-- ----------------------------

-- ----------------------------
-- Table structure for `forum_attachment_1`
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
  `isdelete` int(1) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_1
-- ----------------------------
INSERT INTO `forum_attachment_1` VALUES ('7', '11', '8', '999999', '1528039085267', 'QQ图片20180602214630.png', '37920', 'group1/M00/00/01/rBKphlsUByeAOKHOAACUIDGLrgE684.png', 'group1/M00/00/01/rBKphlsUByeAOKHOAACUIDGLrgE684_200x80.png', '', '0', '', '0', '0', '1', '1218', null, '1');
INSERT INTO `forum_attachment_1` VALUES ('8', '11', '8', '10', '1528039130966', 'VID20180603230811.mp4', '10265716', 'group1/M00/00/01/rBKphlsUB0yAf5C7AJykdAReKkA560.mp4', null, null, '0', '', '0', '0', '2', null, null, '1');

-- ----------------------------
-- Table structure for `forum_attachment_2`
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
  `isdelete` int(1) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_2
-- ----------------------------
INSERT INTO `forum_attachment_2` VALUES ('9', '12', '9', '10', '1528041679551', 'VID20180603230811.mp4', '10265716', 'group1/M00/00/01/rBKphlsUEUuAKnA9AJykdAReKkA204.mp4', null, null, '0', '', '0', '0', '2', null, null, null);

-- ----------------------------
-- Table structure for `forum_attachment_3`
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
  `isdelete` int(1) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_3
-- ----------------------------

-- ----------------------------
-- Table structure for `forum_attachment_4`
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
  `isdelete` int(1) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_4
-- ----------------------------

-- ----------------------------
-- Table structure for `forum_attachment_5`
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
  `isdelete` int(1) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_5
-- ----------------------------

-- ----------------------------
-- Table structure for `forum_attachment_6`
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
  `isdelete` int(1) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_6
-- ----------------------------

-- ----------------------------
-- Table structure for `forum_attachment_7`
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
  `isdelete` int(1) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_7
-- ----------------------------
INSERT INTO `forum_attachment_7` VALUES ('25', '47', '44', '999999', '1533019582092', '010305k4iyl5yywqy5h5qd.jpg', '58547', 'group1/M00/00/01/rBKphltsFJCAHTAZAAH2zm9o7qQ028.png', 'group1/M00/00/01/rBKphltsFJCAHTAZAAH2zm9o7qQ028_200x80.png', '', '0', '', '0', '0', '1', '638', null, '0');

-- ----------------------------
-- Table structure for `forum_attachment_8`
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
  `isdelete` int(1) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_8
-- ----------------------------
INSERT INTO `forum_attachment_8` VALUES ('21', '18', '15', '999999', '1532688149757', 'PC_创建资源一级V0530.png', '128718', 'group1/M00/00/4F/rBMV6Vta9xiAbd_2AAH2zm9o7qQ808.png', 'group1/M00/00/4F/rBMV6Vta9xiAbd_2AAH2zm9o7qQ808_200x80.png', '', '0', '', '0', '0', '1', '1562', null, null);

-- ----------------------------
-- Table structure for `forum_attachment_9`
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
  `isdelete` int(1) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_attachment_9
-- ----------------------------
INSERT INTO `forum_attachment_9` VALUES ('22', '19', '16', '999999', '1532688459449', '资源方-渠道方申请提示页面V180507.png', '40012', 'group1/M00/00/4F/rBMV6Vta-E6ANHtbAACcTGfVsvc729.png', 'group1/M00/00/4F/rBMV6Vta-E6ANHtbAACcTGfVsvc729_200x80.png', '', '0', '', '0', '0', '1', '587', null, '1');
INSERT INTO `forum_attachment_9` VALUES ('23', '19', '16', '999999', '1532688464272', '资源管理V0518.png', '85738', 'group1/M00/00/4F/rBMV6Vta-FOAOfWeAAFO6o2PjEU622.png', 'group1/M00/00/4F/rBMV6Vta-FOAOfWeAAFO6o2PjEU622_200x80.png', '', '0', '', '0', '0', '1', '1869', null, '1');
INSERT INTO `forum_attachment_9` VALUES ('24', '19', '16', '10', '1532688709694', '46aa177bc78d232ce7341dc15e83b0c6.mp4', '15905984', 'group1/M00/00/4F/rBMV6Vta-UiAJ943243243231.mp4', null, null, '0', '', '0', '0', '2', null, null, '1');

-- ----------------------------
-- Table structure for `forum_attachment_unused`
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
INSERT INTO `forum_attachment_unused` VALUES ('10', null, null, '999999', '1532673990632', '001149bzcvcnppj9k9e98j.gif', '81199', 'group1/M00/00/4F/rBMV6Vtav8iAKmHxAAE9L-0bNgU511.gif', 'group1/M00/00/4F/rBMV6Vtav8iAKmHxAAE9L-0bNgU511_200x80.gif', '', '0', null, null, null, '1', '960');
INSERT INTO `forum_attachment_unused` VALUES ('11', null, null, '999999', '1532674378753', '122654dh11h1hppuxbucxp.jpg', '41494', 'group1/M00/00/4F/rBMV6VtawU2AaREyAACiFvMrg30553.jpg', 'group1/M00/00/4F/rBMV6VtawU2AaREyAACiFvMrg30553_200x80.jpg', '', '0', null, null, null, '1', '1000');
INSERT INTO `forum_attachment_unused` VALUES ('12', null, null, '999999', '1532675996246', '122654dh11h1hppuxbucxp.jpg', '41494', 'group1/M00/00/4F/rBMV6Vtax5-AdE3cAACiFvMrg30224.jpg', 'group1/M00/00/4F/rBMV6Vtax5-AdE3cAACiFvMrg30224_200x80.jpg', '', '0', null, null, null, '1', '1000');
INSERT INTO `forum_attachment_unused` VALUES ('13', null, null, '999999', '1532676487866', '122654dh11h1hppuxbucxp.jpg', '41494', 'group1/M00/00/4F/rBMV6VtayYuAer5UAACiFvMrg30524.jpg', 'group1/M00/00/4F/rBMV6VtayYuAer5UAACiFvMrg30524_200x80.jpg', '', '0', null, null, null, '1', '1000');
INSERT INTO `forum_attachment_unused` VALUES ('14', null, null, '999999', '1532677284823', '122654dh11h1hppuxbucxp.jpg', '41494', 'group1/M00/00/4F/rBMV6VtazKiASaA0AACiFvMrg30489.jpg', 'group1/M00/00/4F/rBMV6VtazKiASaA0AACiFvMrg30489_200x80.jpg', '', '0', null, null, null, '1', '1000');
INSERT INTO `forum_attachment_unused` VALUES ('15', null, null, '999999', '1532677301851', '122654dh11h1hppuxbucxp.jpg', '41494', 'group1/M00/00/4F/rBMV6VtazLmAZ6cEAACiFvMrg30408.jpg', 'group1/M00/00/4F/rBMV6VtazLmAZ6cEAACiFvMrg30408_200x80.jpg', '', '0', null, null, null, '1', '1000');
INSERT INTO `forum_attachment_unused` VALUES ('16', null, null, '999999', '1532677315630', '122654dh11h1hppuxbucxp.jpg', '41494', 'group1/M00/00/4F/rBMV6VtazMeANKwqAACiFvMrg30173.jpg', 'group1/M00/00/4F/rBMV6VtazMeANKwqAACiFvMrg30173_200x80.jpg', '', '0', null, null, null, '1', '1000');
INSERT INTO `forum_attachment_unused` VALUES ('17', null, null, '999999', '1532679473700', '122512yk7rzfrj7ztfyzzr.jpg', '25754', 'group1/M00/00/4F/rBMV6Vta1TWAN5fdAABkmsot6i8271.jpg', 'group1/M00/00/4F/rBMV6Vta1TWAN5fdAABkmsot6i8271_200x80.jpg', '', '0', null, null, null, '1', '1000');
INSERT INTO `forum_attachment_unused` VALUES ('18', null, null, '999999', '1532683556819', '122654dh11h1hppuxbucxp.jpg', '41494', 'group1/M00/00/4F/rBMV6Vta5SiAF05zAACiFvMrg30065.jpg', 'group1/M00/00/4F/rBMV6Vta5SiAF05zAACiFvMrg30065_200x80.jpg', '', '0', null, null, null, '1', '1000');
INSERT INTO `forum_attachment_unused` VALUES ('19', null, null, '999999', '1532683565306', '122654dh11h1hppuxbucxp.jpg', '41494', 'group1/M00/00/4F/rBMV6Vta5TCAYvfBAACiFvMrg30779.jpg', 'group1/M00/00/4F/rBMV6Vta5TCAYvfBAACiFvMrg30779_200x80.jpg', '', '0', null, null, null, '1', '1000');
INSERT INTO `forum_attachment_unused` VALUES ('20', null, null, '999999', '1532686249228', '01发帖.png', '63343', 'group1/M00/00/4F/rBMV6Vta76yAcv1WAAD3b2XOn7c527.png', 'group1/M00/00/4F/rBMV6Vta76yAcv1WAAD3b2XOn7c527_200x80.png', '', '0', null, null, null, '1', '750');
INSERT INTO `forum_attachment_unused` VALUES ('26', null, null, '999999', '1533020551894', '010305k4iyl5yywqy5h5qd.jpg', '58547', 'group1/M00/00/4F/rBMV6VtgCYiASsNJAADks5uFQOw076.jpg', 'group1/M00/00/4F/rBMV6VtgCYiASsNJAADks5uFQOw076_200x80.jpg', '', '0', null, null, null, '1', '638');
INSERT INTO `forum_attachment_unused` VALUES ('27', null, null, '999999', '1533021019166', '010305k4iyl5yywqy5h5qd.jpg', '58547', 'group1/M00/00/4F/rBMV6VtgC1uAMDizAADks5uFQOw818.jpg', 'group1/M00/00/4F/rBMV6VtgC1uAMDizAADks5uFQOw818_200x80.jpg', '', '0', null, null, null, '1', '638');
INSERT INTO `forum_attachment_unused` VALUES ('28', null, null, '999999', '1533021193951', '010305k4iyl5yywqy5h5qd.jpg', '58547', 'group1/M00/00/4F/rBMV6VtgDAqAClrcAADks5uFQOw374.jpg', 'group1/M00/00/4F/rBMV6VtgDAqAClrcAADks5uFQOw374_200x80.jpg', '', '0', null, null, null, '1', '638');
INSERT INTO `forum_attachment_unused` VALUES ('29', null, null, '999999', '1533021295256', '010305g8kipgkoxph1o0xp.png', '25990', 'group1/M00/00/4F/rBMV6VtgDG-AU_6iAABlhgKZH3g485.png', 'group1/M00/00/4F/rBMV6VtgDG-AU_6iAABlhgKZH3g485_200x80.png', '', '0', null, null, null, '1', '870');
INSERT INTO `forum_attachment_unused` VALUES ('30', null, null, '999999', '1533021408819', '010305g8kipgkoxph1o0xp.png', '25990', 'group1/M00/00/4F/rBMV6VtgDOGAZuXIAABlhgKZH3g745.png', 'group1/M00/00/4F/rBMV6VtgDOGAZuXIAABlhgKZH3g745_200x80.png', '', '0', null, null, null, '1', '870');

-- ----------------------------
-- Table structure for `forum_forum`
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_forum
-- ----------------------------
INSERT INTO `forum_forum` VALUES ('2', '4566', '1', '2', '2', '1527784216142', '10', '1532915009533', '12', '0', '100');
INSERT INTO `forum_forum` VALUES ('3', 'golang', '1', '0', '0', '1528000072569', '10', '1532590049333', '12', '0', '0');
INSERT INTO `forum_forum` VALUES ('4', 'javascript', '1', '0', '0', '1528000080864', '10', '1532590046542', '12', '0', '0');
INSERT INTO `forum_forum` VALUES ('5', '关于我', '1', '0', '0', '1528000092116', '10', '1532590035415', '12', '0', '2');
INSERT INTO `forum_forum` VALUES ('6', '首页', '1', '0', '0', '1528000098384', '10', null, null, '0', '10');
INSERT INTO `forum_forum` VALUES ('7', '相册', '1', '0', '0', '1528000107713', '10', null, null, '0', '0');
INSERT INTO `forum_forum` VALUES ('8', '视频', '1', '0', '0', '1528000117318', '10', null, null, '0', '0');
INSERT INTO `forum_forum` VALUES ('9', '音乐', '1', '0', '0', '1528000126932', '10', null, null, '0', '1');
INSERT INTO `forum_forum` VALUES ('10', 'java22', '1', '0', '0', '1528214934683', '10', '1532590031297', '12', '0', '0');
INSERT INTO `forum_forum` VALUES ('11', 'java123', '0', '0', '0', '1532400493852', '12', '1532572241876', '12', '0', '0');
INSERT INTO `forum_forum` VALUES ('12', 'java', '1', '0', '0', '1532400642191', '12', '1532572219256', '12', '0', '0');
INSERT INTO `forum_forum` VALUES ('13', 'GOGOGO', '0', '0', '0', '1532575111490', '12', '1532575148716', '12', '0', '0');
INSERT INTO `forum_forum` VALUES ('14', '212', '1', '0', '0', '1532575163532', '12', null, null, '0', '12');
INSERT INTO `forum_forum` VALUES ('15', '12', '1', '0', '0', '1532575178606', '12', null, null, '0', '12');
INSERT INTO `forum_forum` VALUES ('16', '456', '1', '0', '0', '1532576944422', '12', null, null, '0', '0');
INSERT INTO `forum_forum` VALUES ('17', '1111', '1', '0', '0', '1532871237901', '12', null, null, '0', '1');
INSERT INTO `forum_forum` VALUES ('18', 'java10232', '1', '0', '0', '1532915019827', '12', null, null, '0', '0');

-- ----------------------------
-- Table structure for `forum_post`
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
  `isdelete` int(1) DEFAULT NULL,
  `useip` varchar(50) DEFAULT NULL,
  `attachment` int(3) DEFAULT NULL,
  `usesig` int(1) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `updateline` bigint(13) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_post
-- ----------------------------
INSERT INTO `forum_post` VALUES ('1', '2', '2', '10', '20180603主题保存', '1212', '0', '0', null, '0', '0', null, '1532935779037');
INSERT INTO `forum_post` VALUES ('2', '2', '8', '10', '20180603主题保存', '今天是发个号日子啊', '0', '0', '192.168.1.5', '0', '0', null, null);
INSERT INTO `forum_post` VALUES ('4', '2', '4', '10', '20180603主题保存', '11', '0', '0', '192.168.1.5', '0', '0', null, '1532932877856');
INSERT INTO `forum_post` VALUES ('5', '7', '1', '10', '20180603主题保存', '11', '0', '0', '192.168.1.5', '0', '0', null, '1532933393261');
INSERT INTO `forum_post` VALUES ('8', '2', '11', '10', '20180603主题测试', '1212', '0', '0', '192.168.1.5', '0', '0', null, '1532942246311');
INSERT INTO `forum_post` VALUES ('9', '2', '12', '10', '20180603主题测试', '的说法是的范德萨[attach]9[/attach]', '0', '0', '192.168.1.5', '1', '0', null, null);
INSERT INTO `forum_post` VALUES ('10', '2', '13', '10', '测试主题', '的范德萨范德萨', '0', '0', '192.168.1.5', '0', '0', null, null);
INSERT INTO `forum_post` VALUES ('11', '2', '14', '13', '20180725', '1231313', '0', '0', '192.168.0.135', '0', '0', null, null);
INSERT INTO `forum_post` VALUES ('12', '3', '15', '12', '12321', '<p>23</p>', '0', '0', '192.168.0.135', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('13', '3', '16', '12', '12321', '<p>23</p>', '0', '0', '192.168.0.135', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('14', '3', '17', '12', '12321', '<p>23<img src=\"http://image.wangdaibus.com/group1/M00/00/4F/rBMV6Vta9xiAbd_2AAH2zm9o7qQ808_200x80.png\" title=\"PC_创建资源一级V0530.png\" alt=\"PC_创建资源一级V0530.png\"/>是的撒的是的撒的地方大幅度</p>', '0', '0', '192.168.0.135', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('15', '3', '18', '12', '12321', '<p>23[attach]21[/attach]是的撒的是的撒的地方大幅度</p>', '0', '0', '192.168.0.135', '1', '1', null, null);
INSERT INTO `forum_post` VALUES ('16', '7', '19', '12', '测试测试', '11', '0', '0', '192.168.0.135', '0', '1', null, '1532933446938');
INSERT INTO `forum_post` VALUES ('17', '3', '20', '12', 'sdsdsdsdsd', '<p>sdsdssdsd</p>', '0', '0', '192.168.0.135', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('18', '3', '21', '12', '20180729', '<p>1111111111111111111111111111111</p>', '0', '0', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('19', '3', '22', '12', '20180729', '<p>1111111111111111111111111111111</p>', '0', '0', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('20', '3', '23', '12', '20180729', '<p>1111111111111111111111111111111</p>', '0', '0', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('21', '3', '24', '12', '20180729', '<p>1111111111111111111111111111111</p>', '0', '0', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('22', '3', '25', '12', '20180729', '<p>1111111111111111111111111111111</p>', '0', '0', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('23', '3', '26', '12', '20180729', '<p>23<img src=\"http://image.wangdaibus.com/group1/M00/00/4F/rBMV6Vta9xiAbd_2AAH2zm9o7qQ808.png\" title=\"PC_创建资源一级V0530.png\" alt=\"PC_创建资源一级V0530.png\"/>是的撒的是的撒的地方大幅度</p>', '0', '0', '192.168.1.2', '0', '1', '1532935779037', null);
INSERT INTO `forum_post` VALUES ('24', '3', '27', '12', '20180729', '<p>1111111111111111111111111111111</p>', '-2', '1', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('25', '3', '28', '12', '20180729', '<p>1111111111111111111111111111111</p>', '-2', '1', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('26', '3', '29', '12', '20180729', '<p>1111111111111111111111111111111</p>', '-2', '1', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('27', '3', '30', '12', '20180729', '<p>1111111111111111111111111111111</p>', '-2', '1', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('28', '3', '31', '12', '20180729', '<p>1111111111111111111111111111111</p>', '-2', '1', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('29', '3', '32', '12', '20180729', '<p>1111111111111111111111111111111</p>', '-2', '1', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('30', '3', '33', '12', '20180729', '<p>1111111111111111111111111111111</p>', '-2', '1', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('31', '3', '34', '12', '20180729', '<p>1111111111111111111111111111111</p>', '-2', '1', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('32', '3', '35', '12', '20180729', '<p>1111111111111111111111111111111</p>', '-2', '1', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('33', '3', '36', '12', '20180729', '<p>1111111111111111111111111111111</p>', '-2', '1', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('34', '3', '37', '12', '20180729', '<p>1111111111111111111111111111111</p>', '-2', '1', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('35', '3', '38', '12', '20180729', '<p>1111111111111111111111111111111</p>', '-2', '1', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('36', '3', '39', '12', '20180729', '<p>1111111111111111111111111111111</p>', '-2', '1', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('37', '3', '40', '12', '20180729', '<p>1111111111111111111111111111111</p>', '-2', '1', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('38', '3', '41', '12', '20180729', '<p>1111111111111111111111111111111</p>', '-2', '1', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('39', '3', '42', '12', '20180729主题测试', '<p>侧是是是所所所所</p>', '-2', '1', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('40', '3', '43', '12', '20180729主题测试', '<p>侧是是是所所所所</p>', '-2', '1', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('41', '3', '44', '12', '20180729主题测试', '<p>侧是是是所所所所</p>', '-2', '1', '192.168.1.2', '0', '1', null, null);
INSERT INTO `forum_post` VALUES ('42', '2', '45', '12', '20180729主题测试', '1212', '-2', '1', '192.168.1.2', '0', '1', null, '1532935255433');
INSERT INTO `forum_post` VALUES ('44', '3', '47', '12', '1212', '<p>[attach]25[/attach]</p>', '0', '0', '192.168.146.1', '1', '1', '1533019592706', null);
INSERT INTO `forum_post` VALUES ('45', '3', '48', '12', '测试文章', '<p>是范德萨发的说法<br/></p>', '0', '0', '192.168.0.135', '0', '1', '1533808769703', null);
INSERT INTO `forum_post` VALUES ('46', '9', '49', '12', '第三方的是非得失发的顺丰到付', '<p>发的发的辅导费的发的发的辅导费</p>', '0', '0', '192.168.0.135', '0', '1', '1533865839005', null);
INSERT INTO `forum_post` VALUES ('47', '15', '50', '12', '21212121212121', '<p>dfdfddfdsfdfdfd</p>', '0', '0', '192.168.0.135', '0', '1', '1533870561715', null);
INSERT INTO `forum_post` VALUES ('48', '2', '51', '12', '232321432432', '<p>32432432</p>', '0', '0', '192.168.0.135', '0', '1', '1533873802031', null);
INSERT INTO `forum_post` VALUES ('49', '2', '52', '12', '323', '<p>23232</p>', '0', '0', '192.168.0.135', '0', '1', '1533881203720', null);
INSERT INTO `forum_post` VALUES ('50', '2', '53', '12', '323', '<p>23232</p>', '0', '0', '192.168.0.135', '0', '1', '1533881208827', null);
INSERT INTO `forum_post` VALUES ('51', '14', '54', '12', '3213213213', '<p>213</p>', '0', '0', '192.168.0.135', '0', '0', '1533881258290', null);
INSERT INTO `forum_post` VALUES ('52', '2', '55', '12', '213123', '<p>2323</p>', '0', '0', '192.168.0.135', '0', '0', '1533881427574', null);
INSERT INTO `forum_post` VALUES ('53', '6', '56', '12', '今天真无聊', '<p>454dfsdfsdfdsf</p>', '0', '0', '192.168.0.135', '0', '1', '1533881464056', '1534694330969');
INSERT INTO `forum_post` VALUES ('54', '14', '57', '12', '12', '<p>12121</p>', '0', '0', '192.168.0.135', '0', '0', '1533881720006', null);
INSERT INTO `forum_post` VALUES ('55', '2', '58', '12', '323', '<p>32</p>', '0', '0', '192.168.0.135', '0', '1', '1533881875063', null);
INSERT INTO `forum_post` VALUES ('58', '5', '61', '12', '4545', '<p>4545<br/></p>', '0', '0', '192.168.1.3', '0', '0', '1534863678360', null);
INSERT INTO `forum_post` VALUES ('59', '17', '62', '12', 'fdsfd', 'undefined', '0', '0', '192.168.1.3', '0', '1', '1534866022908', null);
INSERT INTO `forum_post` VALUES ('60', '2', '63', '12', '打发第三方', '<p>项目用到了图片裁剪，折腾了几个小时，这里记录下，方便以后。</p><p><br/></p><p><br/></p><p><br/></p><p>官网示例链接：https://fengyuanchen.github.io/cropperjs/</p><p><br/></p><p><br/></p><p><br/></p><p>github源码链接：https://github.com/fengyuanchen/cropperjs</p><p><br/></p><p><br/></p><p><br/></p><p>图片上传到fastdfs 图片服务器，由于是远程图片，需要做点跨域处理。</p><p><br/></p><p><br/></p><p><br/></p><p>使用的cropperjs 版本为 1.4.1</p><p><br/></p><p><br/></p><p><br/></p><p>1 引进 cropper.css 和 cropper.js 资源文件</p><p><br/></p><p>', '0', '0', '192.168.1.3', '0', '1', '1534866199073', null);
INSERT INTO `forum_post` VALUES ('61', '2', '64', '12', '个梵蒂冈', '<p>项目用到了图片裁剪，折腾了几个小时，这里记录下，方便以后。</p><p><br/></p><p><br/></p><p><br/></p><p>官网示例链接：https://fengyuanchen.github.io/cropperjs/</p><p><br/></p><p><br/></p><p><br/></p><p>github源码链接：https://github.com/fengyuanchen/cropperjs</p><p><br/></p><p><br/></p><p><br/></p><p>图片上传到fastdfs 图片服务器，由于是远程图片，需要做点跨域处理。</p><p><br/></p><p><br/></p><p><br/></p><p>使用的cropperjs 版本为 1.4.1</p><p><br/></p><p><br/></p><p><br/></p><p>1 引进 cropper.css 和 cropper.js 资源文件</p><p><br/></p><p>', '0', '0', '192.168.1.3', '0', '1', '1534866432239', null);
INSERT INTO `forum_post` VALUES ('62', '17', '65', '12', '大幅度发', '<p>项目用到了图片裁剪，折腾了几个小时，这里记录下，方便以后。</p><p><br/></p><p><br/></p><p><br/></p><p>官网示例链接：https://fengyuanchen.github.io/cropperjs/</p><p><br/></p><p><br/></p><p><br/></p><p>github源码链接：https://github.com/fengyuanchen/cropperjs</p><p><br/></p><p><br/></p><p><br/></p><p>图片上传到fastdfs 图片服务器，由于是远程图片，需要做点跨域处理。</p><p><br/></p><p><br/></p><p><br/></p><p>使用的cropperjs 版本为 1.4.1</p><p><br/></p><p><br/></p><p><br/></p><p>1 引进 cropper.css 和 cropper.js 资源文件</p><p><br/></p><p>&lt;link href=&quot;${basePath }/static/plugin/cropper/cropper.css&quot;</p><p>rel=&quot;stylesheet&quot; type=&quot;text/css&quot;&gt;</p><p>&lt;script type=&quot;text/javascript&quot;</p><p>src=&quot;${basePath}/static/plugin/cropper/cropper.js&quot;&gt;&lt;/script&gt;</p><p><br/></p><p><br/></p><p>2 div代码：</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p>//标注 =&gt; 替换裁剪图片</p><p><br/></p><p>cropper.replace(&quot;https://fengyuanchen.github.io/cropperjs/images/picture.jpg&quot;);</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p>', '0', '0', '192.168.1.3', '0', '0', '1534866738688', '1534867164669');
INSERT INTO `forum_post` VALUES ('63', '5', '66', '12', 'dfds', '<p>dsfdsfdsfffffffffffffffffffffffffffffffffffffff</p>', '0', '0', '192.168.1.3', '0', '1', '1534867194284', null);

-- ----------------------------
-- Table structure for `forum_thread`
-- ----------------------------
DROP TABLE IF EXISTS `forum_thread`;
CREATE TABLE `forum_thread` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `fid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `coverimg` varchar(255) DEFAULT NULL,
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
  `upbaseid` bigint(19) DEFAULT NULL,
  `moderatline` bigint(13) DEFAULT NULL,
  `staticlink` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_thread
-- ----------------------------
INSERT INTO `forum_thread` VALUES ('1', '7', '10', null, '121211232112321123211232112321', '1528030711528', null, null, '0', '0', '0', '0', '1', '1', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('2', '2', '11', null, '121212321123211232112321123211232112321', '1528030842399', null, null, '4', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('4', '7', '12', null, '121211232112321123211232112321', '1528031111765', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('8', '2', '10', null, '20180603主题保存13', '1528033027619', null, null, '5', '0', '0', '2', '1', '2', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('11', '2', '17', null, '1212', '1528043945238', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('12', '2', '10', null, '20180603主题测试8', '1528044014770', null, null, '0', '0', '0', '2', '1', '3', '0', '0', '0', '0', '0', '0', '3', null, null, 'pages/2018/08/19/9DZcdpTtebGYyWaBFI6w-12.html');
INSERT INTO `forum_thread` VALUES ('13', '6', '13', null, '测试主题', '1528044161938', null, null, '0', '9', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '3', null, null, null);
INSERT INTO `forum_thread` VALUES ('14', '2', '13', null, '20180725', '1532490056425', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('15', '3', '12', null, '12321', '1532688081320', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('16', '3', '12', null, '12321', '1532688101463', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('17', '3', '13', null, '1232112321123211232112321123211232112321', '1532688158927', null, null, '456', '45', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, 'pages/2018/08/19/XykPG369CUtDIB7siVq5-17.html');
INSERT INTO `forum_thread` VALUES ('18', '3', '13', null, '1232112321123211232112321123211232112321', '1532689045954', null, null, '13', '14', '0', '2', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('19', '7', '12', null, '1212112321123211232112321123211232112321', '1532689045954', null, null, '10', '11', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('20', '3', '12', null, 'sdsdsdsdsd12321123211232112321123211232112321', '1532689045954', null, null, '12', '12', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('21', '3', '12', null, '20180729', '1532847258786', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('22', '3', '12', null, '20180729', '1532847263092', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('23', '3', '12', null, '20180729', '1532847264443', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('24', '3', '12', null, '20180729', '1532847264587', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('25', '3', '12', null, '20180729', '1532847264819', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('26', '3', '12', null, '20180729', '1532847265021', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('27', '3', '12', null, '20180729', '1532847265246', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('28', '3', '12', null, '20180729', '1532847265418', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('29', '3', '12', null, '20180729', '1532847265802', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('30', '3', '12', null, '20180729', '1532847266182', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('31', '3', '12', null, '20180729', '1532847266363', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('32', '3', '12', null, '20180729', '1532847266559', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('33', '3', '12', null, '20180729', '1532847266751', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('34', '3', '12', null, '20180729', '1532847266949', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('35', '3', '12', null, '20180729', '1532847267101', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('36', '3', '12', null, '20180729', '1532847267289', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('37', '3', '12', null, '20180729', '1532847267492', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('38', '3', '12', null, '20180729', '1532847267676', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('39', '3', '12', null, '20180729', '1532847267863', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('40', '3', '12', null, '20180729', '1532847268019', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('41', '3', '12', null, '20180729', '1532847268204', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('42', '3', '12', null, '20180729主题测试', '1532875048318', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('43', '3', '12', null, '20180729主题测试', '1532875228658', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('44', '3', '12', null, '20180729主题测试', '1532875239850', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('45', '2', '12', null, '1212', '1532875283541', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '-2', '1', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('47', '3', '12', null, '1212', '1533019592706', null, null, '0', '0', '0', '2', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('48', '3', '12', null, '测试文章', '1533808769703', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('49', '9', '12', null, '第三方的是非得失发的顺丰到付', '1533865839005', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('50', '15', '12', null, '21212121212121', '1533870561715', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('51', '2', '12', 'group1/M00/00/01/rBKphlttDnOAMIKrAAA0itDQK1w222.jpg', '232321432432', '1533873802031', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '2', null, null, null);
INSERT INTO `forum_thread` VALUES ('52', '2', '12', '', '323', '1533881203720', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '2', null, null, null);
INSERT INTO `forum_thread` VALUES ('53', '2', '12', '', '323', '1533881208827', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '2', null, null, null);
INSERT INTO `forum_thread` VALUES ('54', '14', '12', '', '3213213213', '1533881258290', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('55', '2', '12', '', '213123', '1533881427574', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('56', '6', '12', '', '今天真无聊4545', '1533881464056', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '2', null, null, 'pages/2018/08/19/m3K6UwHs8dayVrhBRtbL-56.html');
INSERT INTO `forum_thread` VALUES ('57', '14', '12', '', '12', '1533881720006', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('58', '2', '12', '', '323', '1533881875063', null, null, '0', '0', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', null, null, 'pages/2018/08/19/ve2tUbqWhCF3jTRwIZ4S-58.html');
INSERT INTO `forum_thread` VALUES ('61', '5', '12', null, '4545', '1534863678360', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('62', '17', '12', null, 'fdsfd', '1534866022908', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('63', '2', '12', null, '打发第三方', '1534866199073', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('64', '2', '12', null, '个梵蒂冈', '1534866432239', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);
INSERT INTO `forum_thread` VALUES ('65', '17', '12', null, '大幅度发erw', '1534866738688', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2', null, null, null);
INSERT INTO `forum_thread` VALUES ('66', '5', '12', '', 'dfds', '1534867194284', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', null, null, null);

-- ----------------------------
-- Table structure for `forum_thread_coverimg`
-- ----------------------------
DROP TABLE IF EXISTS `forum_thread_coverimg`;
CREATE TABLE `forum_thread_coverimg` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_thread_coverimg
-- ----------------------------
INSERT INTO `forum_thread_coverimg` VALUES ('1', 'group1/M00/00/01/rBKphlttB8WAN4cAAAA0itDQK1w189.jpg', '1533872065452', '0');
INSERT INTO `forum_thread_coverimg` VALUES ('2', 'group1/M00/00/01/rBKphlttC9uAIVdGAAA0itDQK1w413.jpg', '1533873111129', '0');
INSERT INTO `forum_thread_coverimg` VALUES ('3', 'group1/M00/00/01/rBKphlttDUGAJKFgAAA0itDQK1w131.jpg', '1533873469636', '0');
INSERT INTO `forum_thread_coverimg` VALUES ('4', 'group1/M00/00/01/rBKphlttDauAVUigAAA0itDQK1w991.jpg', '1533873575599', '0');
INSERT INTO `forum_thread_coverimg` VALUES ('5', 'group1/M00/00/01/rBKphlttDdWAX0nXAAA46qzAYXE626.png', '1533873617787', '0');
INSERT INTO `forum_thread_coverimg` VALUES ('6', 'group1/M00/00/01/rBKphlttDlSADawvAAA0itDQK1w523.jpg', '1533873744401', '0');
INSERT INTO `forum_thread_coverimg` VALUES ('7', 'group1/M00/00/01/rBKphlttDnOAMIKrAAA0itDQK1w222.jpg', '1533873775166', '1');
INSERT INTO `forum_thread_coverimg` VALUES ('8', 'group1/M00/00/01/rBKphlttKoOANoU9AAH2zm9o7qQ202.png', '1533880959315', '0');

-- ----------------------------
-- Table structure for `forum_thread_operation`
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
) ENGINE=MyISAM AUTO_INCREMENT=255 DEFAULT CHARSET=utf8;

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
INSERT INTO `forum_thread_operation` VALUES ('24', '2', '1', 'AUDITFA', '1532483569277', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('25', '2', '1', 'AUDITFA', '1532483589754', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('26', '2', '1', 'AUDITFA', '1532487411361', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('27', '2', '1', 'AUDITFA', '1532487670404', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('28', '2', '1', 'AUDITFA', '1532487685306', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('29', '4', '1', 'AUDITFA', '1532487685310', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('30', '12', '1', 'AUDITFA', '1532487685315', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('31', '1', '1', 'UPD', '1532487907555', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('32', '11', '1', 'UPD', '1532488064517', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('33', '12', '1', 'UPD', '1532488064524', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('34', '13', '1', 'UPD', '1532488064528', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('35', '11', '1', 'UPD', '1532488109978', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('36', '12', '1', 'UPD', '1532488109982', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('37', '13', '1', 'UPD', '1532488109986', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('38', '2', '1', 'AUDITFA', '1532488563812', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('39', '2', '1', 'AUDITFA', '1532488582642', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('40', '2', '1', 'AUDITFA', '1532488964271', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('41', '2', '1', 'AUDITFA', '1532488969672', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('42', '2', '1', 'UPD', '1532488992752', '13', 'bus0348', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('43', '2', '1', 'AUDITFA', '1532595060038', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('44', '8', '1', 'AUDITFA', '1532595115165', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('45', '14', '1', 'AUDITFA', '1532595119877', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('46', '14', '1', 'AUDITFA', '1532595123005', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('47', '14', '1', 'AUDITFA', '1532595125045', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('48', '14', '1', 'AUDITFA', '1532595126828', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('49', '14', '1', 'AUDITFA', '1532595128287', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('50', '14', '1', 'AUDITFA', '1532595130149', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('51', '14', '1', 'AUDITFA', '1532595134845', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('52', '14', '1', 'AUDITFA', '1532595138829', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('53', '14', '1', 'AUDITFA', '1532595141549', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('54', '14', '1', 'AUDITFA', '1532595143917', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('55', '14', '1', 'AUDITFA', '1532595145979', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('56', '2', '1', 'AUDITFA', '1532595599627', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('57', '4', '1', 'AUDITFA', '1532595599629', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('58', '8', '1', 'AUDITFA', '1532595599633', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('59', '12', '1', 'AUDITFA', '1532595599635', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('60', '2', '1', 'AUDITFA', '1532596067669', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('61', '8', '1', 'AUDITFA', '1532596071106', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('62', '15', '1', 'AUDITFA', '1532688218740', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('63', '16', '1', 'AUDITFA', '1532688218797', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('64', '17', '1', 'AUDITFA', '1532688218801', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('65', '19', '1', 'AUDITFA', '1532769003015', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('66', '18', '1', 'AUDITFA', '1532769854439', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('67', '20', '1', 'AUDITFA', '1532769854443', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('68', '2', '1', 'AUDITFA', '1532846702453', '12', 'bus5280', '192.168.1.2');
INSERT INTO `forum_thread_operation` VALUES ('69', '15', '1', 'AUDITFA', '1532846704567', '12', 'bus5280', '192.168.1.2');
INSERT INTO `forum_thread_operation` VALUES ('70', '1', '1', 'AUDITFA', '1532942742823', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('71', '2', '1', 'AUDITFA', '1532942743122', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('72', '4', '1', 'AUDITFA', '1532942743132', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('73', '11', '1', 'AUDITFA', '1532942743138', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('74', '19', '1', 'AUDITFA', '1532942743147', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('75', '21', '1', 'AUDITFA', '1532942743155', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('76', '22', '1', 'AUDITFA', '1532942743164', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('77', '23', '1', 'AUDITFA', '1532942743171', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('78', '24', '1', 'AUDITFA', '1532942743180', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('79', '25', '1', 'AUDITFA', '1532942743185', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('80', '26', '1', 'AUDITFA', '1532942743192', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('81', '27', '1', 'AUDITFA', '1532942743197', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('82', '28', '1', 'AUDITFA', '1532942743200', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('83', '29', '1', 'AUDITFA', '1532942743203', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('84', '30', '1', 'AUDITFA', '1532942743208', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('85', '31', '1', 'AUDITFA', '1532942743219', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('86', '32', '1', 'AUDITFA', '1532942743226', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('87', '33', '1', 'AUDITFA', '1532942743233', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('88', '34', '1', 'AUDITFA', '1532942743239', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('89', '35', '1', 'AUDITFA', '1532942743244', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('90', '36', '1', 'AUDITFA', '1532942747270', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('91', '37', '1', 'AUDITFA', '1532942747274', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('92', '38', '1', 'AUDITFA', '1532942747278', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('93', '39', '1', 'AUDITFA', '1532942747282', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('94', '40', '1', 'AUDITFA', '1532942747287', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('95', '41', '1', 'AUDITFA', '1532942747291', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('96', '42', '1', 'AUDITFA', '1532942747294', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('97', '43', '1', 'AUDITFA', '1532942747296', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('98', '44', '1', 'AUDITFA', '1532942747299', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('99', '45', '1', 'AUDITFA', '1532942747302', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('100', '2', '1', 'AUDITFA', '1532943340712', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('101', '11', '1', 'AUDITFA', '1532943352237', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('102', '12', '1', 'AUDITFA', '1532943440221', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('103', '13', '1', 'AUDITFA', '1532943440225', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('104', '14', '1', 'AUDITFA', '1532943440230', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('105', '15', '1', 'AUDITFA', '1532943440239', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('106', '18', '1', 'AUDITFA', '1532943440245', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('107', '20', '1', 'AUDITFA', '1532943440260', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('108', '1', '1', 'AUDITFA', '1532943444766', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('109', '4', '1', 'AUDITFA', '1532943444770', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('110', '8', '1', 'AUDITFA', '1532943444773', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('111', '16', '1', 'AUDITFA', '1532943444777', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('112', '17', '1', 'AUDITFA', '1532943444783', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('113', '19', '1', 'AUDITFA', '1532943444790', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('114', '21', '1', 'AUDITFA', '1532943444803', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('115', '22', '1', 'AUDITFA', '1532943444814', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('116', '23', '1', 'AUDITFA', '1532943444821', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('117', '24', '1', 'AUDITFA', '1532943444827', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('118', '25', '1', 'AUDITFA', '1532943444831', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('119', '26', '1', 'AUDITFA', '1532943444836', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('120', '27', '1', 'AUDITFA', '1532943444840', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('121', '28', '1', 'AUDITFA', '1532943444843', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('122', '29', '1', 'AUDITFA', '1532943444846', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('123', '30', '1', 'AUDITFA', '1532943444849', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('124', '31', '1', 'AUDITFA', '1532943444852', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('125', '32', '1', 'AUDITFA', '1532943444855', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('126', '33', '1', 'AUDITFA', '1532943444860', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('127', '34', '1', 'AUDITFA', '1532943444863', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('128', '12', '1', 'AUDITFA', '1532943448322', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('129', '13', '1', 'AUDITFA', '1532943448326', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('130', '14', '1', 'AUDITFA', '1532943448334', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('131', '15', '1', 'AUDITFA', '1532943448340', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('132', '18', '1', 'AUDITFA', '1532943448344', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('133', '20', '1', 'AUDITFA', '1532943448351', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('134', '35', '1', 'AUDITFA', '1532943448358', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('135', '36', '1', 'AUDITFA', '1532943448365', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('136', '37', '1', 'AUDITFA', '1532943448370', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('137', '38', '1', 'AUDITFA', '1532943448379', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('138', '39', '1', 'AUDITFA', '1532943448385', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('139', '40', '1', 'AUDITFA', '1532943448391', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('140', '41', '1', 'AUDITFA', '1532943448395', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('141', '42', '1', 'AUDITFA', '1532943448401', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('142', '43', '1', 'AUDITFA', '1532943448420', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('143', '44', '1', 'AUDITFA', '1532943448429', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('144', '45', '1', 'AUDITFA', '1532943448441', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('145', '47', '1', 'AUDITFA', '1533106237573', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('146', '1', '1', 'AUDITFA', '1533106257097', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('147', '2', '1', 'AUDITFA', '1533106257102', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('148', '4', '1', 'AUDITFA', '1533106257107', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('149', '8', '1', 'AUDITFA', '1533106257112', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('150', '11', '1', 'AUDITFA', '1533106257119', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('151', '12', '1', 'AUDITFA', '1533106257126', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('152', '13', '1', 'AUDITFA', '1533106257129', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('153', '14', '1', 'AUDITFA', '1533106257135', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('154', '15', '1', 'AUDITFA', '1533106257140', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('155', '16', '1', 'AUDITFA', '1533106257143', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('156', '17', '1', 'AUDITFA', '1533106257147', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('157', '18', '1', 'AUDITFA', '1533106257150', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('158', '19', '1', 'AUDITFA', '1533106257153', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('159', '20', '1', 'AUDITFA', '1533106257157', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('160', '21', '1', 'AUDITFA', '1533106257163', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('161', '22', '1', 'AUDITFA', '1533106257168', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('162', '23', '1', 'AUDITFA', '1533106257172', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('163', '24', '1', 'AUDITFA', '1533106257175', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('164', '25', '1', 'AUDITFA', '1533106257179', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('165', '26', '1', 'AUDITFA', '1533106257182', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('166', '27', '1', 'AUDITFA', '1533106267098', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('167', '28', '1', 'AUDITFA', '1533106267100', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('168', '29', '1', 'AUDITFA', '1533106267103', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('169', '30', '1', 'AUDITFA', '1533106267107', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('170', '31', '1', 'AUDITFA', '1533106267110', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('171', '32', '1', 'AUDITFA', '1533106267112', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('172', '33', '1', 'AUDITFA', '1533106267114', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('173', '34', '1', 'AUDITFA', '1533106267118', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('174', '35', '1', 'AUDITFA', '1533106267122', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('175', '36', '1', 'AUDITFA', '1533106267124', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('176', '37', '1', 'AUDITFA', '1533106267126', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('177', '38', '1', 'AUDITFA', '1533106267128', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('178', '39', '1', 'AUDITFA', '1533106267131', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('179', '40', '1', 'AUDITFA', '1533106267134', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('180', '41', '1', 'AUDITFA', '1533106267138', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('181', '42', '1', 'AUDITFA', '1533106267141', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('182', '43', '1', 'AUDITFA', '1533106267143', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('183', '44', '1', 'AUDITFA', '1533106267152', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('184', '45', '1', 'AUDITFA', '1533106267157', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('185', '1', '1', 'AUDITFA', '1533106323990', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('186', '2', '1', 'AUDITFA', '1533106323994', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('187', '4', '1', 'AUDITFA', '1533106324004', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('188', '8', '1', 'AUDITFA', '1533106324014', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('189', '11', '1', 'AUDITFA', '1533106324018', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('190', '12', '1', 'AUDITFA', '1533106324020', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('191', '13', '1', 'AUDITFA', '1533106324022', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('192', '14', '1', 'AUDITFA', '1533106324023', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('193', '15', '1', 'AUDITFA', '1533106324025', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('194', '16', '1', 'AUDITFA', '1533106324027', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('195', '17', '1', 'AUDITFA', '1533106324029', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('196', '18', '1', 'AUDITFA', '1533106324031', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('197', '19', '1', 'AUDITFA', '1533106324034', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('198', '20', '1', 'AUDITFA', '1533106324036', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('199', '21', '1', 'AUDITFA', '1533106324038', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('200', '22', '1', 'AUDITFA', '1533106324039', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('201', '23', '1', 'AUDITFA', '1533106324042', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('202', '24', '1', 'AUDITFA', '1533106324043', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('203', '25', '1', 'AUDITFA', '1533106324045', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('204', '26', '1', 'AUDITFA', '1533106324047', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('205', '27', '1', 'AUDITFA', '1533106324049', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('206', '28', '1', 'AUDITFA', '1533106324051', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('207', '29', '1', 'AUDITFA', '1533106324053', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('208', '30', '1', 'AUDITFA', '1533106324057', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('209', '31', '1', 'AUDITFA', '1533106324060', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('210', '32', '1', 'AUDITFA', '1533106324063', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('211', '33', '1', 'AUDITFA', '1533106324065', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('212', '34', '1', 'AUDITFA', '1533106324068', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('213', '35', '1', 'AUDITFA', '1533106324071', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('214', '36', '1', 'AUDITFA', '1533106324074', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('215', '37', '1', 'AUDITFA', '1533106324077', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('216', '38', '1', 'AUDITFA', '1533106324082', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('217', '39', '1', 'AUDITFA', '1533106324085', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('218', '40', '1', 'AUDITFA', '1533106324088', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('219', '41', '1', 'AUDITFA', '1533106324090', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('220', '42', '1', 'AUDITFA', '1533106324093', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('221', '43', '1', 'AUDITFA', '1533106324096', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('222', '44', '1', 'AUDITFA', '1533106324098', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('223', '45', '1', 'AUDITFA', '1533106324101', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('224', '47', '1', 'AUDITFA', '1533106324105', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('225', '27', '1', 'AUDITFA', '1533106352201', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('226', '28', '1', 'AUDITFA', '1533106352205', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('227', '29', '1', 'AUDITFA', '1533106352208', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('228', '30', '1', 'AUDITFA', '1533106352210', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('229', '31', '1', 'AUDITFA', '1533106352212', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('230', '32', '1', 'AUDITFA', '1533106352214', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('231', '33', '1', 'AUDITFA', '1533106352216', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('232', '34', '1', 'AUDITFA', '1533106352219', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('233', '35', '1', 'AUDITFA', '1533106352221', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('234', '36', '1', 'AUDITFA', '1533106352223', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('235', '37', '1', 'AUDITFA', '1533106352225', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('236', '38', '1', 'AUDITFA', '1533106352229', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('237', '39', '1', 'AUDITFA', '1533106352231', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('238', '40', '1', 'AUDITFA', '1533106352234', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('239', '41', '1', 'AUDITFA', '1533106352236', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('240', '42', '1', 'AUDITFA', '1533106352239', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('241', '43', '1', 'AUDITFA', '1533106352240', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('242', '44', '1', 'AUDITFA', '1533106352242', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('243', '45', '1', 'AUDITFA', '1533106352245', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('244', '48', '1', 'AUDITFA', '1533865864765', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('245', '49', '1', 'AUDITFA', '1533865864848', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('246', '50', '1', 'AUDITFA', '1533870577727', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('247', '51', '1', 'AUDITFA', '1533873911432', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('248', '52', '1', 'AUDITFA', '1533881944391', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('249', '53', '1', 'AUDITFA', '1533881944397', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('250', '54', '1', 'AUDITFA', '1533881944401', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('251', '55', '1', 'AUDITFA', '1533881944404', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('252', '56', '1', 'AUDITFA', '1533881944407', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('253', '57', '1', 'AUDITFA', '1533881944409', '12', 'bus5280', '192.168.0.135');
INSERT INTO `forum_thread_operation` VALUES ('254', '58', '1', 'AUDITFA', '1533881944415', '12', 'bus5280', '192.168.0.135');

-- ----------------------------
-- Table structure for `forum_thread_reply`
-- ----------------------------
DROP TABLE IF EXISTS `forum_thread_reply`;
CREATE TABLE `forum_thread_reply` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `first` int(1) DEFAULT NULL,
  `parentid` bigint(19) DEFAULT NULL,
  `firstmark` varchar(100) DEFAULT NULL,
  `tid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `tbaseid` bigint(19) DEFAULT NULL,
  `datetime` bigint(13) DEFAULT NULL,
  `message` mediumtext,
  `userip` varchar(40) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `like` int(6) DEFAULT NULL,
  `hate` int(6) DEFAULT NULL,
  `isdelete` int(1) DEFAULT NULL,
  `opermanid` bigint(19) DEFAULT NULL,
  `operdatetime` bigint(13) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_thread_reply
-- ----------------------------
INSERT INTO `forum_thread_reply` VALUES ('14', '1', '0', '20180801170002868424', '11', '13', '17', '1533114002902', '评论测试12', '192.168.0.135', '-1', '0', '0', '0', null, null, null);
INSERT INTO `forum_thread_reply` VALUES ('15', '1', '0', '20180801170003155342', '11', '13', '17', '1533114003640', '评论测试12', '192.168.0.135', '-1', '0', '0', '0', null, null, null);
INSERT INTO `forum_thread_reply` VALUES ('16', '1', '0', '20180801170004788664', '11', '13', '17', '1533114004129', '评论测试12', '192.168.0.135', '-1', '0', '0', '0', null, null, null);
INSERT INTO `forum_thread_reply` VALUES ('17', '1', '0', '20180801170004841337', '11', '13', '17', '1533114004502', '评论测试12', '192.168.0.135', '-1', '0', '0', '0', null, null, null);
INSERT INTO `forum_thread_reply` VALUES ('18', '1', '0', '20180801170004982437', '11', '13', '17', '1533114004867', '评论测试12', '192.168.0.135', '-1', '0', '0', '0', null, null, null);
INSERT INTO `forum_thread_reply` VALUES ('19', '1', '0', '20180801170005516111', '11', '13', '17', '1533114005219', '评论测试12', '192.168.0.135', '-1', '0', '0', '0', null, null, null);
INSERT INTO `forum_thread_reply` VALUES ('20', '1', '0', '20180801170005942918', '11', '13', '17', '1533114005575', '评论测试12', '192.168.0.135', '-1', '0', '0', '0', null, null, null);
INSERT INTO `forum_thread_reply` VALUES ('21', '1', '0', '20180801170006222290', '11', '13', '17', '1533114006172', '评论测试12', '192.168.0.135', '-1', '0', '0', '0', null, null, null);
INSERT INTO `forum_thread_reply` VALUES ('22', '1', '0', '20180801170006504839', '11', '13', '17', '1533114006497', '评论测试12', '192.168.0.135', '-1', '0', '0', '0', null, null, null);

-- ----------------------------
-- Table structure for `forum_thread_reply_attach`
-- ----------------------------
DROP TABLE IF EXISTS `forum_thread_reply_attach`;
CREATE TABLE `forum_thread_reply_attach` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `replyid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `attach` varchar(255) DEFAULT NULL,
  `thumbattach` varchar(255) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `filesize` int(11) DEFAULT NULL,
  `isdelete` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_thread_reply_attach
-- ----------------------------
INSERT INTO `forum_thread_reply_attach` VALUES ('1', '22', '13', '1533012467826', '1', 'group1/M00/00/4F/rBMV6Vtf6fSAXPH6AADks5uFQOw784.jpg', 'group1/M00/00/4F/rBMV6Vtf6fSAXPH6AADks5uFQOw784_200x80.jpg', '010305k4iyl5yywqy5h5qd.jpg', '58547', '0');
INSERT INTO `forum_thread_reply_attach` VALUES ('2', '22', '13', '1533018131739', '1', 'group1/M00/00/4F/rBMV6VtgABSAZio8AADks5uFQOw878.jpg', 'group1/M00/00/4F/rBMV6VtgABSAZio8AADks5uFQOw878_200x80.jpg', '010305k4iyl5yywqy5h5qd.jpg', '58547', '0');
INSERT INTO `forum_thread_reply_attach` VALUES ('3', '10', '999999', '1533018212684', '1', 'group1/M00/00/4F/rBMV6VtgAGSAPAB3AADks5uFQOw585.jpg', 'group1/M00/00/4F/rBMV6VtgAGSAPAB3AADks5uFQOw585_200x80.jpg', '010305k4iyl5yywqy5h5qd.jpg', '58547', '1');
INSERT INTO `forum_thread_reply_attach` VALUES ('4', '10', '999999', '1533018234098', '1', 'group1/M00/00/4F/rBMV6VtgAHqAHP1UAADks5uFQOw459.jpg', 'group1/M00/00/4F/rBMV6VtgAHqAHP1UAADks5uFQOw459_200x80.jpg', '010305k4iyl5yywqy5h5qd.jpg', '58547', '1');
INSERT INTO `forum_thread_reply_attach` VALUES ('5', '9', '999999', '1533018264726', '1', 'group1/M00/00/4F/rBMV6VtgAJmAbfUCAADks5uFQOw177.jpg', 'group1/M00/00/4F/rBMV6VtgAJmAbfUCAADks5uFQOw177_200x80.jpg', '010305k4iyl5yywqy5h5qd.jpg', '58547', '1');
INSERT INTO `forum_thread_reply_attach` VALUES ('6', '9', '999999', '1533019258646', '1', 'group1/M00/00/4F/rBMV6VtgBHuAHSsxAADks5uFQOw170.jpg', 'group1/M00/00/4F/rBMV6VtgBHuAHSsxAADks5uFQOw170_200x80.jpg', '010305k4iyl5yywqy5h5qd.jpg', '58547', '1');
INSERT INTO `forum_thread_reply_attach` VALUES ('7', '9', '999999', '1533019502870', '1', 'group1/M00/00/4F/rBMV6VtgBW-AAiOxAADks5uFQOw193.jpg', 'group1/M00/00/4F/rBMV6VtgBW-AAiOxAADks5uFQOw193_200x80.jpg', '010305k4iyl5yywqy5h5qd.jpg', '58547', '1');

-- ----------------------------
-- Table structure for `forum_thread_tag`
-- ----------------------------
DROP TABLE IF EXISTS `forum_thread_tag`;
CREATE TABLE `forum_thread_tag` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `isdelete` int(1) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_thread_tag
-- ----------------------------
INSERT INTO `forum_thread_tag` VALUES ('7', 'SpringBoot', '1532935741582', '0', '0');
INSERT INTO `forum_thread_tag` VALUES ('8', 'SpringMvc', '1532935741667', '0', '0');
INSERT INTO `forum_thread_tag` VALUES ('9', 'SpringBoot1', '1532935741582', '0', '20');
INSERT INTO `forum_thread_tag` VALUES ('11', 'SpringBoot2', '1532942197746', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('12', 'SpringBoot3', '1532942197886', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('13', 'SpringBoot5', '1532942198071', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('14', 'Java4', '1532942198153', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('15', 'SPring0', '1532942198229', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('16', 'IOC', '1532942198311', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('17', 'IVp', '1532942198387', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('18', 'Angualr', '1532942198470', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('19', 'Ng-alain', '1532942198545', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('20', 'Golang', '1532942198628', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('21', 'Golang2', '1532942198712', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('22', 'GOlang5', '1532942199035', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('23', 'SpringBoot10', '1532942246403', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('24', 'SpringBoot20', '1532942246490', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('25', 'SpringBoot30', '1532942246563', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('26', 'SpringBoot50', '1532942246698', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('27', 'Java40', '1532942246830', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('28', 'SPring00', '1532942246973', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('29', 'IOC0', '1532942247212', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('30', 'IVp0', '1532942247416', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('31', 'Angualr0', '1532942247516', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('32', 'Ng-alain0', '1532942247622', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('33', '0G0olang', '1532942247699', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('34', '12', '1533019592993', '0', null);
INSERT INTO `forum_thread_tag` VALUES ('35', '测试，测试2', '1533808769737', '0', null);
INSERT INTO `forum_thread_tag` VALUES ('36', '订单', '1533865839029', '0', null);
INSERT INTO `forum_thread_tag` VALUES ('37', 'tag', '1533870561727', '0', null);
INSERT INTO `forum_thread_tag` VALUES ('38', 'undefined', '1533873802067', '0', null);
INSERT INTO `forum_thread_tag` VALUES ('39', '', '1533881203747', '0', null);
INSERT INTO `forum_thread_tag` VALUES ('40', '', '1533881208830', '0', null);
INSERT INTO `forum_thread_tag` VALUES ('41', '', '1533881258293', '0', null);
INSERT INTO `forum_thread_tag` VALUES ('42', 'sdsd', '1533881427577', '0', null);
INSERT INTO `forum_thread_tag` VALUES ('43', '', '1533881464058', '0', null);
INSERT INTO `forum_thread_tag` VALUES ('44', '', '1533881720010', '0', null);
INSERT INTO `forum_thread_tag` VALUES ('45', '', '1533881875066', '0', null);
INSERT INTO `forum_thread_tag` VALUES ('46', 'spring', '1534694331172', '0', '1');
INSERT INTO `forum_thread_tag` VALUES ('47', '', '1534867194385', '0', null);

-- ----------------------------
-- Table structure for `forum_thread_tag_link`
-- ----------------------------
DROP TABLE IF EXISTS `forum_thread_tag_link`;
CREATE TABLE `forum_thread_tag_link` (
  `tagid` bigint(19) DEFAULT NULL,
  `tid` bigint(19) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_thread_tag_link
-- ----------------------------
INSERT INTO `forum_thread_tag_link` VALUES ('1', '42');
INSERT INTO `forum_thread_tag_link` VALUES ('29', '26');
INSERT INTO `forum_thread_tag_link` VALUES ('3', '42');
INSERT INTO `forum_thread_tag_link` VALUES ('13', '26');
INSERT INTO `forum_thread_tag_link` VALUES ('5', '43');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '17');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '13');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '12');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '44');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '14');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '15');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '16');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '17');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '18');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '19');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '20');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '21');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '22');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '23');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '24');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '25');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '26');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '27');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '28');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '29');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '30');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '31');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '32');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '33');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '34');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '35');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '36');
INSERT INTO `forum_thread_tag_link` VALUES ('9', '11');
INSERT INTO `forum_thread_tag_link` VALUES ('34', '47');
INSERT INTO `forum_thread_tag_link` VALUES ('35', '48');
INSERT INTO `forum_thread_tag_link` VALUES ('36', '49');
INSERT INTO `forum_thread_tag_link` VALUES ('37', '50');
INSERT INTO `forum_thread_tag_link` VALUES ('38', '51');
INSERT INTO `forum_thread_tag_link` VALUES ('39', '52');
INSERT INTO `forum_thread_tag_link` VALUES ('40', '53');
INSERT INTO `forum_thread_tag_link` VALUES ('41', '54');
INSERT INTO `forum_thread_tag_link` VALUES ('42', '17');
INSERT INTO `forum_thread_tag_link` VALUES ('43', '56');
INSERT INTO `forum_thread_tag_link` VALUES ('44', '57');
INSERT INTO `forum_thread_tag_link` VALUES ('45', '58');
INSERT INTO `forum_thread_tag_link` VALUES ('46', '56');
INSERT INTO `forum_thread_tag_link` VALUES ('47', '66');

-- ----------------------------
-- Table structure for `forum_thread_tag_user`
-- ----------------------------
DROP TABLE IF EXISTS `forum_thread_tag_user`;
CREATE TABLE `forum_thread_tag_user` (
  `tagid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_thread_tag_user
-- ----------------------------
INSERT INTO `forum_thread_tag_user` VALUES ('1', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('2', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('3', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('4', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('5', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('6', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('4', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('5', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('7', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('8', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('9', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('11', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('12', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('13', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('14', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('15', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('16', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('17', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('18', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('19', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('20', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('21', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('22', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('23', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('24', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('25', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('26', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('27', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('28', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('29', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('30', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('31', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('32', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('33', '13');
INSERT INTO `forum_thread_tag_user` VALUES ('34', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('35', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('36', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('37', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('38', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('39', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('40', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('41', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('42', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('43', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('44', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('45', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('46', '12');
INSERT INTO `forum_thread_tag_user` VALUES ('47', '12');

-- ----------------------------
-- Table structure for `forum_thread_viewcount`
-- ----------------------------
DROP TABLE IF EXISTS `forum_thread_viewcount`;
CREATE TABLE `forum_thread_viewcount` (
  `tid` bigint(19) DEFAULT NULL,
  `count` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_thread_viewcount
-- ----------------------------
INSERT INTO `forum_thread_viewcount` VALUES ('8', '3');
INSERT INTO `forum_thread_viewcount` VALUES ('17', '3');
INSERT INTO `forum_thread_viewcount` VALUES ('18', '3');
INSERT INTO `forum_thread_viewcount` VALUES ('19', '1');
INSERT INTO `forum_thread_viewcount` VALUES ('23', '1');
INSERT INTO `forum_thread_viewcount` VALUES ('24', '1');
INSERT INTO `forum_thread_viewcount` VALUES ('25', '1');
INSERT INTO `forum_thread_viewcount` VALUES ('26', '1');
INSERT INTO `forum_thread_viewcount` VALUES ('47', '1');
INSERT INTO `forum_thread_viewcount` VALUES ('49', '1');
INSERT INTO `forum_thread_viewcount` VALUES ('50', '1');
INSERT INTO `forum_thread_viewcount` VALUES ('51', '1');
INSERT INTO `forum_thread_viewcount` VALUES ('56', '2');
INSERT INTO `forum_thread_viewcount` VALUES ('58', '4');
INSERT INTO `forum_thread_viewcount` VALUES ('2', '1');
INSERT INTO `forum_thread_viewcount` VALUES ('57', '1');
INSERT INTO `forum_thread_viewcount` VALUES ('54', '1');
INSERT INTO `forum_thread_viewcount` VALUES ('12', '1');
INSERT INTO `forum_thread_viewcount` VALUES ('63', '1');
INSERT INTO `forum_thread_viewcount` VALUES ('65', '1');
INSERT INTO `forum_thread_viewcount` VALUES ('66', '1');

-- ----------------------------
-- Table structure for `forum_thread_view_record`
-- ----------------------------
DROP TABLE IF EXISTS `forum_thread_view_record`;
CREATE TABLE `forum_thread_view_record` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `tid` bigint(19) DEFAULT NULL,
  `datestr` varchar(50) DEFAULT NULL,
  `ip` varchar(50) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_thread_view_record
-- ----------------------------
INSERT INTO `forum_thread_view_record` VALUES ('1', '19', '2018-07-28', '192.168.0.135', '1532769008059', null);
INSERT INTO `forum_thread_view_record` VALUES ('2', '18', '2018-07-28', '192.168.0.135', '1532769901704', null);
INSERT INTO `forum_thread_view_record` VALUES ('3', '26', '2018-08-09', '192.168.0.135', '1533803660943', null);
INSERT INTO `forum_thread_view_record` VALUES ('4', '47', '2018-08-09', '192.168.0.135', '1533803665044', null);
INSERT INTO `forum_thread_view_record` VALUES ('5', '25', '2018-08-09', '192.168.0.135', '1533803670555', null);
INSERT INTO `forum_thread_view_record` VALUES ('6', '23', '2018-08-09', '192.168.0.135', '1533807876579', null);
INSERT INTO `forum_thread_view_record` VALUES ('7', '24', '2018-08-09', '192.168.0.135', '1533807917547', null);
INSERT INTO `forum_thread_view_record` VALUES ('8', '49', '2018-08-10', '192.168.0.135', '1533865884436', null);
INSERT INTO `forum_thread_view_record` VALUES ('9', '50', '2018-08-10', '192.168.0.135', '1533870593240', null);
INSERT INTO `forum_thread_view_record` VALUES ('10', '51', '2018-08-10', '192.168.0.135', '1533873925075', null);
INSERT INTO `forum_thread_view_record` VALUES ('11', '58', '2018-08-10', '192.168.0.135', '1533881954566', null);
INSERT INTO `forum_thread_view_record` VALUES ('12', '56', '2018-08-10', '192.168.0.135', '1533883641325', null);
INSERT INTO `forum_thread_view_record` VALUES ('13', '17', '2018-08-10', '192.168.0.135', '1533884092535', null);
INSERT INTO `forum_thread_view_record` VALUES ('14', '8', '2018-08-10', '', '1533885611671', null);
INSERT INTO `forum_thread_view_record` VALUES ('15', '58', '2018-08-18', '192.168.1.3', '1534598162159', null);
INSERT INTO `forum_thread_view_record` VALUES ('16', '18', '2018-08-18', '192.168.1.3', '1534598190101', null);
INSERT INTO `forum_thread_view_record` VALUES ('17', '17', '2018-08-18', '192.168.1.3', '1534598563375', null);
INSERT INTO `forum_thread_view_record` VALUES ('18', '8', '2018-08-18', '192.168.1.3', '1534598568899', null);
INSERT INTO `forum_thread_view_record` VALUES ('19', '2', '2018-08-18', '192.168.1.3', '1534598896944', null);
INSERT INTO `forum_thread_view_record` VALUES ('20', '57', '2018-08-19', '192.168.1.3', '1534609328122', null);
INSERT INTO `forum_thread_view_record` VALUES ('21', '58', '2018-08-19', '192.168.1.3', '1534655137451', null);
INSERT INTO `forum_thread_view_record` VALUES ('22', '54', '2018-08-19', '192.168.1.3', '1534655372640', null);
INSERT INTO `forum_thread_view_record` VALUES ('23', '56', '2018-08-19', '192.168.1.3', '1534655388552', null);
INSERT INTO `forum_thread_view_record` VALUES ('24', '8', '2018-08-19', '192.168.1.3', '1534655398296', null);
INSERT INTO `forum_thread_view_record` VALUES ('25', '12', '2018-08-19', '192.168.1.3', '1534657071635', null);
INSERT INTO `forum_thread_view_record` VALUES ('26', '17', '2018-08-19', '192.168.1.3', '1534657960971', null);
INSERT INTO `forum_thread_view_record` VALUES ('27', '18', '2018-08-19', '192.168.1.3', '1534658051518', null);
INSERT INTO `forum_thread_view_record` VALUES ('28', '58', '2018-08-19', '', '1534692740044', '12');
INSERT INTO `forum_thread_view_record` VALUES ('29', '58', '2018-08-19', '', '1534692740044', '12');
INSERT INTO `forum_thread_view_record` VALUES ('30', '63', '2018-08-21', '192.168.1.3', '1534866211011', null);
INSERT INTO `forum_thread_view_record` VALUES ('31', '65', '2018-08-21', '192.168.1.3', '1534866748726', null);
INSERT INTO `forum_thread_view_record` VALUES ('32', '66', '2018-08-22', '192.168.1.3', '1534867204576', null);

-- ----------------------------
-- Table structure for `friendlink`
-- ----------------------------
DROP TABLE IF EXISTS `friendlink`;
CREATE TABLE `friendlink` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `link` varchar(255) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sort` int(4) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  `updateid` bigint(19) DEFAULT NULL,
  `updateline` bigint(13) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friendlink
-- ----------------------------
INSERT INTO `friendlink` VALUES ('4', 'http://ww.wangdaibus.com', '1535123781990', '13', '网贷巴士2', '10', '1', '备注信息', null, null);
INSERT INTO `friendlink` VALUES ('5', 'http://ww.wangdaibus.com', '1535123783131', '13', '网贷巴士3', '12', '1', '备注信息', null, null);
INSERT INTO `friendlink` VALUES ('6', 'http://ww.wangdaibus.com', '1535123789779', '13', '网贷巴士4', '11', '1', '备注信息', null, null);
INSERT INTO `friendlink` VALUES ('7', 'http://ww.wangdaibus.com', '1535123790883', '13', '网贷巴士5', '1', '1', '备注信息', null, null);
INSERT INTO `friendlink` VALUES ('8', 'http://ww.wangdaibus.com', '1535123791559', '13', '网贷巴士6', '18', '1', '备注信息', null, null);
INSERT INTO `friendlink` VALUES ('9', 'http://ww.wangdaibus.com', '1535123792231', '13', '网贷巴士7', '19', '1', '备注信息', null, null);
INSERT INTO `friendlink` VALUES ('10', 'http://ww.wangdaibus.com', '1535123793100', '13', '网贷巴士8', '1', '1', '备注信息', null, null);
INSERT INTO `friendlink` VALUES ('11', 'http://ww.wangdaibus.com', '1535123794111', '13', '网贷巴士9', '1', '1', '备注信息', null, null);
INSERT INTO `friendlink` VALUES ('12', 'http://ww.wangdaibus.com', '1535125654353', '13', '网贷巴士', '1', '2', '备注信息', null, null);
INSERT INTO `friendlink` VALUES ('13', 'http://ww.wangdaibus.com', '1535125679177', '13', '网贷巴士', '1', '2', '备注信息', null, null);
INSERT INTO `friendlink` VALUES ('14', 'sdsfsd', '1535169685504', '13', 'sdfdsfd', '1', '1', '123213', '13', '1535169753977');

-- ----------------------------
-- Table structure for `system_resource`
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
-- Table structure for `system_role`
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
  `roleid` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `rolename` varchar(50) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_role
-- ----------------------------
INSERT INTO `system_role` VALUES ('4', '管理员1');
INSERT INTO `system_role` VALUES ('5', '普通管理员');
INSERT INTO `system_role` VALUES ('6', '普通用户');
INSERT INTO `system_role` VALUES ('7', '213213');
INSERT INTO `system_role` VALUES ('8', '213213');
INSERT INTO `system_role` VALUES ('9', '213213');
INSERT INTO `system_role` VALUES ('10', '213213');
INSERT INTO `system_role` VALUES ('11', '213213');
INSERT INTO `system_role` VALUES ('12', '213213');
INSERT INTO `system_role` VALUES ('13', '213213');
INSERT INTO `system_role` VALUES ('14', '普通用户www');
INSERT INTO `system_role` VALUES ('15', '普通用户ww');

-- ----------------------------
-- Table structure for `system_role_resource`
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
-- Table structure for `system_user_role`
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
-- Table structure for `user`
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10', 'bus3406', '13553869013', '1', null, '0', null, '1525962629832', null, null, null, null, '0', '192.168.1.2', 'UNKNOWN');
INSERT INTO `user` VALUES ('11', 'bus1243', '13553869015', '1', null, '0', null, '1525966002464', null, null, null, null, '0', '192.168.1.2', 'UNKNOWN');
INSERT INTO `user` VALUES ('12', 'bus5280', '13553869012', '1', null, '0', null, '1529922798913', null, null, null, null, '0', '113.116.158.149', 'UNKNOWN');
INSERT INTO `user` VALUES ('13', 'bus0348', '13553869018', '1', null, '0', null, '1529923467671', null, null, null, null, '0', '113.116.158.149', 'UNKNOWN');
INSERT INTO `user` VALUES ('16', '123533', '13553896025', '1', null, '0', null, '1531304577046', null, null, null, null, '0', '192.168.0.135', 'UNKNOWN');
INSERT INTO `user` VALUES ('17', 'bus5555', '13553869256', '1', null, '0', null, '1531305478416', null, null, null, null, '0', '192.168.0.135', 'UNKNOWN');
INSERT INTO `user` VALUES ('18', 'bus1052', '13553869019', '1', null, '0', null, '1532503768115', null, null, null, null, '0', '192.168.0.135', 'UNKNOWN');
INSERT INTO `user` VALUES ('19', 'bus4125', '13553865233', '1', 'null', '0', null, '1532508331628', null, null, null, null, '0', '192.168.0.135', 'UNKNOWN');
INSERT INTO `user` VALUES ('20', 'bus0175', '13569999666', '1', '13553865233@qq.com', '0', null, '1532511459436', null, null, null, null, '0', '192.168.0.135', 'UNKNOWN');
INSERT INTO `user` VALUES ('21', 'bus2780', '13656562333', '1', null, '0', null, '1532511602838', null, null, null, null, '0', '192.168.0.135', 'UNKNOWN');

-- ----------------------------
-- Table structure for `user_account`
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `baseid` bigint(19) DEFAULT NULL,
  `balance` decimal(19,2) DEFAULT NULL,
  `freezebalance` decimal(19,2) DEFAULT NULL,
  `totalbalance` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

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
INSERT INTO `user_account` VALUES ('11', '18', '0.00', '0.00', '0.00');
INSERT INTO `user_account` VALUES ('12', '19', '0.00', '0.00', '0.00');
INSERT INTO `user_account` VALUES ('13', '20', '0.00', '0.00', '0.00');
INSERT INTO `user_account` VALUES ('14', '21', '0.00', '0.00', '0.00');

-- ----------------------------
-- Table structure for `user_avatar`
-- ----------------------------
DROP TABLE IF EXISTS `user_avatar`;
CREATE TABLE `user_avatar` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `baseid` bigint(19) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `bigattach` varchar(255) DEFAULT NULL,
  `smallattach` varchar(255) DEFAULT NULL,
  `middleattach` varchar(255) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_avatar
-- ----------------------------

-- ----------------------------
-- Table structure for `user_safety`
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_safety
-- ----------------------------
INSERT INTO `user_safety` VALUES ('3', '10', '$2a$10$ACjqzR0Ofpv7XhvFFjzX/.bp858SmLQWc/50UBpidlt2bb2oGv4cK', '1525962629832', '192.168.1.2', '0', '0', '0', '1529894542525', '116.30.192.154', '1');
INSERT INTO `user_safety` VALUES ('4', '11', '$2a$10$eL6LLzvX0CGQP2HOGtwNBueDsqrSsBZOJ6c7F1OsrpRr/OhNWquRe', '1525966002464', '192.168.1.2', '0', '0', '0', '1531303965923', '192.168.0.135', '1');
INSERT INTO `user_safety` VALUES ('5', '12', '$2a$10$AS4A.9EHQRSKI6ricrzjceAvvcBl/Xz8q4mEgzDeEPiqQ.Nt3M3Ka', '1529922798913', '113.116.158.149', '0', '0', '0', '1534865991913', '192.168.1.3', '0');
INSERT INTO `user_safety` VALUES ('6', '13', '$2a$10$Aya1mS17TevU.o7YMTvrH.enAL6QYnTDSaTgjvzld7SFi8gzL47i.', '1529923467671', '113.116.158.149', '0', '0', '0', '1535122905518', '192.168.1.3', '0');
INSERT INTO `user_safety` VALUES ('7', '14', '$2a$10$KuyN5c29G/YJaMVSayTksuEhE3vx2sx.vYuIVnWup2A.aV4E7rO4C', '1531304039336', '192.168.0.135', '0', '0', '0', null, null, '0');
INSERT INTO `user_safety` VALUES ('8', '15', '$2a$10$gFy5fwAvRWQtkkIT2muDrO3jQWvOqmEwl/ZsrFPaAaAwovQ/wGaJC', '1531304039369', '192.168.0.135', '0', '0', '0', null, null, '0');
INSERT INTO `user_safety` VALUES ('9', '16', '$2a$10$g5Yo5VgJooF9ucCmllJEDuGsV8Jf3SWkG7nM/7ZnFAYYWs77P8z4S', '1531304577046', '192.168.0.135', '0', '0', '0', null, null, '0');
INSERT INTO `user_safety` VALUES ('10', '17', '$2a$10$C0WGKkrMDNXvvvIj1.o5V.yK50TYMVHmPYVyFkCXWM/lguYVA.aPq', '1531305478416', '192.168.0.135', '0', '0', '0', null, null, '0');
INSERT INTO `user_safety` VALUES ('11', '18', '$2a$10$5K/KlKmVaIYtYdyHeOJGn.1TCFCnlrPD2.JgrtXKPQANBtgTMSfhq', '1532503768115', '192.168.0.135', '0', '0', '0', null, null, '0');
INSERT INTO `user_safety` VALUES ('12', '19', '$2a$10$fT1ANyKgHv3yXpbc74Bw0eE2eVLCPptcmu/F.UE6FpceHLQWxgqhe', '1532508331628', '192.168.0.135', '0', '0', '0', null, null, '0');
INSERT INTO `user_safety` VALUES ('13', '20', '$2a$10$Djb.0YmWJ74Z9gztaT.3V.JZNrR4i.8Ve4fCSju2nu2kqb6qbIxSa', '1532511459436', '192.168.0.135', '0', '0', '0', null, null, '0');
INSERT INTO `user_safety` VALUES ('14', '21', '$2a$10$Ubld2gBSeoBbRDAlRisQJOXIKmFaJlYzoPy8/CQ1tQDR8jJ5ENHGi', '1532511602838', '192.168.0.135', '0', '0', '0', null, null, '0');

-- ----------------------------
-- Table structure for `web_forum_forum`
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
