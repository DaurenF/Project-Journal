package com.example.demo.controllers;

import com.example.demo.dto.AuthDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.models.User;
import com.example.demo.security.JWTUtil;
import com.example.demo.service.RegistrationService;
import com.example.demo.util.UserValidator;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Controller for authentication
 *
 * @author Dauren
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final RegistrationService registrationService;
    private final UserValidator userValidator;
    private final JWTUtil jwtUtil;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(RegistrationService registrationService, UserValidator userValidator,
                          JWTUtil jwtUtil, ModelMapper modelMapper, AuthenticationManager authenticationManager) {
        this.registrationService = registrationService;
        this.userValidator = userValidator;
        this.jwtUtil = jwtUtil;
        this.modelMapper = modelMapper;
        this.authenticationManager = authenticationManager;
    }

    /**
     * @param authDTO       Data Transfer object from client
     * @param bindingResult Checks the form for errors and if it has some, then returns the error
     * @return Returns a new token to access api for 60 minutes
     */
    @PostMapping(value = "/registration", consumes = "application/json")
    public Map<String, String> performRegistration(@RequestBody @Valid AuthDTO authDTO,
                                                   BindingResult bindingResult) {
        User user = convertToPerson(authDTO);


        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors().toString());
            return Map.of("message", "Ошибка!");
        }

        registrationService.register(user);

        String token = jwtUtil.generateToken(user.getUsername());
        return Map.of("jwt-token", token);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> performLogin(@RequestBody AuthDTO authenticationDTO) {
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(),
                        authenticationDTO.getPassword());

        try {
            authenticationManager.authenticate(authInputToken);
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body(Map.of("message", "Incorrect credentials!"));
        }

        String token = jwtUtil.generateToken(authenticationDTO.getUsername());
        return ResponseEntity.ok(Map.of("jwt-token", token));
    }

    public User convertToPerson(AuthDTO personDTO) {
        return this.modelMapper.map(personDTO, User.class);
    }

}
