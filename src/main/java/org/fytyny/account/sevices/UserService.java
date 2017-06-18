package org.fytyny.account.sevices;

import org.fytyny.account.forms.dto.UserRegistrationDto;
import org.fytyny.account.model.User;

public interface UserService {
    public User registerNew(UserRegistrationDto userRegistrationDto) throws UsernameExistsException, EmailExistsException;

}
