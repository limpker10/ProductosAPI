package pe.edu.tecsup.productosapi.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.io.Serializable;
import java.util.*;

@Component
public class JwtTokenService implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenService.class);
    public static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String JWT_TYPE_BEARER = "Bearer ";

    @Value("${jwt.secret}")
    private String JWT_SECRET;
    @Value("${jwt.expiration}")
    private Long JWT_EXPIRATION;

    public String parseToken(String token) {
        logger.info("parseToken: token=" + token);
//        SecretKey secret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(JWT_SECRET));
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(JWT_SECRET).build()
                    .parseClaimsJws(token.replace(JWT_TYPE_BEARER, ""))
                    .getBody();

            String subject = claims.getSubject();
            Date issuedAt = claims.getIssuedAt();
            Date expiration = claims.getExpiration();

            logger.info("END parseToken: subject=" + subject);
            return subject;
        } catch (Exception e) {
            logger.error("Error parsing token: " + e.getMessage(), e);
            throw new JwtException("Token Invalid");
        }
    }

    public String generateToken(String subject) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION * 1000);

        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", subject);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }


    public String refreshToken(String token) {
        String subject = parseToken(token);
        return generateToken(subject);
    }
}
