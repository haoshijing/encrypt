package com.hulian.encrypt.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author haoshijing
 * @version 2018年04月24日 13:37
 **/
@Controller
public class AdminIndexController {
    @RequestMapping("/admin")
    public String index(){
        return "index";
    }
}
