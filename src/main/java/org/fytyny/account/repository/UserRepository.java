package org.fytyny.account.repository;

import org.fytyny.account.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User getUserByLoginAndPassword(String login, String password);
    public User getUserByLogin(String login);
}
