package com.example.jwtbearer.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String handleUserNameNotFound(UsernameNotFoundException ex) {
        log.error("-");
        log.error("-");
        log.error("-");
        log.error(ex.getMessage());
        log.error("-");
        log.error("-");
        log.error("-");
        return ex.getMessage();
    }
}
