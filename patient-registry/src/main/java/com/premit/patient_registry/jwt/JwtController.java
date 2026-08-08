package com.premit.patient_registry.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    JwtTokenManagement jwtTokenManagement;

    @GetMapping("/create/token/{userId}")
    public String createToken(@PathVariable String userId){
        String token = jwtTokenManagement.createToken(userId);
        return token;
    }
}
