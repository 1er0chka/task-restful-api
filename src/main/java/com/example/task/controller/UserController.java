package com.example.task.controller;

import com.example.task.DTO.TokenDTO;
import com.example.task.DTO.UserDTO;
import com.example.task.config.JwtTokenUtil;
import com.example.task.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class UserController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserFacade userFacade;

    @Autowired
    public UserController(
            AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserFacade userFacade) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userFacade = userFacade;
    }

    @PostMapping("/authentication")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDTO authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
        final UserDetails userDetails = userFacade.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new TokenDTO(token));
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createUser(@RequestBody UserDTO registrationRequest) {
        try {
            userFacade.createUser(registrationRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("User created");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
