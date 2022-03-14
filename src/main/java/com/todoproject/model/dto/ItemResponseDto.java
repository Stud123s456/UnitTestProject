package com.todoproject.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class ItemResponseDto {

    private long itemId;
    public String description;
    public Integer status;

    public ItemResponseDto(long itemId, String description, Integer status) {
        this.itemId = itemId;
        this.description = description;
        this.status = status;
    }
}
