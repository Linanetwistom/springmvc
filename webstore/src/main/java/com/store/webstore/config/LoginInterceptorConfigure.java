package com.store.webstore.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.store.webstore.interceptor.LoginInterceptor;

@Configuration
public class LoginInterceptorConfigure implements WebMvcConfigurer{

    HandlerInterceptor instantiator=new LoginInterceptor();

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        List<String> patterns= new ArrayList<>();
        patterns.add("/webstore/src/main/resources/static/bootstrap3/**");
        patterns.add("/webstore/src/main/resources/static/css/**");
        patterns.add("/webstore/src/main/resources/static/images/**");
        patterns.add("/webstore/src/main/resources/static/js/**");
        patterns.add("/webstore/src/main/resources/static/register.html");
        patterns.add("/webstore/src/main/resources/static/login.html");
        patterns.add("/webstore/src/main/resources/static/index.html");
        patterns.add("/webstore/src/main/resources/static/product.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/districts/**");
        patterns.add("/products/**");

        registry.addInterceptor(instantiator).addPathPatterns("/webstore/**").excludePathPatterns(patterns);
    }
}
