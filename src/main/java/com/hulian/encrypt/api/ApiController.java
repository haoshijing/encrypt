package com.hulian.encrypt.api;

import com.hulian.encrypt.base.ApiResponse;
import com.hulian.encrypt.dao.DevauthtDao;
import com.hulian.encrypt.dao.EncryptDao;
import com.hulian.encrypt.po.DevauthPo;
import com.hulian.encrypt.po.EncryptPo;
import com.hulian.encrypt.util.CheckService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deviceService")
public class ApiController {

    @Autowired
    private DevauthtDao devauthtDao;

    @RequestMapping("/isAuthoried")
    public ApiResponse<Integer> isAuthoried(String devId){
        final Long DaysMills = 30 *24*3600*10L;
        DevauthPo devauthPo = devauthtDao.selectByDevId(devId);
        if(devauthPo == null){
            DevauthPo insertPo = new DevauthPo();
            insertPo.setLogDate(System.currentTimeMillis());
            insertPo.setDevId(devId);
            devauthtDao.insert(insertPo);
            return  new ApiResponse<>(603,"试用期");
        }else{
            String serialNo = devauthPo.getSerialNo();
            if(StringUtils.isNotEmpty(serialNo)) {
                boolean checkOk = CheckService.checkIsOk(serialNo, devId);
                if (checkOk) {
                    return new ApiResponse<>(6001, "验证通过");
                }
                return new ApiResponse<>(6002,"非法设备");
            }else{
                Long t = devauthPo.getLogDate();
                Long current = System.currentTimeMillis();
                if((current - t ) > DaysMills){
                    return new ApiResponse<>(6002,"非法设备");
                }
            }
            return  new ApiResponse<>(6003,"试用期");
        }
    }

}
