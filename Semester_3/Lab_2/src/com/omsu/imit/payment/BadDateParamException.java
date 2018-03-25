package com.omsu.imit.payment;

public class BadDateParamException extends Exception {
    public BadDateParamException() { }

    public BadDateParamException(String message) {
        super(message);
    }

    public BadDateParamException(String message, Throwable cause) {
        super(message, cause);
    }
}
