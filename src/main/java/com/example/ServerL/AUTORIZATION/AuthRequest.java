package com.example.ServerL.AUTORIZATION;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;


public class AuthRequest {
    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    public AuthRequest() {

    }

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
}
