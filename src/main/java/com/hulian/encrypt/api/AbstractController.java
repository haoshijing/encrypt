package com.hulian.encrypt.api;


import com.hulian.encrypt.service.AdminAuthCacheService;
import com.hulian.encrypt.auth.AdminAuthInfo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class AbstractController {
    @Autowired
    protected AdminAuthCacheService adminAuthCacheService;
    private static  final String TOKEN = "X-TOKEN";
    public AdminAuthInfo getToken(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader(TOKEN);
        return adminAuthCacheService.getByToken(token);
    }
}
