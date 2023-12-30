package codingtechniques;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class App
{
    public static void main( String[] args ) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException {
          //{"alg":"HS256"}
          // {"email":"aliyusahaboadam@gmail.com"}

        JwtUtil jwtUtil = new JwtUtil();

        String token =jwtUtil.createToken("Aliyu");
        System.out.println(token);
        Claims claims = jwtUtil.verifyJws(token);
        System.out.println(claims);
       boolean validity =  jwtUtil.chechValidity(token);
        System.out.println(validity);







    }
}
