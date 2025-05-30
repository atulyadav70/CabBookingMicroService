package com.cbs.User.Exceptions;

public class UserDoesNotExistException  extends RuntimeException{
    public String message(){
        return "User Does not Exist. Please Register!!!";
    }
}
