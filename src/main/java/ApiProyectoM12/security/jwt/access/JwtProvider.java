package ApiProyectoM12.security.jwt.access;

import ApiProyectoM12.modelo.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import jakarta.annotation.PostConstruct;
import lombok.extern.java.Log;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Log
@Service
public class JwtProvider {

    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.duration}")
    private int jwtLifeInDays;

    private JwtParser jwtParser;
    private SecretKey secretKey;
    @PostConstruct
    public void init() {
        secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        jwtParser = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build();
    }

    public String generateToken(Authentication authentication) {
    User user = (User) authentication.getPrincipal();
    Date tokenExpirationDateTime =
            Date.from(
                    LocalDateTime
                            .now()
                            .plusDays(jwtLifeInDays)
                            .atZone(ZoneId.systemDefault())
                            .toInstant()
            );
    return Jwts.builder()
            .setHeaderParam("typ", TOKEN_TYPE)
            .setSubject(user.getId().toString())
            .setIssuedAt(new Date())
            .setExpiration(tokenExpirationDateTime)
            .signWith(secretKey)
            .compact();
    }
    public boolean validateToken(String token) {
        try {
            jwtParser.parseClaimsJws(token);
            return true;
        } catch (SignatureException | MalformedJwtException | ExpiredJwtException
        | UnsupportedJwtException | IllegalArgumentException e) {
            log.warning("Invalid JWT token");
            log.warning(e.getMessage());
        }
        return false;


    }
    public UUID getUserIdFromJwtToken(String token) {
        return  UUID.fromString(jwtParser.parseClaimsJws(token).getBody().getSubject());
    }








}
