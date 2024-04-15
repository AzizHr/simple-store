package org.aziz.springbootrestapi.exceptions;

public class UsernameNotFoundException extends Exception {
    public UsernameNotFoundException(String message){
        super(message);
    }
}
