CREATE DATABASE `springboot` DEFAULT CHARACTER SET utf8;

CREATE TABLE `city` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '城市编号',
  `province_id` INT(10) UNSIGNED  NOT NULL COMMENT '省份编号',
  `city_name` VARCHAR(25) DEFAULT NULL COMMENT '城市名称',
  `description` VARCHAR(25) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT city VALUES (1 ,1,'长治市','刘宁的家在长治。');

INSERT city VALUES (2 ,2,'廊坊市','曹帅的家在廊坊。');

SELECT * FROM city

CREATE DATABASE `springboot1` DEFAULT CHARACTER SET utf8;


CREATE TABLE `test_user` (
`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
`user_id` INT(10) UNSIGNED NOT NULL COMMENT '用户编号',
`user_name` VARCHAR(25) DEFAULT NULL COMMENT '姓名',
`password` VARCHAR(25) DEFAULT NULL COMMENT '密码',
PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE `user`

INSERT INTO test_user VALUES(1,1,'刘宁','123456');

SELECT * FROM test_user