package com.nationwide.dto;

import com.nationwide.persistance.domain.Token;
import com.nationwide.service.TokenService;

public class ResponseTokenDTO {

    private String username;
    private String bearerToken;

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getBearerToken(){
        return bearerToken;
    }

    public void setBearerToken(String bearerToken){
        this.bearerToken = bearerToken;
    }
}
