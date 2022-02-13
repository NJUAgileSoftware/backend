package com.bolingcavalry.mavendockerplugindemo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Hello {

    @RequestMapping("/hello")
    public String sayHello(){
    	//修改返回的字符串的内容
        return "123456. Hello jenkins, " + new Date();
    }
}
