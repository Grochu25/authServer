package com.grochu.authserver;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class EnvironmentalConfig
{
    @Value("${ADMIN_HOSTNAME}")
    private String adminHostname = "127.0.0.1";
    @Value("${ADMIN_PORT}")
    private String adminPort = "8000";
    @Value("${AUTH_HOSTNAME}")
    private String authHostname = "localhost";
    @Value("${AUTH_PORT}")
    private String authPort = "9000";
    @Value("${RESOURCE_HOSTNAME}")
    private String resourceHostname = "localhost";
    @Value("${RESOURCE_PORT}")
    private String resourcePort = "8080";
    @Value("${CLIENT_HOSTNAME}")
    private String clientHostname = "localhost";
    @Value("${CLIENT_PORT}")
    private String clientPort = "5173";
}
