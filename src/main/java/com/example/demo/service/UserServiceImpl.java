package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Date;

@Service
public class UserServiceImpl implements  UserService{
    private String city="Undefined";
    public final RestTemplate restTemplate;
    public final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(RestTemplate restTemplate, UserRepository userRepository) {
        this.restTemplate = restTemplate;
        this.userRepository = userRepository;
    }

    @Override
    public LocalDate getLocalDate() {
        return LocalDate.now();
    }
    @Override
    public void getLocation(){
        String url = "https://ipgeolocation.abstractapi.com/v1/?api_key=782c2ba14e7f4c06bb65a68a4a2b7b84";
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper objMapper = new ObjectMapper();
        JsonNode jsonNode;
        try {
            jsonNode = objMapper.readTree(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        city = jsonNode.get("city").asText();
    }
    @Override
    public String getCurrentWeather()  {
        if(city.startsWith("Undefined")) return "Could not define the weather";
        System.out.println("CITY: "+city);
        String url = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=9544871686a0d704298927f77ba9e6c3";
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper objMapper = new ObjectMapper();
        JsonNode jsonNode;
        try {
            jsonNode = objMapper.readTree(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(jsonNode.get("main").get("feels_like").asInt()-273);
    }

    @Override
    public Date getExpirationDatePermById(long id) {
        return userRepository.getExpirationDatePermById(id);
    }



    @Override
    public void save(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setExp_date(LocalDate.now().minusDays(1));
        userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByEmail(username);
    }

    public String getCity() {
        if(city == null) return "Could not define location";
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
}
