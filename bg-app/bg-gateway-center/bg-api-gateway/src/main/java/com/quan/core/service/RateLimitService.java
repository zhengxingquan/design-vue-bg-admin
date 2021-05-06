package com.quan.core.service;

public interface RateLimitService {

    boolean checkRateLimit(String reqUrl, String accessToken);

}
