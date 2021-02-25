package com.example.demo.web.controller;

import com.example.demo.service.user.UserService;
import com.example.demo.service.user.impl.UserServiceImpl;
import com.example.demo.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class UserController {
    UserService userService;

    public UserController() {}

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public List<UserDto> findAll() {
       return userService.findAll();
    }

    @PostMapping(value = "/user/save")
    public void save(UserDto userDto) {
        userService.save(userDto);
    }
}
