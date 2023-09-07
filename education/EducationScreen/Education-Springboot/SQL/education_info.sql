/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.7.22-3306端口
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : education_info

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 16/08/2023 01:02:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for education_info
-- ----------------------------
DROP TABLE IF EXISTS `education_info`;
CREATE TABLE `education_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `nick_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `order_pay` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单金额',
  `order_pay_way` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单支付方式',
  `order_way` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单来源',
  `cource_type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程类型',
  `student_age` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生年龄',
  `vip_grade` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'vip等级',
  `gender` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `ip_city` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip来源',
  `registration _days` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册天数',
  `cource_teacher` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任课老师',
  `area` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程所属学科',
  `course_introduction` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程介绍',
  `pic` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程封面',
  `last_logintime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上次登陆时间',
  `agent_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '销售代理人',
  `order_status` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单有效状态',
  `process` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程进度',
  `score` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成绩',
  `url` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详情页地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1538 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of education_info
-- ----------------------------
INSERT INTO `education_info` VALUES (1515, NULL, '1000', '微信', '抖音', '高等数学', '1', '一星', '男', '重庆', '1', '冉老师', '哲学', '同学们大家好，这门课属于', 'www.baidu.com', '  1天前 ', '销售1号', '有效', '80%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1516, NULL, '1000', '网银', '快手', '高等数学', '10', '一星', '男', '重庆', '1', '冉老师', '哲学', '同学们大家好，这门课属于', 'www.baidu.com', '  1天前 ', '销售1号', '有效', '80%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1517, NULL, '22222', '支付宝', '官方', '高等数学', '10', '一星', '男', '重庆', '1', '冉老师', '哲学', '同学们大家好，这门课属于', 'www.baidu.com', '  2天前 ', '销售1号', '有效', '80%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1518, NULL, '22222', '待付款', 'b站', '高等数学', '3', '一星', '男', '重庆', '1', '冉老师', '哲学', '同学们大家好，这门课属于', 'www.baidu.com', '  12小时前 ', '销售1号', '有效', '80%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1519, NULL, '22222', '账户余额', '知乎', '高等数学', '3', '一星', '男', '重庆', '1', '冉老师', '工学', '同学们大家好，这门课属于', 'www.baidu.com', '  1天前 ', '销售1号', '有效', '80%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1520, NULL, '22222', '微信', '抖音', '高等数学', '3', '一星', '男', '重庆', '1', '冉老师', '工学', '同学们大家好，这门课属于', 'www.baidu.com', '  13小时前 ', '销售1号', '有效', '80%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1521, NULL, '1111', '网银', '快手', '大学物理', '3', '一星', '男', '重庆', '1', '冉老师', '工学', '同学们大家好，这门课属于', 'www.baidu.com', '  7小时前 ', '销售1号', '有效', '80%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1522, NULL, '1111', '支付宝', '官方', '大学物理', '3', '一星', '男', '重庆', '1', '冉老师', '工学', '同学们大家好，这门课属于', 'www.baidu.com', '  1天前 ', '销售1号', '有效', '80%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1523, NULL, '1111', '待付款', 'b站', '大学物理', '10', '三星', '男', '重庆', '22', '冉老师', '理学', '同学们大家好，这门课属于', 'www.baidu.com', '  1天前 ', '销售1号', '有效', '80%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1524, NULL, '1111', '账户余额', '抖音', '大学物理', '10', '三星', '女', '重庆', '22', '李老师', '理学', '同学们大家好，这门课属于', 'www.baidu.com', '  11-02 ', '销售1号', '有效', '80%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1525, NULL, '1111', '网银', '快手', '大学物理', '10', '三星', '女', '湖南', '22', '李老师', '社会学', '同学们大家好，这门课属于', 'www.baidu.com', '  11小时前 ', '销售1号', '有效', '80%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1526, NULL, '1111', '支付宝', '官方', '大学物理', '20', '三星', '女', '湖南', '22', '李老师', '社会学', '同学们大家好，这门课属于', 'www.baidu.com', '  5小时前 ', '销售1号', '有效', '80%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1527, NULL, '1111', '待付款', 'b站', '大学物理', '20', '三星', '女', '湖南', '22', '李老师', '理学', '同学们大家好，这门课属于', 'www.baidu.com', '  6小时前 ', '销售1号', '有效', '80%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1528, NULL, '22222', '账户余额', '知乎', '大学物理', '20', '三星', '女', '湖南', '22', '李老师', '理学', '同学们大家好，这门课属于', 'www.baidu.com', '  10小时前 ', '销售1号', '过期', '80%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1529, NULL, '22222', '微信', '抖音', '马克思', '20', '五星', '女', '湖南', '22', '李老师', '人文', '同学们大家好，这门课属于', 'www.baidu.com', '  11小时前 ', '销售1号', '过期', '50%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1530, NULL, '22222', '待付款', '快手', '马克思', '20', '五星', '女', '湖南', '22', '李老师', '人文', '同学们大家好，这门课属于', 'www.baidu.com', '  12小时前 ', '销售1号', '过期', '50%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1531, NULL, '22222', '账户余额', '官方', '马克思', '20', '五星', '女', '湖南', '22', '陈老师', '人文', '同学们大家好，这门课属于', 'www.baidu.com', '  1天前 ', '销售1号', '过期', '50%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1532, NULL, '22222', '微信', 'b站', '马克思', '20', '五星', '女', '湖南', '22', '陈老师', '人文', '同学们大家好，这门课属于', 'www.baidu.com', '  10小时前 ', '销售2号', '过期', '50%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1533, NULL, '1000', '网银', '知乎', '马克思', '20', '五星', '女', '湖南', '44', '陈老师', '人文', '同学们大家好，这门课属于', 'www.baidu.com', '  2天前 ', '销售2号', '过期', '50%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1534, NULL, '1000', '支付宝', '抖音', '马克思', '20', '五星', '女', '湖南', '44', '陈老师', '人文', '同学们大家好，这门课属于', 'www.baidu.com', '  1天前 ', '销售2号', '过期', '50%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1535, NULL, '1000', '待付款', '快手', '计算机', '20', '五星', '女', '湖南', '44', '陈老师', '人文', '同学们大家好，这门课属于', 'www.baidu.com', '  11-04 ', '销售2号', '过期', '50%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1536, NULL, '1000', '账户余额', '官方', '计算机', '10', '五星', '女', '广州', '44', '陈老师', '社科', '同学们大家好，这门课属于', 'www.baidu.com', '  1天前 ', '销售2号', '过期', '50%', '100', '订单页url');
INSERT INTO `education_info` VALUES (1537, NULL, '1000', '网银', 'b站', '计算机', '10', '五星', '女', '广州', '44', '陈老师', '社科', '同学们大家好，这门课属于', 'www.baidu.com', '  2天前 ', '销售2号', '过期', '50%', '100', '订单页url');

SET FOREIGN_KEY_CHECKS = 1;
