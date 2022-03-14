package com.todoproject.model.dto;

import lombok.Data;

@Data
public class ItemDto {

    public String description;
    public Integer status;
    public Long userId;

    public ItemDto() {
    }

    public ItemDto(String description, Integer status, Long userId) {
        this.description = description;
        this.status = status;
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStatus() {
        return status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
