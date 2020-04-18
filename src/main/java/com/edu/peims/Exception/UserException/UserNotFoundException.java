package com.edu.peims.Exception.UserException;

public class UserNotFoundException extends UserException{
    public UserNotFoundException() {
        super(611, "User not found");
    }
}
