package org.fytyny.config;

import org.fytyny.account.model.User;
import org.fytyny.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfig {
    @Bean
    AuditorAware<User> auditorAware(){
        return new AuditorAwareImpl();
    }
}

class AuditorAwareImpl implements AuditorAware<User> {
    @Autowired
    UserRepository userRepository;
    @Override
    public User getCurrentAuditor() {
        return userRepository.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}