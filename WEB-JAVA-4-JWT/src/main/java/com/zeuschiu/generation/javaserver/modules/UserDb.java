package com.zeuschiu.generation.javaserver.modules;

import javax.persistence.*;

@Entity
@Table(name="users")
public class UserDb {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UserDb(){}
    public UserDb(String username, String password){}

}
