package com.example.contactapp.contacts;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ContactExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(ContactNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String contactNotFoundHandler(ContactNotFoundException ex) {
        return ex.getMessage();
    }
}
