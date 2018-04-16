package com.hulian.encrypt.dao;


import com.hulian.encrypt.po.EncryptPo;

public interface EncryptDao {
    EncryptPo selectByHardId(String hardId);
    int insert(EncryptPo encryptPo);
}
