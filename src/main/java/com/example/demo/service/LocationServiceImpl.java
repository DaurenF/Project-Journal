package com.example.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class LocationServiceImpl implements LocationService{

    private final RestTemplate restTemplate;
    @Value("${location-url}")
    private String URL;

    @Autowired
    public LocationServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public LocalDate getLocalDate() {
        return LocalDate.now();
    }

    @Override
    public String getLocation(){
        String response = restTemplate.getForObject(URL, String.class);
        ObjectMapper objMapper = new ObjectMapper();
        JsonNode jsonNode;
        try {
            jsonNode = objMapper.readTree(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        if(jsonNode.get("city").asText().isEmpty()) return "London";

        return jsonNode.get("city").asText();
    }


}
