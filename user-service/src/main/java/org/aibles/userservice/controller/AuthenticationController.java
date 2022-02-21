package org.aibles.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.aibles.userservice.dto.authentication.AuthenticationRequestDTO;
import org.aibles.userservice.exception.LoginException;
import org.aibles.userservice.exception.UserNotFoundException;
import org.aibles.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
//@AllArgsConstructor

public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login (@RequestBody AuthenticationRequestDTO requestDTO){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDTO.getEmail(), requestDTO.getPassword()));
            return ResponseEntity.ok(userService.login(requestDTO.getEmail()));
        }catch (AuthenticationException e){
            throw new LoginException();
        }
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("hello world!!", HttpStatus.OK);
    }

}