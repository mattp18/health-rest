package com.code4joe.hosprest.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationProperties {

    /**
     * Creates an instance of a restTemplate to be used for rest calls.
     *
     * @param builder the restTemplateBuilder
     * @return the restTemplate
     * @see RestTemplateBuilder
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
