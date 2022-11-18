package com.murethi.mpesaspringboot.service;

import com.murethi.mpesaspringboot.dto.AccessTokenResponse;

public interface AccessTokenService {
    AccessTokenResponse getAccessToken();
    AccessTokenResponse SimulateC2b();
}
