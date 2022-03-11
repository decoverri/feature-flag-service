package com.infinityworks.decoverri.featureflag.interceptor;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        var userType = request.getHeader("userType");
        var method = request.getMethod();
        if((method.equals(HttpMethod.GET.name())) || (userType != null && userType.equals("admin"))){
            return true;
        }
        else {
            response.setStatus(401);
            return false;
        }
    }
}
