package com.muhammet.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Date;
import java.util.Optional;

@ControllerAdvice
public class JwtTokenManager {
    private final String sifreAnahtari = "#luC}VB>IsC)*>&x**zMqIdD}Pct_%T3w>{9&Zl$tbXZwfF3J+p%iD~o]8-!^`;";
    private final Long exTime = 1000L*60*15;
    public Optional<String> createToken(Long id){
        String token="";
        try{
            /**
             *  withClaim -> içinde Key-Value şeklinde bilgiler saklanır.
             *  Bu bilgiler Paylod olarak tutulur ve herkes tarafından görülür. Bu nedenle buraya özel bilgiler  koyulmaz.
             *  withIssuer -> jwt yi oluşturan kişinin kimliğini tutmak için kullanılır.
             *  withIssuerAt -> Jwt yi oluşturma zamanı
             *  withExpiresAt -> Jwt nin geçerlilik süresi. 30sn - sonsuz
             *  sign -> hazırlanan içeriğin imzalanması yapılır. bunun için bir şifre belirlenir ve bununla kriptolama yapılır.
             */
            token = JWT.create().withAudience()
                    .withClaim("id",id)
                    .withClaim("howtopage","AUTHPAGE")
                    .withClaim("yetki","ADMIN")
                    .withIssuer("Java5")
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis()+exTime))
                    .sign(Algorithm.HMAC512(sifreAnahtari));
            return Optional.of(token);
        }catch (Exception exception){
            return Optional.empty();
        }
    }

    public Boolean validateToken(String token){
        return true;
    }

    public Optional<Long> getIdFromToken(String token){
        return Optional.empty();
    }
}
