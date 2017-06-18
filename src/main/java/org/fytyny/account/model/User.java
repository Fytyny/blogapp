package org.fytyny.account.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.fytyny.blog.model.Post;
import org.fytyny.entitytemplates.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class User extends AbstractEntity {
    @Column(unique = true, nullable = false, columnDefinition = "VARCHAR(20)")
    private String login;
    @NotNull
    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author" )
    private List<Post> posts;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_authorities", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;
    public User(){

    }
    public User(String login, String password){
        this.setLogin(login);
        this.setPassword(password);
    }
    @JsonIgnore
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
