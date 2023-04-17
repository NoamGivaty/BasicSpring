package com.basicSpring.config;

import com.google.common.net.HttpHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;

@Component
public class RestTemplateConfig {

    @Bean
    @RequestScope
    public RestTemplate getRestTemplate(HttpServletRequest inReq) {
        final String authHeader =
                inReq.getHeader(HttpHeaders.AUTHORIZATION);
        final RestTemplate restTemplate = new RestTemplate();
        if (authHeader != null && !authHeader.isEmpty()) {
            restTemplate.getInterceptors().add(
                    (outReq, bytes, clientHttpReqExec) -> {
                        outReq.getHeaders().set(
                                HttpHeaders.AUTHORIZATION, authHeader
                        );
                        return clientHttpReqExec.execute(outReq, bytes);
                    });
        }
        return restTemplate;
    }
}