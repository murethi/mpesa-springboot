package com.murethi.mpesaspringboot.service.impl;

import com.murethi.mpesaspringboot.config.MpesaConfiguration;
import com.murethi.mpesaspringboot.dto.AccessTokenResponse;
import com.murethi.mpesaspringboot.dto.RegisterUrlRequest;
import com.murethi.mpesaspringboot.dto.RegisterUrlResponse;
import com.murethi.mpesaspringboot.service.RegisterUrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static com.murethi.mpesaspringboot.utils.Constants.BEARER_AUTH_STRING;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegisterUrlServiceImpl implements RegisterUrlService {
    private final AccessTokenServiceImpl accessTokenService;
    private final WebClient.Builder webClient;
    private final MpesaConfiguration mpesaConfiguration;
    public RegisterUrlResponse registerUrl(RegisterUrlRequest registerUrlRequest){
        AccessTokenResponse accessTokenResponse = accessTokenService.getAccessToken();

        String accessToken = accessTokenResponse.getAccessToken();
        return webClient.build().post()
                .uri(mpesaConfiguration.getBaseUrl(), uriBuilder
                        -> uriBuilder
                        .path("/mpesa/c2b/v1/registerurl")
                        .build())
                //The bearer token has a validity period
                //store your token and only request a new one if the old one has expired
                 .header("Authorization", String.format("%s %s", BEARER_AUTH_STRING, accessToken))
                .body(Mono.just(registerUrlRequest), RegisterUrlRequest.class)
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> {
                    System.out.println(clientResponse);
                    return clientResponse.createException().flatMap(Mono::error);
                })
                .bodyToMono(RegisterUrlResponse.class)
                .block();
    }
}
