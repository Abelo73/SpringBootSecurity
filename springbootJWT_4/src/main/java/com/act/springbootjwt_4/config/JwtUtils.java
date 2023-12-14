package com.act.springbootjwt_4.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Component
public class JwtUtils {

    private String jwtSigningkey = "secrete";

    public String extractUsername(String token){
        return extractClaims(token, Claims::getSubject);
    }

    public<T> T extractClaims(String token, Function<Claims, T>) {
        final Claims claims = extractAllClaims(token);

        return clamsResolver.app
    }

    public Date extractExpiretion(String token){
        return extractClaim(token, Claims::getExpiration)
    }

    public boolean hasClaim(String token, String ClaimName){
        final Claims claims = extractAllClaims(token);
        return claims.get(ClaimName) != null;
    }


    private Claims extractAllClaims(String token){
        return (Claims) Jwts.parser().setSigningKey(jwtSigningkey);
    }

    private boolean isTokenExpired(String token){
        return extractExpiretion(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails){
        Map<String , Object> claims = new HashMap<>();
        return createToken(claims, userDetails);
    }

    public String generateToken(UserDetails userDetails, Map<String, Object> claims){
        return createToken(claims);
    }

    private String createToken(Map<String , Object> claims, UserDetails userDetails){
        return  Jwts.builder().setClaims(claims)
                .setSubject(userDetails.getUsername())
                .claim("authoirties", userDetails.getAuthorities())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24)))
                .signWith(SignatureAlgorithm.ES256, jwtSigningkey).compact();
    }

    public Boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
