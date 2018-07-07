-- phpMyAdmin SQL Dump
-- version 4.7.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2018-07-07 03:22:46
-- 服务器版本： 5.6.36-log
-- PHP Version: 5.6.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cjm`
--

-- --------------------------------------------------------

--
-- 表的结构 `forum_attachment`
--

CREATE TABLE `forum_attachment` (
  `id` bigint(19) NOT NULL,
  `tid` bigint(19) DEFAULT NULL,
  `pid` bigint(19) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `tableid` int(1) DEFAULT NULL,
  `downloads` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `forum_attachment`
--

INSERT INTO `forum_attachment` (`id`, `tid`, `pid`, `baseid`, `tableid`, `downloads`) VALUES
(1, 0, 0, 999999, 127, 0),
(2, 0, 0, 999999, 127, 0),
(3, 0, 0, 999999, 127, 0),
(4, 0, 0, 999999, 127, 0),
(5, 0, 0, 999999, 127, 0),
(6, 0, 0, 999999, 127, 0),
(7, 11, 8, 999999, 1, 0),
(8, 11, 8, 10, 1, 0),
(9, 12, 9, 10, 2, 0);

-- --------------------------------------------------------

--
-- 表的结构 `forum_attachment_0`
--

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
  `picid` bigint(19) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `forum_attachment_1`
--

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
  `picid` bigint(19) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `forum_attachment_1`
--

INSERT INTO `forum_attachment_1` (`aid`, `tid`, `pid`, `baseid`, `dateline`, `filename`, `filesize`, `attachment`, `thumachment`, `waterattachment`, `remote`, `description`, `readperm`, `price`, `isimage`, `width`, `picid`) VALUES
(7, 11, 8, 999999, 1528039085267, 'QQ图片20180602214630.png', 37920, 'group1/M00/00/01/rBKphlsUByeAOKHOAACUIDGLrgE684.png', 'group1/M00/00/01/rBKphlsUByeAOKHOAACUIDGLrgE684_200x80.png', '', 0, '', 0, 0, 1, 1218, NULL),
(8, 11, 8, 10, 1528039130966, 'VID20180603230811.mp4', 10265716, 'group1/M00/00/01/rBKphlsUB0yAf5C7AJykdAReKkA560.mp4', NULL, NULL, 0, '', 0, 0, 2, NULL, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `forum_attachment_2`
--

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
  `picid` bigint(19) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `forum_attachment_2`
--

INSERT INTO `forum_attachment_2` (`aid`, `tid`, `pid`, `baseid`, `dateline`, `filename`, `filesize`, `attachment`, `thumachment`, `waterattachment`, `remote`, `description`, `readperm`, `price`, `isimage`, `width`, `picid`) VALUES
(9, 12, 9, 10, 1528041679551, 'VID20180603230811.mp4', 10265716, 'group1/M00/00/01/rBKphlsUEUuAKnA9AJykdAReKkA204.mp4', NULL, NULL, 0, '', 0, 0, 2, NULL, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `forum_attachment_3`
--

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
  `picid` bigint(19) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `forum_attachment_4`
--

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
  `picid` bigint(19) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `forum_attachment_5`
--

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
  `picid` bigint(19) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `forum_attachment_6`
--

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
  `picid` bigint(19) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `forum_attachment_7`
--

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
  `picid` bigint(19) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `forum_attachment_8`
--

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
  `picid` bigint(19) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `forum_attachment_9`
--

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
  `picid` bigint(19) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `forum_attachment_unused`
--

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
  `width` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `forum_attachment_unused`
--

INSERT INTO `forum_attachment_unused` (`aid`, `tid`, `pid`, `baseid`, `dateline`, `filename`, `filesize`, `attachment`, `thumachment`, `waterattachment`, `remote`, `description`, `readperm`, `price`, `isimage`, `width`) VALUES
(1, NULL, NULL, 999999, 1527612080251, 'logo1.png', 11614, 'group1/M00/00/00/rBKphlsNgyaAa_i2AAAtXgOqF2k702.png', 'group1/M00/00/00/rBKphlsNgyaAa_i2AAAtXgOqF2k702_200x80.png', '', 0, NULL, NULL, NULL, 1, 234),
(2, NULL, NULL, 999999, 1527612240803, 'QQ图片20170603211403.jpg', 38006, 'group1/M00/00/00/rBKphlsNg8iAZGdXAACUdhzoQVU221.jpg', 'group1/M00/00/00/rBKphlsNg8iAZGdXAACUdhzoQVU221_200x80.jpg', '', 0, NULL, NULL, NULL, 1, 1081),
(3, NULL, NULL, 999999, 1527612244751, 'logo1.png', 11614, 'group1/M00/00/01/rBKphlsNg8yARzJvAAAtXgOqF2k318.png', 'group1/M00/00/01/rBKphlsNg8yARzJvAAAtXgOqF2k318_200x80.png', '', 0, NULL, NULL, NULL, 1, 234),
(4, NULL, NULL, 999999, 1527776480150, 'logo1.png', 11614, 'group1/M00/00/01/rBKphlsQBViAJ7HAAAAtXgOqF2k949.png', 'group1/M00/00/01/rBKphlsQBViAJ7HAAAAtXgOqF2k949_200x80.png', '', 0, NULL, NULL, NULL, 1, 234),
(5, NULL, NULL, 999999, 1528032563475, 'QQ图片20180602214630.png', 37920, 'group1/M00/00/01/rBKphlsT7ZmARa8dAACUIDGLrgE873.png', 'group1/M00/00/01/rBKphlsT7ZmARa8dAACUIDGLrgE873_200x80.png', '', 0, NULL, NULL, NULL, 1, 1218),
(6, NULL, NULL, 999999, 1528032824141, 'QQ图片20180602214630.png', 37920, 'group1/M00/00/01/rBKphlsT7qyAD7uAAACUIDGLrgE835.png', 'group1/M00/00/01/rBKphlsT7qyAD7uAAACUIDGLrgE835_200x80.png', '', 0, NULL, NULL, NULL, 1, 1218);

-- --------------------------------------------------------

--
-- 表的结构 `forum_forum`
--

CREATE TABLE `forum_forum` (
  `id` bigint(19) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `threads` bigint(19) DEFAULT NULL,
  `commonts` bigint(19) DEFAULT NULL,
  `addtime` bigint(13) DEFAULT NULL,
  `addbaseid` bigint(19) DEFAULT NULL,
  `updatetime` bigint(13) DEFAULT NULL,
  `updatebaseid` bigint(19) DEFAULT NULL,
  `isdelete` int(1) DEFAULT NULL,
  `sort` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `forum_forum`
--

INSERT INTO `forum_forum` (`id`, `name`, `status`, `threads`, `commonts`, `addtime`, `addbaseid`, `updatetime`, `updatebaseid`, `isdelete`, `sort`) VALUES
(2, 'java', 1, 0, 0, 1527784216142, 10, 1527784261405, 10, 0, 0),
(3, 'golang', 1, 0, 0, 1528000072569, 10, NULL, NULL, 0, 0),
(4, 'javascript', 1, 0, 0, 1528000080864, 10, NULL, NULL, 0, 0),
(5, '关于我', 1, 0, 0, 1528000092116, 10, NULL, NULL, 0, 2),
(6, '首页', 1, 0, 0, 1528000098384, 10, NULL, NULL, 0, 10),
(7, '相册', 1, 0, 0, 1528000107713, 10, NULL, NULL, 0, 0),
(8, '视频', 1, 0, 0, 1528000117318, 10, NULL, NULL, 0, 0),
(9, '音乐', 1, 0, 0, 1528000126932, 10, NULL, NULL, 0, 1),
(10, 'java22', 1, 0, 0, 1528214934683, 10, NULL, NULL, 0, 0);

-- --------------------------------------------------------

--
-- 表的结构 `forum_post`
--

CREATE TABLE `forum_post` (
  `id` bigint(19) NOT NULL,
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
  `usesig` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `forum_post`
--

INSERT INTO `forum_post` (`id`, `fid`, `tid`, `baseid`, `subject`, `content`, `status`, `addtime`, `updatetime`, `updatebaseid`, `isdelete`, `useip`, `attachment`, `usesig`) VALUES
(1, 2, 2, 10, '20180603主题保存', '今天是发个号日子啊', -1, 1528030711528, NULL, NULL, 0, NULL, 0, 0),
(2, 2, 8, 10, '20180603主题保存', '今天是发个号日子啊', 0, 1528030842399, NULL, NULL, 0, '192.168.1.5', 0, 0),
(4, 2, 4, 10, '20180603主题保存', '今天是发个号日子啊', 0, 1528031111765, NULL, NULL, 0, '192.168.1.5', 0, 0),
(5, 2, 2, 10, '20180603主题保存', '今天是发个号日子啊<p>     [attach]6[/attach] </p>', -1, 1528033027619, NULL, NULL, 0, '192.168.1.5', 1, 0),
(8, 2, 11, 10, '20180603主题测试', '的说法是的范德萨<p>     [attach]7[/attach]     [attach]8[/attach] </p>', 0, 1528043945238, NULL, NULL, 0, '192.168.1.5', 2, 0),
(9, 2, 12, 10, '20180603主题测试', '的说法是的范德萨[attach]9[/attach]', 0, 1528044014770, NULL, NULL, 0, '192.168.1.5', 1, 0),
(10, 2, 13, 10, '测试主题', '的范德萨范德萨', 0, 1528044161938, NULL, NULL, 0, '192.168.1.5', 0, 0);

-- --------------------------------------------------------

--
-- 表的结构 `forum_thraad_tag_link`
--

CREATE TABLE `forum_thraad_tag_link` (
  `id` bigint(19) NOT NULL,
  `tagid` bigint(19) DEFAULT NULL,
  `tid` bigint(19) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `forum_thread`
--

CREATE TABLE `forum_thread` (
  `id` bigint(19) NOT NULL,
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
  `threadtype` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `forum_thread`
--

INSERT INTO `forum_thread` (`id`, `fid`, `baseid`, `subject`, `dateline`, `lastpost`, `lastposter`, `views`, `replies`, `digest`, `attachment`, `moderated`, `likes`, `unlikes`, `favtimes`, `sharetimes`, `status`, `isdelete`, `sort`, `threadtype`) VALUES
(1, 2, 10, '20180603主题保存', 1528030711528, NULL, NULL, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1),
(2, 2, 10, '20180603主题保存', 1528030842399, NULL, NULL, 4, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 0, 1),
(4, 2, 10, '20180603主题保存', 1528031111765, NULL, NULL, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1),
(8, 2, 10, '20180603主题保存', 1528033027619, NULL, NULL, 5, 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0, 1),
(11, 2, 10, '20180603主题测试', 1528043945238, NULL, NULL, 0, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 1),
(12, 2, 10, '20180603主题测试', 1528044014770, NULL, NULL, 0, 0, 0, 2, 1, 3, 0, 0, 0, 0, 0, 0, 1),
(13, 2, 10, '测试主题', 1528044161938, NULL, NULL, 0, 9, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1);

-- --------------------------------------------------------

--
-- 表的结构 `forum_thread_operation`
--

CREATE TABLE `forum_thread_operation` (
  `id` bigint(19) NOT NULL,
  `tid` bigint(19) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `userip` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `forum_thread_operation`
--

INSERT INTO `forum_thread_operation` (`id`, `tid`, `status`, `type`, `dateline`, `baseid`, `username`, `userip`) VALUES
(1, 13, 1, 'AUDITSU', 1528215617475, 10, 'bus3406', '192.168.1.5'),
(2, 4, 1, 'AUDITSU', 1528215858700, 10, 'bus3406', '192.168.1.5'),
(3, 8, 1, 'AUDITSU', 1528215864381, 10, 'bus3406', '192.168.1.5'),
(4, 11, 1, 'AUDITSU', 1528215869757, 10, 'bus3406', '192.168.1.5'),
(5, 13, 1, 'AUDITFA', 1528269854839, 10, 'bus3406', '192.168.1.5'),
(7, 4, 1, 'AUDITFA', 1528269967652, 10, 'bus3406', '192.168.1.5'),
(8, 8, 1, 'AUDITFA', 1528269967669, 10, 'bus3406', '192.168.1.5'),
(9, 11, 1, 'AUDITFA', 1528269967682, 10, 'bus3406', '192.168.1.5'),
(10, 4, 1, 'AUDITFA', 1528269992636, 10, 'bus3406', '192.168.1.5'),
(11, 8, 1, 'AUDITFA', 1528269992645, 10, 'bus3406', '192.168.1.5'),
(12, 11, 1, 'AUDITFA', 1528269992655, 10, 'bus3406', '192.168.1.5'),
(13, 4, 1, 'AUDITFA', 1528270031732, 10, 'bus3406', '192.168.1.5'),
(14, 8, 1, 'AUDITFA', 1528270031773, 10, 'bus3406', '192.168.1.5'),
(15, 11, 1, 'AUDITFA', 1528270031823, 10, 'bus3406', '192.168.1.5'),
(16, 4, 1, 'AUDITFA', 1528270057664, 10, 'bus3406', '192.168.1.5'),
(17, 8, 1, 'AUDITFA', 1528270057672, 10, 'bus3406', '192.168.1.5'),
(18, 11, 1, 'AUDITFA', 1528270057684, 10, 'bus3406', '192.168.1.5'),
(19, 11, 1, 'UPD', 1528270880496, 10, 'bus3406', '192.168.1.5'),
(20, 11, 1, 'DEL', 1528270897493, 10, 'bus3406', '192.168.1.5'),
(21, 11, 1, 'UPD', 1528270916331, 10, 'bus3406', '192.168.1.5'),
(22, 12, 1, 'UPD', 1528271100308, 10, 'bus3406', '192.168.1.5'),
(23, 13, 1, 'UPD', 1528271100312, 10, 'bus3406', '192.168.1.5');

-- --------------------------------------------------------

--
-- 表的结构 `forum_thread_tag`
--

CREATE TABLE `forum_thread_tag` (
  `id` bigint(19) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `dateline` bigint(13) DEFAULT NULL,
  `uid` bigint(19) DEFAULT NULL,
  `isdelete` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `friendlink`
--

CREATE TABLE `friendlink` (
  `id` bigint(19) NOT NULL,
  `displayorder` int(1) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `description` mediumtext,
  `logo` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `id` bigint(19) NOT NULL,
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
  `device` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `username`, `mobile`, `mobilestatus`, `email`, `emailstatus`, `userno`, `regtime`, `img`, `signature`, `relaname`, `idcardnumber`, `relastatus`, `regip`, `device`) VALUES
(10, 'bus3406', '13553869013', 1, NULL, 0, NULL, 1525962629832, NULL, NULL, NULL, NULL, 0, '192.168.1.2', 'UNKNOWN'),
(11, 'bus1243', '13553869015', 1, NULL, 0, NULL, 1525966002464, NULL, NULL, NULL, NULL, 0, '192.168.1.2', 'UNKNOWN'),
(12, 'bus5280', '13553869012', 1, NULL, 0, NULL, 1529922798913, NULL, NULL, NULL, NULL, 0, '113.116.158.149', 'UNKNOWN'),
(13, 'bus0348', '13553869018', 1, NULL, 0, NULL, 1529923467671, NULL, NULL, NULL, NULL, 0, '113.116.158.149', 'UNKNOWN');

-- --------------------------------------------------------

--
-- 表的结构 `user_account`
--

CREATE TABLE `user_account` (
  `id` bigint(19) NOT NULL,
  `baseid` bigint(19) DEFAULT NULL,
  `balance` decimal(19,2) DEFAULT NULL,
  `freezebalance` decimal(19,2) DEFAULT NULL,
  `totalbalance` decimal(19,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user_account`
