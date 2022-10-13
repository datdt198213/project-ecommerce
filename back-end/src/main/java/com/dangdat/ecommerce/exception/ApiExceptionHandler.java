package com.dangdat.ecommerce.exception;

import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value =  HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiException handleAllException(Exception ex, WebRequest request){
        int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        return new ApiException(statusCode, ex.getLocalizedMessage());
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiException todoException(Exception ex, WebRequest request) {
        int statusCode = HttpStatus.BAD_REQUEST.value();
        return new ApiException(statusCode, "There is no object!");
    }

    @ExceptionHandler(PropertyReferenceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiException NoHaveURI() {
        int statusCode = HttpStatus.BAD_REQUEST.value();
        return  new ApiException(statusCode,  "There is no uri like that!");
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ApiException NoUsernameFound() {
        int statusCode = HttpStatus.FORBIDDEN.value();
        return new ApiException(statusCode, "User not found");
    }
}
