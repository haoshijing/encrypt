package com.hulian.encrypt.api;

import com.hulian.encrypt.api.request.DevAuthRequestVo;
import com.hulian.encrypt.base.ApiResponse;
import com.hulian.encrypt.dao.DevauthtDao;
import com.hulian.encrypt.po.DevauthPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author haoshijing
 * @version 2018年04月18日 10:54
 **/

@RequestMapping("/api/admin")
@RestController
public class AdminController {

    @Autowired
    private DevauthtDao devauthtDao;

    @RequestMapping("/queryList")
    public ApiResponse<List<DevauthPo>> queryList(@RequestBody DevAuthRequestVo devAuthRequestVo){
        Integer page = devAuthRequestVo.getPage();
        Integer limit = devAuthRequestVo.getLimit();
        Integer offset = (page -1 )* limit;

        DevauthPo queryPo = new DevauthPo();
        queryPo.setDevId(devAuthRequestVo.getDeviceId());
       List<DevauthPo> devauthPos =  devauthtDao.selectList(queryPo,limit,offset);
       return  new ApiResponse<>(devauthPos);
    }

    @RequestMapping("/queryCount")
    public ApiResponse<Integer> queryCount(@RequestBody DevAuthRequestVo devAuthRequestVo){
        Integer page = devAuthRequestVo.getPage();

        DevauthPo queryPo = new DevauthPo();
        queryPo.setDevId(devAuthRequestVo.getDeviceId());
        Integer count =  devauthtDao.selectCount(queryPo);
        return  new ApiResponse<>(count);
    }

}
