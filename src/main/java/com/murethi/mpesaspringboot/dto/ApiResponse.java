package com.murethi.mpesaspringboot.dto;

import com.murethi.mpesaspringboot.enums.ApiStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private ApiStatus status;
    private String message;
    private Object data;
}
