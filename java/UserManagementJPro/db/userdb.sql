create table t_user
(
	id 			int PRIMARY KEY AUTO_INCREMENT, #用户编号
	username 	varchar(50) NOT NULL, 	#用户名
	password 	varchar(50), 	#密码
	role		int DEFAULT 2,			#用户类型 1 表示管理员 2 表示普通用户
	del			int DEFAULT 0			#删除位 0 表示未删除 1 表示已删除
);

insert into t_user values(1,'admin','admin',1,0);