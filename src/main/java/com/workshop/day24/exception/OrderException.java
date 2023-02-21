package com.workshop.day24.exception;

public class OrderException extends Exception{
    public OrderException() {
        super();
    }

    public OrderException(String message) {
        super(message);
    }
}
