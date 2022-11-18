package com.murethi.mpesaspringboot.controller;


import com.murethi.mpesaspringboot.dto.AccessTokenResponse;
import com.murethi.mpesaspringboot.dto.RegisterUrlRequest;
import com.murethi.mpesaspringboot.dto.RegisterUrlResponse;
import com.murethi.mpesaspringboot.service.AccessTokenService;
import com.murethi.mpesaspringboot.service.RegisterUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mobile-money/")
public class MobileMoneyController {
    private final RegisterUrlService registerUrlService;
    @GetMapping(value = "/register-url")
    public RegisterUrlResponse RegisterUrl(@RequestBody RegisterUrlRequest registerUrlRequest){
        return registerUrlService.registerUrl(registerUrlRequest);
    }
}
