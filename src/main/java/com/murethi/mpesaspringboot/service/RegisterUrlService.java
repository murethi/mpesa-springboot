package com.murethi.mpesaspringboot.service;

import com.murethi.mpesaspringboot.dto.RegisterUrlRequest;
import com.murethi.mpesaspringboot.dto.RegisterUrlResponse;

public interface RegisterUrlService {
    public RegisterUrlResponse registerUrl(RegisterUrlRequest registerUrlRequest);
}
