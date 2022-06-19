package org.sid.ebankingbackend.exceptions;

public class CustomerNotFoundException extends Exception {
    // une exception non surveillee==RuntimeException
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
