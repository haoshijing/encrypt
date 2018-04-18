drop table  if EXISTS encrypt;
create table devauth(
  id int primary key auto_increment comment '主键id',
  devId varchar(150) comment '设备ID',
  serialNo varchar(2048) comment '授权系列号',
  logDate bigint comment '登记日期',
  lastUpdateTime bigint comment '最后修改时间'
);