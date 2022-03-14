package com.todoproject.service.impl;

import com.todoproject.dao.UserRepository;
import com.todoproject.exception.UserNotFoundException;
import com.todoproject.mappers.TodoMapper;
import com.todoproject.model.dto.UserDto;
import com.todoproject.model.dto.UserResponseDto;
import com.todoproject.model.entity.User;
import com.todoproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "userCache")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TodoMapper userMapper;

    @Override
    public UserResponseDto save(UserDto userDto){
        User saveUser = userRepository.save(userMapper.userDtoToUser(userDto));
        return userMapper.userToUserResponseDto(saveUser);
    }

    @Override
    @Cacheable(key = "#id")
    public UserResponseDto findUserById(Long userId){
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: "+userId));
        return userMapper.userToUserResponseDto(user);
    }

    @Override
    public User findUser(Long userId){
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: "+userId));
        return user;
    }

    @Override
    @CacheEvict(key = "#id")
    public void delete(Long userId){
        userRepository.deleteById(userId);
    }

    @Override
    public boolean existsByUser(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    @CachePut(key = "#id")
    public void update(UserDto userDto, Long id) {
        User user = userMapper.userDtoToUser(userDto);
        user.setId(id);
        userRepository.save(user);
    }

}
