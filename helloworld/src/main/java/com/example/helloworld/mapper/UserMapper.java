package com.example.helloworld.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.helloworld.entity.Order;
import org.apache.ibatis.annotations.*;

import com.example.helloworld.entity.User;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
//    @Select("select * from user")
//    List<User> findAll();
//    @Select("select * from user where id =#{id}")
//    int findById(int id);
//    @Insert("insert into user values (#{id},#{username},#{password})")
//    int insert(User user);
//    @Update("update user set username=#{username},password=#{password} where id=#{id}")
//    int update(User user);
//    @Delete("delete from user where id=#{id}")
//    int delete(int id);


    @Select("select * from t_user")
    @Results(
            {
                    @Result(column = "id",property = "id"),
                    @Result(column = "username",property = "username"),
                    @Result(column = "password",property = "password"),
                    @Result(column = "id",property = "orders",javaType = List.class,
                            many = @Many(select = "com.example.helloworld.mapper.OrderMapper.selectByUid" )
                    )
            })
    List<User> selectAllUsersAndOrders();
}
