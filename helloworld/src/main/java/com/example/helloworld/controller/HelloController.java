package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping (value = "/sayHello",method = RequestMethod.GET)
    public String sayHello(String nickname,String phone) {
        System.out.println(phone);
        return "Hello " + nickname + " !";
    }
}
