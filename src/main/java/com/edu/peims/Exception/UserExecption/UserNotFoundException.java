package com.edu.peims.Exception.UserExecption;

public class UserNotFoundException extends UserException{
    public UserNotFoundException() {
        super(404, "USER NOT FOUND");
    }
}
