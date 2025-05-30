
package com.cbs.User.Exceptions;


public class IncorrectPasswordException extends RuntimeException { // Or extends Exception
    public IncorrectPasswordException() {
        super("Incorrect Password or Username. Please retry.");
    }

    public IncorrectPasswordException(String message) {
        super(message);
    }

    public IncorrectPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}