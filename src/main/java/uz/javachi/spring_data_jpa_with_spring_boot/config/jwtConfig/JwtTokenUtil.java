package uz.javachi.spring_data_jpa_with_spring_boot.config.jwtConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Component
public class JwtTokenUtil {

    @Value("${secret.key}")
    private String SECRET_KEY;
    private final JwtParser parser;

    public JwtTokenUtil(@Lazy JwtParser parser) {
        this.parser = parser;
    }

    public String generateToken(@NonNull String username) {
        return Jwts.builder()
                .subject(username)
                .expiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                .issuedAt(new Date())
                .issuer("https://javachi.uz")
                .signWith(signKey())
                .compact();
    }

    public SecretKey signKey() {
        byte[] keyBytes = Base64.getDecoder().decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean isValidToken(String token) {
        try {
            Jws<Claims> claimsJws = getClaimsJws(token);
            return !claimsJws.getPayload().getExpiration().before(new Date());
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    private Jws<Claims> getClaimsJws(String token) {
        return parser.parseSignedClaims(token);
    }

    public String extractUsername(String token) {
        return getClaimsJws(token).getPayload().getSubject();
    }
}
