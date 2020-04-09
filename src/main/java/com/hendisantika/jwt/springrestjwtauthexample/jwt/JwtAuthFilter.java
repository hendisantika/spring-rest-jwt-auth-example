package com.hendisantika.jwt.springrestjwtauthexample.jwt;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-rest-jwt-auth-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-07
 * Time: 03:49
 * To change this template use File | Settings | File Templates.
 */
@Component
public class JwtAuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String authorization = servletRequest.getHeader("Authorization");

        if (authorization != null) {
            JwtAuthToken token = new JwtAuthToken(authorization.replaceAll("Bearer ", ""));
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
