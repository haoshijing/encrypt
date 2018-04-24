package com.hulian.encrypt.dao;



import com.hulian.encrypt.po.AdminPo;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper extends BaseMapper<AdminPo> {
    AdminPo selectByUsername(String userName);

    int updatePwd(@Param("newPwd") String newPwd, @Param("userName") String userName);
}
