package com.zeuschiu.generation.javaserver.modules;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name="memos")
public class Memo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String content;

    protected Memo(){}
    public Memo(String content){
        this.content=content;
    }
    public Long getId(){
        return id;
    }
    public String getContent(){
        return content;
    }
}
