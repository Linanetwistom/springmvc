package com.store.webstore.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request,HttpServletResponse respanse, Object handler ) throws Exception{
        Object obj=request.getSession().getAttribute("uid");
        if(obj==null){
            respanse.sendRedirect("/webstore/src/main/resources/static/web/login.html");
            return false;
        }
        return true;
    }
    
}
