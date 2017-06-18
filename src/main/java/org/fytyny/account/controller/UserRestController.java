package org.fytyny.account.controller;

import org.fytyny.account.model.Address;
import org.fytyny.account.model.User;
import org.fytyny.account.repository.AuthorityRepository;
import org.fytyny.account.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @Resource
    UserRepository userRepository;
    @Resource
    AuthorityRepository authorityRepository;
    @RequestMapping("/getTestUser")
    public List<User> getUsers(){
        List<User> result = new ArrayList<>();
        User user = new User("login", "pass");
        Address address = new Address("dasd@dasd.com",user);
        user.setAddress(address);
        user.setAuthorities(Arrays.asList(authorityRepository.findByName("ROLE_USER")));
        userRepository.save(user);

        result.add(userRepository.getUserByLoginAndPassword("login","pass"));
        return result;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<User> allUsers(){
        return userRepository.findAll();
    }


}
