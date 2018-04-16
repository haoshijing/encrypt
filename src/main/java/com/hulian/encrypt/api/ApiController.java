package com.hulian.encrypt.api;

import com.hulian.encrypt.base.ApiResponse;
import com.hulian.encrypt.dao.EncryptDao;
import com.hulian.encrypt.po.EncryptPo;
import com.hulian.encrypt.util.CheckService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/check")
public class ApiController {

    @Autowired
    private EncryptDao encryptDao;

    @RequestMapping("/checkHardId")
    public ApiResponse<Integer> checkHardId(String hardId){

        EncryptPo encryptPo = encryptDao.selectByHardId(hardId);
        if(encryptPo == null){
            EncryptPo insertPo = new EncryptPo();
            insertPo.setCreateTime(System.currentTimeMillis());
            insertPo.setHardId(hardId);
            encryptDao.insert(insertPo);
            return  new ApiResponse<>(602,"没有序列号");
        }else{
            String licence = encryptPo.getLicence();
            if(StringUtils.isNotEmpty(licence)) {
                boolean checkOk = CheckService.checkIsOk(licence, hardId);
                if (checkOk) {
                    return new ApiResponse<>(603, "验证通过");
                }
                return new ApiResponse<>(604,"伪造的token");
            }
            return  new ApiResponse<>(602,"没有序列号");
        }
    }

}
