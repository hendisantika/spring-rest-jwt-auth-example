package com.hendisantika.jwt.springrestjwtauthexample.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-rest-jwt-auth-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-06
 * Time: 16:54
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserService {

    public List<String> getUserRoles(String username) {

        List<String> userRoles = new ArrayList<String>();

        if (username != null && username.equals("naruto")) {
//            return Arrays.asList("ROLE_USER", "ROLE_ADMIN");
            return Arrays.asList("ROLE_ADMIN");
        } else if (username != null && username.equals("sasuke")) {
            return Arrays.asList("ROLE_USER");
        }
        return userRoles;
    }
}