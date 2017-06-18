package org.fytyny.account.sevices;

import org.fytyny.account.model.Authority;
import org.fytyny.account.model.User;
import org.fytyny.account.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MyUserDetailService implements UserDetailsService {

    @Resource
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByLogin(username);
        if (user == null) throw new UsernameNotFoundException("Couldn't find user with login: " + username);
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), true, true, true, true, getAuthorites(user.getAuthorities()));
    }

    private List<GrantedAuthority> getAuthorites(List<Authority> authorities){
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities){
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }
}

