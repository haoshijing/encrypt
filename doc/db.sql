drop table  if EXISTS encrypt;
create table t_encrypt_data(
  id int primary key auto_increment comment '主键id',
  hardId varchar(150) comment '硬件id',
  licence varchar(2048) comment '序列号',
  createTime bigint comment '创建时间',
  lastUpdateTime bigint comment '最后修改时间'
);