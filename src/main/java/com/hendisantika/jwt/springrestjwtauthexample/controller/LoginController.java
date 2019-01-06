package com.hendisantika.jwt.springrestjwtauthexample.controller;

import com.hendisantika.jwt.springrestjwtauthexample.exception.FailedToLoginException;
import com.hendisantika.jwt.springrestjwtauthexample.model.AuthenticationResponse;
import com.hendisantika.jwt.springrestjwtauthexample.model.UserCredentials;
import com.hendisantika.jwt.springrestjwtauthexample.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-rest-jwt-auth-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-07
 * Time: 03:55
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class LoginController {

    @Autowired
    private UserAuthenticationService authenticationService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AuthenticationResponse userLogin(@RequestBody UserCredentials userCredentials) throws FailedToLoginException {

        if (userCredentials == null || (userCredentials.getUsername() == null || userCredentials.getPassword() == null)) {
            throw new FailedToLoginException("Missing login credentials ");
        }

        String token = authenticationService.authenticateUser(userCredentials.getUsername(), userCredentials.getPassword());

        if (token != null) {
            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setUsername(userCredentials.getUsername());
            authenticationResponse.setToken(token);
            return authenticationResponse;
        }
        throw new FailedToLoginException(String.format(" unable to authenticate user [%s] ", userCredentials.getUsername()));
    }
}