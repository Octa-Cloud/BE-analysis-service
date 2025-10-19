package com.project.analysis.global.security;

import com.project.analysis.global.exception.RestApiException;
import com.project.analysis.global.properties.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import static com.project.analysis.global.exception.code.status.AuthErrorStatus.UNSUPPORTED_JWT;

@Service
@RequiredArgsConstructor
public class TokenProvider {

    private final JwtProperties jwtProperties;

    public Optional<Long> getId(String token) {
        try {
            return Optional.ofNullable(getClaims(token).get(jwtProperties.getId(), Long.class));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<String> getToken(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(jwtProperties.getTokenHeader()))
                .filter(token -> token.startsWith(jwtProperties.getBearer()))
                .map(token -> token.replace(jwtProperties.getBearer() + " ", ""));
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(jwtProperties.getKey().getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Optional<Date> getExpiration(String token) {
        try {
            return Optional.ofNullable(getClaims(token).getExpiration());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
