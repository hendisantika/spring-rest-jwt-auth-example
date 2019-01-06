package com.hendisantika.jwt.springrestjwtauthexample.jwt;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-rest-jwt-auth-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-06
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 */
@Component
public class SecretKeyProvider {
    public byte[] getKey() throws URISyntaxException, IOException {
        return Files.readAllBytes(Paths.get(this.getClass().getResource("/sample.key").toURI()));
    }
}
