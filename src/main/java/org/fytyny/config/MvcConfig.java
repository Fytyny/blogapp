package org.fytyny.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*
        Way to add a view without Controller class
        registry.addViewController("/hello").setViewName("hello");
        */

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }

}
