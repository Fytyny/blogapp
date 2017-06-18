package org.fytyny.account.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.fytyny.entitytemplates.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Authority extends AbstractEntity{
    @Column(length = 60, unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "authorities")
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Authority(){
    }

    public Authority(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
