package com.example.helloworld.controller;

import com.example.helloworld.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParamsControlller {
    @RequestMapping(value = "/getTest1",method = RequestMethod.GET)
    public String getTest1(){
        return "GET请求1";
        //http://localhost:8080/getTest1
    }
    @RequestMapping(value = "/getTest2",method = RequestMethod.GET)
    public String getTest2(String nickname,String phone){
        System.out.println("nickname="+nickname);
        System.out.println("phone="+phone);
        return "GET请求2";
        //http://localhost:8080/getTest2?nickname=xxx&phone=xxx
    }
    @RequestMapping(value = "/getTest3",method = RequestMethod.GET)
    public String getTest3(@RequestParam(value = "nickname",required = false) String name){
        System.out.println("nickname="+name);
        return "GET请求3";
        //http://localhost:8080/getTest3?nickname=xxx
        //前后端打架
    }
    @RequestMapping(value = "/postTest1",method = RequestMethod.POST)
    public String postTest1(){
        return "POST请求1";
        //http://localhost:8080/postTest1
    }
    @RequestMapping(value = "/postTest2",method = RequestMethod.POST)
    public String postTest2(String username,String password){
        System.out.println("username="+username);
        System.out.println("password="+password);
        return "POST请求2";
        //http://localhost:8080/postTest2
    }
    @RequestMapping(value = "/postTest3",method = RequestMethod.POST)
    public String postTest3(User user){
        System.out.println(user);
        return "POST请求3";
        //http://localhost:8080/postTest3
        //不能接受json
    }
    @RequestMapping(value = "/postTest4",method = RequestMethod.POST)
    public String postTest4(@RequestBody User user) {
        System.out.println(user);
        return "POST请求4";
        //http://localhost:8080/postTest4
        //可以接收json
    }
    @GetMapping("/test/**")
    public String test(){
        return "通配符请求";
    }
}
