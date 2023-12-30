package codingtechniques;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JwtUtil {


    long currentMillis = System.currentTimeMillis();
    long timeValidityforToken = TimeUnit.MINUTES.toMillis(30);
    SecretKey key = Jwts.SIG.HS256.key().build();

    public String createToken (String username) {
        return Jwts.builder()
                .header()
                .add("alg","HS256")
                .add("typ", "JWT")
                .and()

                .signWith(key)
                .issuer("Coding Techniques")
                .issuedAt(new Date(currentMillis))
                .expiration(new Date(currentMillis + timeValidityforToken))
                .claim("username", username)
                .compact();
    }

    public Claims verifyJws (String token) {

      return   Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
    }

    public  boolean chechValidity (String token) {
        return verifyJws(token).getExpiration().after(new Date(currentMillis));
    }
}
