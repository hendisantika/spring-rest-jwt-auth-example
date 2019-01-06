package com.hendisantika.jwt.springrestjwtauthexample.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.security.auth.Subject;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-rest-jwt-auth-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-07
 * Time: 03:50
 * To change this template use File | Settings | File Templates.
 */
public class JwtAuthToken implements Authentication {

    private String token;

    public JwtAuthToken(String token) {
        this.token = token;
    }

    @Override
    public boolean isAuthenticated() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getPrincipal() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getDetails() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getCredentials() {
        return this.token;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
