package com.upc.onlinejudge.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.servlet.Filter;
/**
 * @author wangchunfei
 */
@Configuration
public class AdminFilterRegisterBean {
    @Bean
    public FilterRegistrationBean<Filter> adminFilter() {
        FilterRegistrationBean<Filter> myFilter = new FilterRegistrationBean<>();
        myFilter.setFilter(getFilter());
        myFilter.addUrlPatterns("/admin/*");
        myFilter.setOrder(1);
        return myFilter;
    }
    @Bean
    Filter getFilter() {
        return new AdminFilter();
    }
}
