/*
Navicat MySQL Data Transfer


Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-10-30 11:17:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_t
-- ----------------------------
DROP TABLE IF EXISTS `user_t`;
CREATE TABLE `user_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Procedure structure for getAllStu
-- ----------------------------
DROP PROCEDURE IF EXISTS `getAllStu`;
DELIMITER ;;
CREATE DEFINER=`root1`@`%` PROCEDURE `getAllStu`()
BEGIN
	SELECT * FROM user_t u WHERE u.age>20;
	

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for getAllUser
-- ----------------------------
DROP PROCEDURE IF EXISTS `getAllUser`;
DELIMITER ;;
CREATE DEFINER=`root1`@`%` PROCEDURE `getAllUser`()
BEGIN 
		SELECT * FROM user_t;
		END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for getUSerById
-- ----------------------------
DROP PROCEDURE IF EXISTS `getUSerById`;
DELIMITER ;;
CREATE DEFINER=`root1`@`%` PROCEDURE `getUSerById`(IN `id` int)
BEGIN
	SELECT * FROM user_t u WHERE u.id=id; 

END
;;
DELIMITER ;
