package com.todoproject.exception.handler;

import com.todoproject.exception.ExceptionEntity;
import com.todoproject.exception.ItemNotFoundExeption;
import com.todoproject.exception.UserNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
//@RequiredArgsConstructor
public class TodoListExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(value = BAD_REQUEST)
    public ExceptionEntity handleException(MethodArgumentNotValidException e){
        return new ExceptionEntity(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(value = INTERNAL_SERVER_ERROR)
    public ExceptionEntity handleException(Exception e){
        return new ExceptionEntity(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(value = NOT_FOUND)
    public ExceptionEntity handleException(UserNotFoundException e){
        return new ExceptionEntity(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(value = NOT_FOUND)
    public ExceptionEntity handleException(ItemNotFoundExeption e){
        return new ExceptionEntity(e.getMessage());
    }

}
