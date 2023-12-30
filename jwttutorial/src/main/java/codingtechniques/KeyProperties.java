package codingtechniques;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class KeyProperties {

    public static byte [] hmac256 (SecretKey key, String concatenate)
            throws NoSuchAlgorithmException, InvalidKeyException {

        Mac mac = Mac.getInstance("HmacSHA256");

        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getEncoded(),"HmacSHA256" );
        mac.init(secretKeySpec);

        byte [] hash = mac.doFinal(concatenate.getBytes());

        return  hash;

    }


//    String header = "{\"alg\":\"HS256\"}";
//    String payload = "{\"email\":\"aliyusahaboadam@gmail.com\"}";
//
//    String encodeHeader = Base64.getUrlEncoder()
//            .withoutPadding()
//            .encodeToString(header.getBytes("UTF-8"));
//
//    String encodepayload = Base64.getUrlEncoder()
//            .withoutPadding()
//            .encodeToString(payload.getBytes("UTF-8"));
//
//    String concatenate = encodeHeader + "." + encodepayload;
//
//    byte [] signature = KeyProperties.hmac256(key, concatenate);
//
//    String encodedSignature = Base64.getUrlEncoder()
//            .withoutPadding().encodeToString(signature);
//
//    String jwt = concatenate + "." + encodedSignature;
//
//        System.out.println(concatenate);
//        System.out.println(jwt);
//
//    Claims claims = Jwts.parser().verifyWith(key)
//            .build()
//            .parseSignedClaims(jwt)
//            .getPayload();
//
//        System.out.println(claims);
//
//
//    // hhhhh.pppppp.ssssss

}
