package com.infinityworks.decoverri.featureflag.configuration;

import com.infinityworks.decoverri.featureflag.interceptor.AdminCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringInterceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminCheckInterceptor());
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
