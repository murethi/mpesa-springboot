package com.murethi.mpesaspringboot.advice;

import com.murethi.mpesaspringboot.dto.ApiError;
import com.murethi.mpesaspringboot.dto.ApiResponse;
import com.murethi.mpesaspringboot.enums.ApiStatus;
import com.murethi.mpesaspringboot.exception.ClientDataException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GeneralExceptionAdvice {
    @ExceptionHandler(ClientDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse clientDataExceptionHandler(ClientDataException ex){
        ApiError apiError =  ApiError.builder()
                .status(404)
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ApiResponse.builder()
                .status(ApiStatus.FAILED)
                .message(ex.getMessage())
                .data(apiError)
                .build();
    }
}
