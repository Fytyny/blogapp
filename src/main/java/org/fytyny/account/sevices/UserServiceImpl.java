package org.fytyny.account.sevices;

import org.fytyny.account.forms.dto.UserRegistrationDto;
import org.fytyny.account.model.Address;
import org.fytyny.account.model.User;
import org.fytyny.account.repository.AddressRepository;
import org.fytyny.account.repository.AuthorityRepository;
import org.fytyny.account.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserRepository userRepository;
    @Resource
    AddressRepository addressRepository;
    @Resource
    AuthorityRepository authorityRepository;
    @Override
    public User registerNew(UserRegistrationDto userRegistrationDto) throws UsernameExistsException, EmailExistsException {
        if (!isEmailDuplicate(userRegistrationDto.getEmail())) throw new EmailExistsException("There is already user with this email in database");
        if (!isUsernameDuplicate(userRegistrationDto.getLogin())) throw new UsernameExistsException("There is already user with this login in database");
        User user = new User(userRegistrationDto.getLogin(), userRegistrationDto.getPassword());
        Address address = new Address(userRegistrationDto.getEmail(), user);
        user.setAddress(address);
        user.setAuthorities(Arrays.asList(authorityRepository.findByName("ROLE_USER")));
        return userRepository.save(user);
    }

    private boolean isUsernameDuplicate(String username){
        User test = userRepository.getUserByLogin(username);
        return test == null;
    }

    private boolean isEmailDuplicate(String email){
        Address test = addressRepository.getAddressByEmail(email);
        return test == null;
    }
}
