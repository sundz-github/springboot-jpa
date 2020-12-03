package com.sundz.controller;

import com.sundz.jpa.entity.User;
import com.sundz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Sundz
 * @version: V1.0
 * @date: 2020/9/27 14:22
 */
@RestController
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User getUser(@PathVariable(value = "id") Integer id){
        return userService.getUser(id);
    }
}
