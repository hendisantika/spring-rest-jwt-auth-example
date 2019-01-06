package com.hendisantika.jwt.springrestjwtauthexample.service;

import com.hendisantika.jwt.springrestjwtauthexample.exception.FailedToLoginException;
import com.hendisantika.jwt.springrestjwtauthexample.exception.JwtAuthenticationException;
import com.hendisantika.jwt.springrestjwtauthexample.jwt.JwtService;
import com.hendisantika.jwt.springrestjwtauthexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-rest-jwt-auth-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-06
 * Time: 16:55
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UserAuthenticationService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    public String authenticateUser(String username, String password) throws FailedToLoginException {
        boolean isAuthenticated = false;
        if (username.equals("naruto") && password.equals("test123")) {
            isAuthenticated = true;
        } else if (username.equals("sasuke") && password.equals("test123")) {
            isAuthenticated = true;
        }

        if (isAuthenticated) {
            try {
                return jwtService.generateToken(username);
            } catch (URISyntaxException | IOException e) {
                throw new FailedToLoginException(e.getMessage());
            }
        }
        throw new FailedToLoginException(String.format("unable to authenticate user [%s]", username));
    }

    public User authenticateToken(String jwtToken) throws JwtAuthenticationException {

        try {
            String username = jwtService.verifyToken(jwtToken);
            List<String> userRoles = userService.getUserRoles(username);

            User user = new User();
            user.setUsername(username);
            user.setUserRoles(userRoles);
            return user;
        } catch (IOException | URISyntaxException e) {
            throw new JwtAuthenticationException(e.getMessage(), e);
        }
    }
}