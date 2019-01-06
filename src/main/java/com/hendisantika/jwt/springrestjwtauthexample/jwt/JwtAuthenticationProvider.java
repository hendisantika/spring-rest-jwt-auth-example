package com.hendisantika.jwt.springrestjwtauthexample.jwt;

import com.hendisantika.jwt.springrestjwtauthexample.model.User;
import com.hendisantika.jwt.springrestjwtauthexample.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-rest-jwt-auth-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-07
 * Time: 03:53
 * To change this template use File | Settings | File Templates.
 */
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserAuthenticationService authenticationService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = authenticationService.authenticateToken((String) authentication.getCredentials());
        return new JwtAuthenticatedUserToken(user.getUsername(), user.getUserRoles());
    }

    /*
     Returns true if this AuthenticationProvider supports the indicated Authentication object.
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return JwtAuthToken.class.equals(aClass);
    }
}