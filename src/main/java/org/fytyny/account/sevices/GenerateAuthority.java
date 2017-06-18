package org.fytyny.account.sevices;

import org.fytyny.account.model.Authority;
import org.fytyny.account.repository.AuthorityRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service
public class GenerateAuthority {
    @Resource
    AuthorityRepository authorityRepository;

    @PostConstruct
    public void generateBasicAuthoritiesIfNotExist(){
        generateAuthorityWithName("ROLE_USER");
        generateAuthorityWithName("ROLE_ADMIN");
    }
    private void generateAuthorityWithName(String name){
        Authority user = authorityRepository.findByName(name);
        if (user == null){
            user = new Authority(name);
            authorityRepository.save(user);
        }
    }
}
