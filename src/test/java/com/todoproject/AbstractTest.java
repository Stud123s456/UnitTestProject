package com.todoproject;

import com.todoproject.model.dto.ItemDto;
import com.todoproject.model.dto.UserDto;
import com.todoproject.model.entity.ItemStatus;

public abstract class AbstractTest {

    public final Long EXISTING_USER_ID = Long.valueOf(1);
    public final Long NOT_EXISTENT_USER_ID = Long.valueOf(-1);

    public final String USER_SAVE = "/users";
    public final String USER_FIND = "/users/{id}";
    public final String ITEM_SAVE = "/items";
    public final String ITEM_FIND = "/items/{id}";

    public UserDto createUserDto(String userName){
         return new UserDto(userName);
    }

    public ItemDto createItemDto(String description, Long userId){
        return new ItemDto(description, ItemStatus.EXECUTE.getId(), userId);
    }
}
