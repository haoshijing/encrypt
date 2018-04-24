package com.hulian.encrypt.api.auth.request;

import lombok.Data;

@Data
public class LoginDataRequest {
    private String name;
    private String password;
}
