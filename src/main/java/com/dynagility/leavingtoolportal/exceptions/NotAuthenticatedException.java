package com.dynagility.leavingtoolportal.exceptions;

public class NotAuthenticatedException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -6835144709329077012L;
    
    public NotAuthenticatedException() {
        super("Session expired or non-existent");
    }
}
