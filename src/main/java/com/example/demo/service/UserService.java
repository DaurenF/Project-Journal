package com.example.demo.service;

import com.example.demo.models.User;

import java.time.LocalDate;
import java.util.Date;

public interface UserService {
    LocalDate getLocalDate() ;

    void getLocation() ;

    String getCurrentWeather();

    Date getExpirationDatePermById(long id);
    void save(User user);
    User getUserByUsername(String username);


}



