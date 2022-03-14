package com.todoproject.controller;

import com.todoproject.model.dto.UserDto;
import com.todoproject.model.dto.UserResponseDto;
import com.todoproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@ResponseStatus(value = HttpStatus.OK)
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/{id}")
    public UserResponseDto findUser(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public UserResponseDto createUser(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UserDto userDto){
        userService.update(userDto, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.delete(id);
    }

}
