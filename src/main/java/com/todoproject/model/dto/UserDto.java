package com.todoproject.model.dto;

import lombok.Data;

@Data
public class UserDto {

    public String name;

    public UserDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
