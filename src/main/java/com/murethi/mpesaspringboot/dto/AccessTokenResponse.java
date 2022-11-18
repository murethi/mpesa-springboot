package com.murethi.mpesaspringboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccessTokenResponse {
    @JsonProperty("access_token")
    private String AccessToken;
    @JsonProperty("expires_in")
    private String expiresIn;


}
