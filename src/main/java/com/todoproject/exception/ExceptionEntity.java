package com.todoproject.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ExceptionEntity {
    public String message;

    public ExceptionEntity(String message) {
        this.message = message;
    }
}