--

INSERT INTO `user_account` (`id`, `baseid`, `balance`, `freezebalance`, `totalbalance`) VALUES
(3, 10, '0.00', '0.00', '0.00'),
(4, 11, '0.00', '0.00', '0.00'),
(5, 12, '0.00', '0.00', '0.00'),
(6, 13, '0.00', '0.00', '0.00');

-- --------------------------------------------------------

--
-- 表的结构 `user_safety`
--

CREATE TABLE `user_safety` (
  `id` bigint(19) NOT NULL,
  `baseid` bigint(19) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `regtime` bigint(13) DEFAULT NULL,
  `regip` varchar(50) DEFAULT NULL,
  `errorcount` int(2) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `isdelete` int(1) DEFAULT NULL,
  `lastlogintime` bigint(13) DEFAULT NULL,
  `lastloginip` varchar(30) DEFAULT NULL,
  `isadmin` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user_safety`
--

INSERT INTO `user_safety` (`id`, `baseid`, `password`, `regtime`, `regip`, `errorcount`, `status`, `isdelete`, `lastlogintime`, `lastloginip`, `isadmin`) VALUES
(3, 10, '$2a$10$ACjqzR0Ofpv7XhvFFjzX/.bp858SmLQWc/50UBpidlt2bb2oGv4cK', 1525962629832, '192.168.1.2', 0, 0, 0, 1529894542525, '116.30.192.154', 1),
(4, 11, '$2a$10$eL6LLzvX0CGQP2HOGtwNBueDsqrSsBZOJ6c7F1OsrpRr/OhNWquRe', 1525966002464, '192.168.1.2', 0, 0, 0, 1530192511816, '219.133.100.153', 1),
(5, 12, '$2a$10$AS4A.9EHQRSKI6ricrzjceAvvcBl/Xz8q4mEgzDeEPiqQ.Nt3M3Ka', 1529922798913, '113.116.158.149', 0, 0, 0, NULL, NULL, 0),
(6, 13, '$2a$10$Aya1mS17TevU.o7YMTvrH.enAL6QYnTDSaTgjvzld7SFi8gzL47i.', 1529923467671, '113.116.158.149', 0, 0, 0, NULL, NULL, 0);

-- --------------------------------------------------------

--
-- 表的结构 `web_forum_forum`
--

CREATE TABLE `web_forum_forum` (
  `id` bigint(19) NOT NULL,
  `fid` bigint(19) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  `addtime` bigint(13) DEFAULT NULL,
  `addbaseid` bigint(19) DEFAULT NULL,
  `updatetime` bigint(19) DEFAULT NULL,
  `updatebaseid` bigint(19) DEFAULT NULL,
  `isshow` int(1) DEFAULT NULL,
  `isdelete` int(1) DEFAULT NULL,
  `sort` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `forum_attachment`
--
ALTER TABLE `forum_attachment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `forum_attachment_0`
--
ALTER TABLE `forum_attachment_0`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `forum_attachment_1`
--
ALTER TABLE `forum_attachment_1`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `forum_attachment_2`
--
ALTER TABLE `forum_attachment_2`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `forum_attachment_3`
--
ALTER TABLE `forum_attachment_3`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `forum_attachment_4`
--
ALTER TABLE `forum_attachment_4`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `forum_attachment_5`
--
ALTER TABLE `forum_attachment_5`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `forum_attachment_6`
--
ALTER TABLE `forum_attachment_6`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `forum_attachment_7`
--
ALTER TABLE `forum_attachment_7`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `forum_attachment_8`
--
ALTER TABLE `forum_attachment_8`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `forum_attachment_9`
--
ALTER TABLE `forum_attachment_9`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `forum_attachment_unused`
--
ALTER TABLE `forum_attachment_unused`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `forum_forum`
--
ALTER TABLE `forum_forum`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `forum_post`
--
ALTER TABLE `forum_post`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `forum_thraad_tag_link`
--
ALTER TABLE `forum_thraad_tag_link`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `forum_thread`
--
ALTER TABLE `forum_thread`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `forum_thread_operation`
--
ALTER TABLE `forum_thread_operation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `forum_thread_tag`
--
ALTER TABLE `forum_thread_tag`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `friendlink`
--
ALTER TABLE `friendlink`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_account`
--
ALTER TABLE `user_account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_safety`
--
ALTER TABLE `user_safety`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `web_forum_forum`
--
ALTER TABLE `web_forum_forum`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `forum_attachment`
--
ALTER TABLE `forum_attachment`
  MODIFY `id` bigint(19) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- 使用表AUTO_INCREMENT `forum_forum`
--
ALTER TABLE `forum_forum`
  MODIFY `id` bigint(19) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- 使用表AUTO_INCREMENT `forum_post`
--
ALTER TABLE `forum_post`
  MODIFY `id` bigint(19) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- 使用表AUTO_INCREMENT `forum_thraad_tag_link`
--
ALTER TABLE `forum_thraad_tag_link`
  MODIFY `id` bigint(19) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `forum_thread`
--
ALTER TABLE `forum_thread`
  MODIFY `id` bigint(19) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- 使用表AUTO_INCREMENT `forum_thread_operation`
--
ALTER TABLE `forum_thread_operation`
  MODIFY `id` bigint(19) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- 使用表AUTO_INCREMENT `forum_thread_tag`
--
ALTER TABLE `forum_thread_tag`
  MODIFY `id` bigint(19) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `friendlink`
--
ALTER TABLE `friendlink`
  MODIFY `id` bigint(19) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(19) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- 使用表AUTO_INCREMENT `user_account`
--
ALTER TABLE `user_account`
  MODIFY `id` bigint(19) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- 使用表AUTO_INCREMENT `user_safety`
--
ALTER TABLE `user_safety`
  MODIFY `id` bigint(19) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- 使用表AUTO_INCREMENT `web_forum_forum`
--
ALTER TABLE `web_forum_forum`
  MODIFY `id` bigint(19) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
