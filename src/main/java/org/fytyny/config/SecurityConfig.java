package org.fytyny.config;

import org.fytyny.account.sevices.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailService userDetailsService;

    @Override
    protected  void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/user/**").fullyAuthenticated().and().
                formLogin().and().authorizeRequests().
                antMatchers("/webjars/**").permitAll().and().authorizeRequests().
                antMatchers("/").permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
