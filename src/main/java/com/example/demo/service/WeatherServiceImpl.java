package com.example.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${weather-url}")
    private String url;
    @Value("${weather-api-key}")
    private String apiKey;
    private final RestTemplate restTemplate;

    @Autowired
    public WeatherServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getCurrentWeather(String city) {
        String fullUrl = url + city + apiKey;
        String response = restTemplate.getForObject(fullUrl, String.class);
        ObjectMapper objMapper = new ObjectMapper();
        JsonNode jsonNode;
        try {
            jsonNode = objMapper.readTree(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(jsonNode.get("main").get("feels_like").asInt() - 273);
    }
}
