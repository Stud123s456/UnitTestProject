package com.todoproject.service.impl;

import com.todoproject.dao.ItemRepository;
import com.todoproject.exception.UserNotFoundException;
import com.todoproject.mappers.TodoMapper;
import com.todoproject.model.dto.ItemDto;
import com.todoproject.model.dto.ItemResponseDto;
import com.todoproject.model.entity.Item;
import com.todoproject.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final UserServiceImpl userService;
    private final ItemRepository itemRepository;
    private final TodoMapper itemMapper;

    @Override
    public ItemResponseDto save(ItemDto itemDto) {
        Item item = itemMapper.itemDtoToItem(itemDto);
        item.setUser(userService.findUser(itemDto.getUserId()));
        return itemMapper.itemToItemResponseDto(item);
    }

    @Override
    public void update(ItemDto itemDto, Long id) {
        Item item = itemMapper.itemDtoToItem(itemDto);
        item.setId(id);
        itemRepository.save(item);
    }

    @Override
    public List<ItemResponseDto> findByUserId(Long id) {
        if(!userService.existsByUser(id)){
            throw new UserNotFoundException("User nor found with id: "+id);
        }
        return itemRepository.findById(id).stream()
                .map(itemMapper::itemToItemResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }

}
