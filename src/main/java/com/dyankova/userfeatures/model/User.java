package com.dyankova.userfeatures.model;


import javax.persistence.*;

/**
 * Created by dilyanayankova on 12/8/17.
 */

@Entity
@Table(name = "USERS")
public class User {
    private long id;
    private String username;
    private String email;

    public User(long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}


