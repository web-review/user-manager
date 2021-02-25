package com.example.demo.service.user.impl;

import com.example.demo.service.repository.UserRepository;
import com.example.demo.service.user.User;
import com.example.demo.service.user.UserService;
import com.example.demo.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ConfigurableApplicationContext context) {
        this.userRepository = context.getBean(UserRepository.class);
    }

    @Override
    public List<UserDto> findAll() {
        List<UserDto> users = new LinkedList<>();
        for (User user: userRepository.findAll()) {
            UserDto userDto = new UserDto(user.getId(),
                    user.getName(),
                    user.getLastname(),
                    user.getPosition(),
                    user.getUsername());
            users.add(userDto);
        }
        return users;
    }

    @Override
    public void save(UserDto userDto) {
        User user = new User(userDto.getId(),
                userDto.getName(),
                userDto.getLastname(),
                userDto.getPosition(),
                userDto.getUsername());
        userRepository.save(user);
    }
}
