package com.todoproject.service;

import com.todoproject.model.dto.UserDto;
import com.todoproject.model.dto.UserResponseDto;
import com.todoproject.model.entity.User;

public interface UserService {

    UserResponseDto findUserById(Long id);

    UserResponseDto save(UserDto userDto);

    User findUser(Long userId);

    void update(UserDto userDto, Long id);

    boolean existsByUser(Long id);

    void delete(Long id);

}
