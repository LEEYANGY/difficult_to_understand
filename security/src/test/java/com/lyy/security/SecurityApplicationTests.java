package com.lyy.security;

import com.lyy.security.framwork.jwt.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityApplicationTests {

    @Test
    void contextLoads() {

        //eyJhbGciOiJIUzI1NiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJSMjQyVtJRSq0oULIyNDOztLQwMDe1qAUAuLEfRR4AAAA.Acec1uT5CaxTgbQRE-3D-NBRC9_m7M1fhGUfn2_6jsE
//        String token = JwtUtils.createToken(123L);
//        System.out.println(token);
        Long userIdFromToken = JwtUtils.getUserIdFromToken("eyJhbGciOiJIUzI1NiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJSMjQyVtJRSq0oULIyNDOztLQwMDe1qAUAuLEfRR4AAAA.Acec1uT5CaxTgbQRE-3D-NBRC9_m7M1fhGUfn2_6jsE");
        System.out.println(userIdFromToken);
    }

}
