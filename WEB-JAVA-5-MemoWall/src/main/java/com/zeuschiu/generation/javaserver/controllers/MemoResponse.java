package com.zeuschiu.generation.javaserver.controllers;

import java.io.Serializable;

public class MemoResponse implements Serializable {
    Boolean success;
    public MemoResponse(Boolean success){
        this.success=success;
    }
}