package com.example.helloworld.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;


@TableName("t_order")
public class Order {
    private int id;
    private String order_time;
    private int total;

    @TableField(exist = false)
    private User user;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) { this.order_time = order_time; }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public User getUser() {return user;}

    public void setUser(User user) { this.user = user; }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ",order_time'" + order_time + "'" +
                ",total='" + total + "'" +
                ",user=" + user + "'" +
                '}';
    }
}
