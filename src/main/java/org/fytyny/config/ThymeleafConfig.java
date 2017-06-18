package org.fytyny.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan("org.fytyny")
public class ThymeleafConfig extends WebMvcConfigurerAdapter {
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    @Bean
    public ServletContextTemplateResolver servletContextTemplateResolver(){
        ServletContextTemplateResolver servletContextTemplateResolver = new ServletContextTemplateResolver();
        servletContextTemplateResolver.setCharacterEncoding("UTF-8");
        servletContextTemplateResolver.setPrefix("/templates/");
        servletContextTemplateResolver.setSuffix(".html");
        servletContextTemplateResolver.setTemplateMode("HTML5");
        return servletContextTemplateResolver;
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

    @Bean
    public SpringSecurityDialect springSecurityDialect(){
        return new SpringSecurityDialect();
    }
}
