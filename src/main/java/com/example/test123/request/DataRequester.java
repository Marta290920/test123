package com.example.test123.request;

import com.example.test123.dto.DataDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DataRequester {
    private static final String COMMETS_URL = "https://dummyjson.com/comments";

    private final RestTemplate restTemplate;

    public DataRequester(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DataDTO fetchCommentsData() {
        HttpEntity<DataDTO> entity = new HttpEntity<>(new HttpHeaders());

        return restTemplate.exchange(
                COMMETS_URL,
                HttpMethod.GET,
                entity,
                DataDTO.class).getBody();
    }
}
