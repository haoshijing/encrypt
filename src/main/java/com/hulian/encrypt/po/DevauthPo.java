package com.hulian.encrypt.po;

import lombok.Data;

@Data
public class DevauthPo {
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
    private Long logDate;

    /**
     * 最后修改时间
     */
    private Long lastUpdateTime;
}
