package com.todoproject.controller;

import com.todoproject.model.dto.ItemDto;
import com.todoproject.model.dto.ItemResponseDto;
import com.todoproject.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@ResponseStatus(value = HttpStatus.OK)
@RequiredArgsConstructor
@Validated
public class TodoListController {

    private final ItemService itemService;

    @GetMapping("/{id}")
    public List<ItemResponseDto> getItemsListByUserId(@PathVariable Long id){
        return itemService.findByUserId(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ItemResponseDto saveItem(@RequestBody ItemDto itemDto){
        return itemService.save(itemDto);
    }

    @PutMapping("/{id}")
    public void updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto){
        itemService.update(itemDto, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteItemById(@PathVariable Long id){
        itemService.deleteById(id);
    }

}
