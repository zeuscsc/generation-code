package com.zeuschiu.generation.server.security;

import java.io.Serializable;

public class JwtResponse implements Serializable {
    private String token;
    public JwtResponse(String token) {
        this.token=token;
    }

    public String getToken() {
        return token;
    }
}
