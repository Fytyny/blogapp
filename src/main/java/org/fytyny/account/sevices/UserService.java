package org.fytyny.account.sevices;

import org.fytyny.account.forms.dto.UserDto;
import org.fytyny.account.model.User;

public interface UserService {
    public User registerNew(UserDto userDto) throws UsernameExistsException, EmailExistsException;

}
