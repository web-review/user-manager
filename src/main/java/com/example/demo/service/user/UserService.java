package com.example.demo.service.user;

import com.example.demo.web.dto.UserDto;
import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    void save(UserDto userDto);
}
