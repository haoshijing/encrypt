package com.hulian.encrypt.auth;

import lombok.Data;

@Data
public class AdminAuthInfo {
    private String userName;
    private Integer level;
    private String token;
}
