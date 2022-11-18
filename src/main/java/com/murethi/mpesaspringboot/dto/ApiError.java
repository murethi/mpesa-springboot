package com.murethi.mpesaspringboot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ApiError {
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
