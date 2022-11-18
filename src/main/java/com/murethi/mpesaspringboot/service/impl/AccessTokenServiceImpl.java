package com.murethi.mpesaspringboot.service.impl;

import com.murethi.mpesaspringboot.config.MpesaConfiguration;
import com.murethi.mpesaspringboot.dto.AccessTokenResponse;
import com.murethi.mpesaspringboot.exception.ClientDataException;
import com.murethi.mpesaspringboot.service.AccessTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import reactor.core.publisher.Mono;

import java.util.Base64;

import static com.murethi.mpesaspringboot.utils.Constants.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccessTokenServiceImpl implements AccessTokenService {
    private final MpesaConfiguration mpesaConfiguration;
    private final Builder webClient;
    @Override
    public AccessTokenResponse getAccessToken() {

        String formattedCredentials=String.format("%s:%s", mpesaConfiguration.getConsumerKey(),
                mpesaConfiguration.getConsumerSecret());

        String encodedCredentials = Base64.getEncoder().encodeToString(formattedCredentials.getBytes());
        //TODO add auth headers
        return webClient.build().get()
                .uri(mpesaConfiguration.getBaseUrl(), uriBuilder
                        -> uriBuilder
                        .path("/oauth/v1/generate")
                        .queryParam("grant_type",mpesaConfiguration.getGrantType())
                        .build())
                .header(AUTHORIZATION_HEADER_STRING,String.format("%s %s",BASIC_AUTH_STRING,encodedCredentials))
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,clientResponse -> handle4xxError(clientResponse))
                .bodyToMono(AccessTokenResponse.class).block();
    }

    @Override
    public AccessTokenResponse SimulateC2b() {
        return null;
    }

    private Mono<? extends Throwable> handle4xxError(ClientResponse clientResponse){
        Mono<String> errorMessage = clientResponse.bodyToMono(String.class);
        return errorMessage.flatMap((message)->{
            log.error("Error response code is "+clientResponse.rawStatusCode()+" and message is "+
                    message);
            throw new ClientDataException(message);
        });
    }
}
