package com.hulian.encrypt.dao;


import com.hulian.encrypt.po.DevauthPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DevauthtDao {
    DevauthPo selectByDevId(String hardId);
    int insert(DevauthPo encryptPo);

    List<DevauthPo> selectList(@Param("param") DevauthPo devauthPo ,@Param("limit") Integer limit , @Param("offset")Integer offset);

    Integer selectCount(@Param("param") DevauthPo devauthPo);

    Integer updateById(DevauthPo devauthPo);


}
