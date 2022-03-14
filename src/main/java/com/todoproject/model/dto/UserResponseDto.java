package com.todoproject.model.dto;

import com.todoproject.model.entity.Item;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class UserResponseDto {

    private long userId;
    public String name;
    public List<Item> itemList;

    public UserResponseDto(long userId, String name, List<Item> itemList) {
        this.userId = userId;
        this.name = name;
        this.itemList = itemList;
    }
}
