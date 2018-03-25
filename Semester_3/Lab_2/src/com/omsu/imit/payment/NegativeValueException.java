package com.omsu.imit.payment;

public class NegativeValueException extends Exception {
    public NegativeValueException() {
        super("Negative value!");
    }

    public NegativeValueException(String message) {
        super(message);
    }

    public NegativeValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
