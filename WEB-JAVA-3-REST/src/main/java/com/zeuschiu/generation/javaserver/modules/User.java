package com.zeuschiu.generation.javaserver.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;

    public User(){}
    public User(String name,String password){}

    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
}
