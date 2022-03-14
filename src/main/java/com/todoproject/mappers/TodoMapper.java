package com.todoproject.mappers;

import com.todoproject.model.dto.ItemDto;
import com.todoproject.model.dto.ItemResponseDto;
import com.todoproject.model.dto.UserDto;
import com.todoproject.model.dto.UserResponseDto;
import com.todoproject.model.entity.Item;
import com.todoproject.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TodoMapper implements MapStructMapper {

    @Override
    public User userDtoToUser(UserDto userDto){
        return (userDto == null) ? null
                : new User(userDto.getName());
    }

    @Override
    public UserDto userToUserDto(User user){
        return (user == null) ? null
                : new UserDto(user.getName());
    }

    @Override
    public UserResponseDto userToUserResponseDto(User user){
        return (user == null) ? null
                : new UserResponseDto(
                        user.getId(),
                        user.getName(),
                        user.getItemList());
    }

    @Override
    public Item itemDtoToItem(ItemDto itemDto){
        return (itemDto == null) ? null
                : new Item(
                        itemDto.getDescription(),
                        itemDto.getStatus(),
                        new User(itemDto.getUserId()));
    }

    @Override
    public ItemDto itemToItemDto(Item item){
        return (item == null) ? null
                : new ItemDto(
                        item.getDescription(),
                        item.getStatus(),
                        item.getUser().getId());
    }

    @Override
    public ItemResponseDto itemToItemResponseDto(Item item){
        return (item == null) ? null
                : new ItemResponseDto(
                        item.getId(),
                        item.getDescription(),
                        item.getStatus());
    }
}
