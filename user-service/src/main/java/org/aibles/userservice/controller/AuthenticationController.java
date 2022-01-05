package org.aibles.userservice.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aibles.userservice.dto.authentication.AuthenticationRequestDTO;
import org.aibles.userservice.exception.ApiRequestException;
import org.aibles.userservice.security.JwtProvider;
import org.aibles.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
            throw new ApiRequestException("Incorrect password or email", HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("hello world!!", HttpStatus.OK);
    }

}
