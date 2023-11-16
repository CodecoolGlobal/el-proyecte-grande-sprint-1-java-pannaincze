package com.codecool.sportbuddyfinder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){super("User not found");}
    public UserNotFoundException(long id){
        super(String.format("User not found with id: %d", id));
    }
}
