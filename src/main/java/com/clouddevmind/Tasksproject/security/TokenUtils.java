package com.clouddevmind.Tasksproject.security;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {
    
    private final static String ACCESS_TOKEN_SECRET = "RlOUSPLcKTBU0LYE3GtuMvmXLiZ6KE6RHa66yjjdC";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;

    /**
     * Creates a JWT with its expiration time (30 days)
     * @param name
     * @param email
     * @return String
     */
    public static String createToken(String name){
        //Defines the validity seconds in miliseconds by multiplying them
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        //Creates the expiration date in miliseconds using Date() class from Java
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extraInfo = new HashMap<>();
        extraInfo.put("name", name);

        return Jwts.builder()
                .setSubject(name)
                .setExpiration(expirationDate)
                .addClaims(extraInfo)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthenticationToken(String token){
        try{
            Claims claims = Jwts.parserBuilder()
                .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();

            String userName = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(userName, null, Collections.emptyList());

        }catch(JwtException e){
            return null;
        }
    }

}
