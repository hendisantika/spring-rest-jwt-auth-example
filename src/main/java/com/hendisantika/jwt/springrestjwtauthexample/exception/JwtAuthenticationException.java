package com.hendisantika.jwt.springrestjwtauthexample.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-rest-jwt-auth-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-06
 * Time: 16:51
 * To change this template use File | Settings | File Templates.
 */
public class JwtAuthenticationException extends AuthenticationException {

    public JwtAuthenticationException(String msg) {
        super(msg);
    }

    public JwtAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }
}