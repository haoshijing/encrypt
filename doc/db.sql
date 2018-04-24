drop table  if EXISTS encrypt;
create table devauth(
  id int primary key auto_increment comment '主键id',
  devId varchar(150) comment '设备ID',
  serialNo varchar(2048) comment '授权系列号',
  logDate bigint comment '登记日期',
  lastUpdateTime bigint comment '最后修改时间'
);

drop TABLE IF EXISTS t_admin;
create table t_admin
(
id int primary key auto_increment comment '主键id',
userName varchar(200) comment '用户名',
password varchar(200) comment '密码',
saltPassword varchar(200) comment '加密盐值',
insertTime bigint comment '写入时间',
lastUpdateTime bigint comment '最后修改时间',
status int comment '账号状态'
) comment '管理员表';

Insert into t_admin(id,userName ,password ,saltPassword,insertTime,lastUpdateTime ,status)
select
 null , 'admin','77d3b7ed9db7d236b9eac8262d27f6a5','123',  unix_timestamp()*1000, unix_timestamp()*1000,1;
