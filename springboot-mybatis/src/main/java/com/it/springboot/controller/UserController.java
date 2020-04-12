package com.it.springboot.controller;

import com.it.springboot.mapper.UserMapper;
import com.it.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;

    }

    @GetMapping("/addUser")
    public String addUser(){
        User user = new User();
        user.setUsername("小红");
        user.setSex("女");
        user.setAddress("上海");
        userMapper.addUser(user);
        return "addUser-ok";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        User user = userMapper.queryUserById(id);
        user.setUsername("小红2");
        user.setSex("男");
        userMapper.updateUser(user);
        return "updateUser-ok";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userMapper.deleteUser(id);
        return "deleteUser-ok";
    }
}
