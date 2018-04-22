package com.hulian.encrypt.api.request;

import lombok.Data;

@Data
public class DevAuthRequestVo {
    private Integer page;
    private Integer limit;
    private String deviceId;
}
