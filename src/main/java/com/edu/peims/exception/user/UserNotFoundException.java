package com.edu.peims.exception.user;

public class UserNotFoundException extends UserException{
    public UserNotFoundException() {
        super(611, "User not found");
    }
}
