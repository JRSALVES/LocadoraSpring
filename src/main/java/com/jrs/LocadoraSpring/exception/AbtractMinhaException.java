package com.jrs.LocadoraSpring.exception;

public abstract class AbtractMinhaException extends RuntimeException {
    public AbtractMinhaException(String message) {super(message);}

    public AbtractMinhaException(String message, Throwable cause) {super(message, cause);}
}
