package com.codecool.sportbuddyfinder.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){super("User not found");}
}
