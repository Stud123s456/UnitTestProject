package com.todoproject.service;

import com.todoproject.model.dto.ItemDto;
import com.todoproject.model.dto.ItemResponseDto;

import java.util.List;

public interface ItemService {

    List<ItemResponseDto> findByUserId(Long id);

    ItemResponseDto save(ItemDto itemDto);

    void update(ItemDto itemDto, Long id);

    void deleteById(Long id);

}
