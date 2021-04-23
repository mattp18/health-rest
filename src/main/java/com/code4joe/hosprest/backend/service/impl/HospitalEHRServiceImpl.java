package com.code4joe.hosprest.backend.service.impl;

import com.code4joe.hosprest.backend.domain.HospitalEHR;
import com.code4joe.hosprest.backend.service.HospitalEHRService;
import com.code4joe.hosprest.config.ApplicationProperties;
import com.code4joe.hosprest.constant.RequestParamConstants;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class HospitalEHRServiceImpl implements HospitalEHRService {

    private final RestTemplate restTemplate;
    private ApplicationProperties properties;

    public HospitalEHRServiceImpl(RestTemplate restTemplate, ApplicationProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }


    /**
     * Connects to the appropriate endpoint and get, by state and in descending order,
     * the percentage of hospitals that support basic EHR notes in the year 2014.
     *
     * @return list of hospitalEHR
     */
    @Override
    public List<HospitalEHR> getHospitalEHRByStateInDesc() {
        HttpHeaders headers = getHttpHeaders(); //Retrieve the prepared headers.
        UriComponentsBuilder builder = getUriComponentsBuilder(); //Build the uri with the appropriate query parameters.
        HttpEntity<?> entity = new HttpEntity<>(headers); //Instantiates HttpEntity with prepared headers.
        HttpEntity<List<HospitalEHR>> response = getListHttpEntity(builder, entity); //List of HospitalEHR objects retrieved through getListHttpEntity().
        return response.getBody(); //returns response body as list of HospitalEHR objects.
    }

    /**
     * Execute the rest call and return the response.
     *
     * @param builder the builder
     * @param entity  the entity
     * @return list of hospitalEHR
     */
    private HttpEntity<List<HospitalEHR>> getListHttpEntity(UriComponentsBuilder builder, HttpEntity<?> entity) {
        /**
         * Enable of capturing and passing List of HospitalEHR objects
         */
        ParameterizedTypeReference<List<HospitalEHR>> responseType = new ParameterizedTypeReference<>() {};
        return restTemplate.exchange(
                builder.build().toUriString(),
                HttpMethod.GET,
                entity,

                responseType
        );
    }

    /**
     * Build the uri with the appropriate query parameters.
     *
     * @return the uriComponentsBuilder
     */
    private UriComponentsBuilder getUriComponentsBuilder() {
        return UriComponentsBuilder.fromHttpUrl(properties.getEndpoint())
                .queryParam(RequestParamConstants.SOURCE, properties.getSource())
                .queryParam(RequestParamConstants.PERIOD, properties.getPeriod())
                .queryParam(RequestParamConstants.SORT, properties.getSort())
                .queryParam(RequestParamConstants.SORT_DIR, properties.getSortDir());
    }

    /**
     * Retrieve the prepared httpHeaders.
     *
     * @return httpHeaders
     */
    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }


}
