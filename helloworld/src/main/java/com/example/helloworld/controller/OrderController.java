package com.example.helloworld.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.mapper.OrderMapper;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    public OrderMapper orderMapper;

    @GetMapping("/order/findAll")
    public List findAll(){
        List orders = orderMapper.selectAllOrdersAndUsers();
        return orders;
    }
}
