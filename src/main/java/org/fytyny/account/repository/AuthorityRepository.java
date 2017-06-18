package org.fytyny.account.repository;

import org.fytyny.account.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    public Authority findByName(String name);
}
