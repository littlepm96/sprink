package com.example.sprink.api;

import com.example.sprink.domain.Utente;


import java.util.Date;

public class UtenteResponse {


        private String token;
        private String message;


    public UtenteResponse(String token, String message) {
        this.token = token;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

