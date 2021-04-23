package com.code4joe.hosprest.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Data
@Configuration
@ConfigurationProperties(prefix = "api.parameter")
public class ApplicationProperties {

    private String endpoint;
    private String period;
    private String sort;
    private String sortDir;
    private String source;

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
