package com.murethi.mpesaspringboot.service.impl;

import com.murethi.mpesaspringboot.dto.AccessTokenResponse;
import com.murethi.mpesaspringboot.dto.RegisterUrlRequest;
import com.murethi.mpesaspringboot.dto.RegisterUrlResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUrlServiceImpl {
    private final AccessTokenServiceImpl accessTokenService;
    public RegisterUrlResponse registerUrl(RegisterUrlRequest registerUrlRequest){
        AccessTokenResponse accessTokenResponse = accessTokenService.getAccessToken();
    }
}
