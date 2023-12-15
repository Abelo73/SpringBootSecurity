package com.act.jwtspring.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private static final String SECRETE_KEY = "bPwbLkIXhPEmdTVyRECapubmgpHC6p6N4Ry/Z3zoD4DfhBwAeCSlQ9fCcakU4iRe";
    public String extractUserName(String token) {
        return null;
    }

//    private Claims extractAllClaims(String token){
//
//        return Jwts
//                .parserBuilder()
//                .setSigningKey(getSignInKey)
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }




}
