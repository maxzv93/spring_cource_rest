package com.max.spring.rest.exception_handing;

/**
 * @author ZuevMYu
 * @since 03.11.2024
 */
public class NoSuchEmployeeException extends RuntimeException{

    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
