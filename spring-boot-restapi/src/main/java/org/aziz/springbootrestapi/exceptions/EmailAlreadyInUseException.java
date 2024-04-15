package org.aziz.springbootrestapi.exceptions;

public class EmailAlreadyInUseException extends Exception {
    public EmailAlreadyInUseException() {
        super("This email is already in use");
    }
}
