package com.codecool.sportbuddyfinder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ActivityNotFoundException extends RuntimeException{
    public ActivityNotFoundException() {
    super("Activity not found");
    }
    public ActivityNotFoundException(long id){
        super(String.format("Activity not found with id: %d", id));
    }
}
