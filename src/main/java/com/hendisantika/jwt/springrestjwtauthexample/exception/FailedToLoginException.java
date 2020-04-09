package com.hendisantika.jwt.springrestjwtauthexample.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-rest-jwt-auth-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-06
 * Time: 16:50
 * To change this template use File | Settings | File Templates.
 */
public class FailedToLoginException extends Exception {

    public FailedToLoginException(String username) {
        super(username);
    }
}