package com.codecool.sportbuddyfinder.exception;

public class ActivityNotFoundException extends RuntimeException{
    public ActivityNotFoundException() {
    super("Activity not found");
    }
}
