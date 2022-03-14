package com.todoproject.exception;

public class ItemNotFoundExeption extends RuntimeException {
    public ItemNotFoundExeption(String message) {
        super(message);
    }
}
