package com.premit.patient_registry.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenManagement {
    //create a JWT token
    //1.header: algorithm and token type : hs256 & JWT
    //2.payload: sub, iat, expiry : sub: userid
    //3.secret-key : FSLKDFSKL;SF;JSFD34254L;SJFJ;LSDF;SFC3

    private String SECRET_KEY = "FSLKDFSKL;SF;JSFD34254L;SJFJ;LSDF;SFC3";
    private long expiryTimeInMillis = 5*60*1000;

    public String createToken(String userId) {
        String token = Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+expiryTimeInMillis))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();
        return token;
    }

}
