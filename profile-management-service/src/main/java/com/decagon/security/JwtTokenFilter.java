package com.decagon.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class JwtTokenFilter implements HandlerInterceptor {

    @Value("${jwt.secret}")
    private String secretKey;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        String token = extractTokenFromRequest(request);

        try {
            // Validate the JWT token using the secret key
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            // Extract user information (e.g., user ID) from the token's payload
            String userId = extractUserIdFromToken(token);

            // Set the user ID in the request attributes for further processing
            request.setAttribute("userId", userId);
        } catch (Exception e) {
            // Token validation failed, handle the error (e.g., return 401 Unauthorized)
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        return true;
    }

    private String extractTokenFromRequest(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }

    public String extractUserIdFromToken(String token) {
        // Parse the JWT token to extract the user ID
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
        return claimsJws.getBody().get("userId", String.class);
    }
}