package com.hulian.encrypt.po;

import lombok.Data;

@Data
public class EncryptPo {
    private Integer id;
    /**
     * 硬件id
     */
    private String hardId;

    /**
     * 序列编码
     */
    private String licence;
    /**
     * 生成时间
     */
    private Long createTime;

    /**
     * 最后修改时间
     */
    private Long lastUpdateTime;
}
