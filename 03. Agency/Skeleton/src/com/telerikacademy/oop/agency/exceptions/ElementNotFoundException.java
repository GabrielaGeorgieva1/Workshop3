package com.telerikacademy.oop.agency.exceptions;

public class ElementNotFoundException extends RuntimeException {

    public ElementNotFoundException() {
    }

    public ElementNotFoundException(String message) {
        super(message);
    }

}
