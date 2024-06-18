package com.example.helloworld.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.helloworld.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.helloworld.entity.User;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    public UserMapper userMapper;

    @ApiOperation("获取用户")//注释
    @GetMapping("/user")
    public List query() {
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
        return list;
    }

    @ApiOperation("根据id获取单个用户")
    @GetMapping("/user/{id}")
    public String selectById(@PathVariable int id) {
        System.out.println(id);
        return "根据ID获取用户信息";
    }

    //多表查询 （实际工作中一般单表查询后组装）
    @ApiOperation("查询所有用户及订单")
    @GetMapping("/user/findAll")
    public List<User> findAll() {
        return userMapper.selectAllUsersAndOrders();
    }

    //条件查询 （实际工作中使用xml）
    @GetMapping("/user/find")
    public List<User> findByCond(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username","张三");
        return userMapper.selectList(queryWrapper);
    }

    //分页查询
    @GetMapping("/user/findByPage")
    public IPage findByPage(){
        Page<User> page = new Page<>(0,2);
        IPage iPage = userMapper.selectPage(page, null);
        return iPage;
    }

    @ApiOperation("插入用户")
    @PostMapping("/user")
    public String save(User user) {
        int i = userMapper.insert(user);
        System.out.println(user);
        if (i > 0) {
            return "插入成功";
        } else{
            return "插入失败";
        }
    }

    @ApiOperation("更新用户")
    @PutMapping("/user")
    public String update(User user) {
        int i = userMapper.updateById(user);
        if (i > 0) {
            return "更新成功";
        }else{
            return "更新失败";
        }
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/user/{id}")
    public String deleteById(int id) {
        int i = userMapper.deleteById(id);
        if (i > 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}
