package ApiProyectoM12.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.*;

public class TokenUtils {

    private final static String ACCESS_TOKEN_SECRET = "eyJhbGciOiJIUzI1NiJ9.ew0KICAic3ViIjogIjEyMzQ1Njc4OTAiLA0KICAibmFtZSI6ICJBbmlzaCBOYXRoIiwNCiAgImlhdCI6IDE1MTYyMzkwMjINCn0.xi7_4_CR_jry25dZRZ-prYLw5zSHbB4yiS5MfD-SKMI";
    private final static Long ACCESS_TOKEN_EXPIRATION = 1000L * 60 * 60 * 24 * 7; // 7 days


    public static String createToken (String username, String email) {
        long expirationTime = ACCESS_TOKEN_EXPIRATION * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
        Map<String, Object> extra = new HashMap<>();
        extra.put("username", username);
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                //.claim("roles", roles)
                .signWith(SignatureAlgorithm.HS256,ACCESS_TOKEN_SECRET.getBytes())
                .compact();
    }
    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {

            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            String email = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());

        } catch (JwtException e) {
            return null;
        }
    }
}
