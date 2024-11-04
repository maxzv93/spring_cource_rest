package com.max.spring.rest.exception_handing;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author ZuevMYu
 * @since 04.11.2024
 */
@ControllerAdvice
public class EmployeeGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeException noSuchEmployeeException) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(noSuchEmployeeException.getMessage());
        return new ResponseEntity<>(data, NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(Exception exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
