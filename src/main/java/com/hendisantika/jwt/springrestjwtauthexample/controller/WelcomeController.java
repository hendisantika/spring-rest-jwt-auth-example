package com.hendisantika.jwt.springrestjwtauthexample.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-rest-jwt-auth-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-07
 * Time: 03:54
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping(value = "/api")
public class WelcomeController {

    @Secured("ROLE_ADMIN")
    @RequestMapping(path = "/admin/hello", method = RequestMethod.GET)
    public String helloAdminController() {
        String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();

        return "Hello Admin " + loggedUserName;
    }


    @Secured("ROLE_USER")
    @RequestMapping(path = "/user/hello", method = RequestMethod.GET)
    public String helloUserController() {

        String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();

        return "Hello User " + loggedUserName;
    }
}