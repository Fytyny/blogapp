package org.fytyny.account.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.fytyny.entitytemplates.AbstractEntity;

import javax.persistence.*;

@Entity
public class Address extends AbstractEntity {
    @Column(unique = true, nullable = false, columnDefinition = "VARCHAR(50)")
    private String email;
    @Column(columnDefinition = "VARCHAR(30)")
    private String firstName;
    @Column(columnDefinition = "VARCHAR(50)")
    private String lastName;
    @Column(columnDefinition = "VARCHAR(160)")
    private String city;

    @JsonIgnore
    @MapsId
    @OneToOne(mappedBy = "address")
    @JoinColumn(name = "user_id")
    private User user;

    public Address(){}
    public Address(String email,User onetone){
        this.setEmail(email);
        this.setUser(onetone);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
