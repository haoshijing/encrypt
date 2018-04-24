package com.hulian.encrypt.service;


import com.hulian.encrypt.dao.AdminMapper;
import com.hulian.encrypt.po.AdminPo;
import com.hulian.encrypt.util.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class AdminService {

    @Value("${saltEncrypt}")
    private String saltEncrypt;
    @Autowired
    private AdminMapper adminMapper;


    public boolean checkUser(String userName,String password){
        Boolean checkRet  = false;
        AdminPo adminPo = adminMapper.selectByUsername(userName);
        if(adminPo != null){
            String dbPassword = adminPo.getPassword();
            String userPassword = MD5Util.md5(MD5Util.md5(password)+saltEncrypt);
            checkRet =  StringUtils.equals(dbPassword,userPassword);
        }
        return checkRet;
    }

    public Boolean updatePwd(String oldPwd, String newPwd) {
        AdminPo adminPo = adminMapper.selectByUsername("superadmin");
        String dbPassword = adminPo.getPassword();
        String userPassword = MD5Util.md5(MD5Util.md5(oldPwd)+saltEncrypt);
        Boolean checkRet =  StringUtils.equals(dbPassword,userPassword);
        if(!checkRet){
            return false;
        }
        adminMapper.updatePwd(MD5Util.md5(MD5Util.md5(newPwd)+saltEncrypt),"superadmin");
        return  true;
    }
}
