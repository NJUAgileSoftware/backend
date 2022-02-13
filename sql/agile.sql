
DROP TABLE if exists `user`;
CREATE TABLE `user` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                        `username` varchar(20) NOT NULL,
                        `password` varchar(20) NOT NULL,
                        `role` tinyint(1) NOT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;


DROP table if exists `task`;
create table `task`(
    `id` bigint(20) not null auto_increment,
    `name` varchar(20) not null,
    `level` int not null,
    `state` int not null,
    `workload` int,
    `description` varchar(255) default null,
    `startTime` datetime not null ,
    `endTime` datetime default null,
    primary key (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;