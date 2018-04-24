package com.hulian.encrypt.api;

import com.hulian.encrypt.api.request.DevAuthRequestVo;
import com.hulian.encrypt.api.request.DevauthUpdateVo;
import com.hulian.encrypt.base.ApiResponse;
import com.hulian.encrypt.dao.DevauthtDao;
import com.hulian.encrypt.po.DevauthPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public ApiResponse<List<DevauthVo>> queryList(@RequestBody DevAuthRequestVo devAuthRequestVo){
        Integer page = devAuthRequestVo.getPage();
        Integer limit = devAuthRequestVo.getLimit();
        Integer offset = (page -1 )* limit;

        DevauthPo queryPo = new DevauthPo();
        queryPo.setDevId(devAuthRequestVo.getDevId());
       List<DevauthPo> devauthPos =  devauthtDao.selectList(queryPo,limit,offset);
       List<DevauthVo> devauthVos = devauthPos.stream().map(devauthPo -> {
           DevauthVo devauthVo = new DevauthVo();
           devauthVo.setId(devauthPo.getId());
           devauthVo.setDevId(devauthPo.getDevId());
           devauthVo.setSerialNo(devauthPo.getSerialNo());
           devauthVo.setLogDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(devauthPo.getLogDate())));
           return devauthVo;
       }).collect(Collectors.toList());
       return  new ApiResponse(devauthPos);
    }

    @RequestMapping("/queryCount")
    public ApiResponse<Integer> queryCount(@RequestBody DevAuthRequestVo devAuthRequestVo){

        DevauthPo queryPo = new DevauthPo();
        queryPo.setDevId(devAuthRequestVo.getDevId());
        Integer count =  devauthtDao.selectCount(queryPo);
        return  new ApiResponse<>(count);
    }

    @RequestMapping("/updateData")
    public ApiResponse<Integer> updateData(@RequestBody DevauthUpdateVo devAuthRequestVo){
        DevauthPo updatePo = new DevauthPo();
        updatePo.setId(devAuthRequestVo.getId());
        updatePo.setLastUpdateTime(System.currentTimeMillis());
        updatePo.setSerialNo(devAuthRequestVo.getSerialNo());
        devauthtDao.updateById(updatePo);
        return  new ApiResponse<>(1);
    }

}
