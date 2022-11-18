package com.murethi.mpesaspringboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUrlRequest{

    @JsonProperty("ShortCode")
    private String shortCode;

    @JsonProperty("ConfirmationURL")
    private String confirmationURL;

    @JsonProperty("ValidationURL")
    private String validationURL;

    @JsonProperty("ResponseType")
    private String responseType;
}
