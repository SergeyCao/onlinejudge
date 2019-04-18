package com.upc.onlinejudge.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RegisterBean {
    @Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> myFilter() {
        FilterRegistrationBean<JwtAuthenticationFilter> myFilter = new FilterRegistrationBean<>();
        myFilter.addUrlPatterns("/filter_api/*");
        myFilter.setOrder(0);
        myFilter.setFilter(new JwtAuthenticationFilter());
        return myFilter;
    }
}
