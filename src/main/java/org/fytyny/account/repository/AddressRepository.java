package org.fytyny.account.repository;

import org.fytyny.account.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    public Address getAddressByEmail(String email);
}
