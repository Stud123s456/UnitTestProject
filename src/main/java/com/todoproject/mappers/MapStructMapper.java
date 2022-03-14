package com.todoproject.mappers;

import com.todoproject.model.dto.ItemDto;
import com.todoproject.model.dto.ItemResponseDto;
import com.todoproject.model.dto.UserDto;
import com.todoproject.model.dto.UserResponseDto;
import com.todoproject.model.entity.Item;
import com.todoproject.model.entity.User;
import org.springframework.stereotype.Component;

//@Mapper(componentModel = "spring")
@Component
public interface MapStructMapper {

    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

    UserResponseDto userToUserResponseDto(User user);

    Item itemDtoToItem(ItemDto itemDto);

    ItemDto itemToItemDto(Item item);

    ItemResponseDto itemToItemResponseDto(Item item);

}
