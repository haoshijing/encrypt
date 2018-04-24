package com.hulian.encrypt.api;

import lombok.Data;

/**
 * @author haoshijing
 * @version 2018年04月24日 13:21
 **/
@Data
public class DevauthVo  {
    private Integer id;
    /**
     * 硬件id
     */
    private String devId;

    /**
     * 序列编码
     */
    private String serialNo;
    /**
     * 生成时间
     */
    private String logDate;

}
