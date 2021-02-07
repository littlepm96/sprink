package com.example.sprink.api;

import com.example.sprink.domain.Utente;


import java.util.Date;

public class UtenteResponse {
    private String username;
    private String password;
    private String chiaverecupero;
    private String nome;
    private String cognome;



    public UtenteResponse() {
    }

    public UtenteResponse(Utente utente) {
        this.username = utente.getUsername();
        this.password = utente.getPassword();
        this.chiaverecupero = utente.getChiaverecupero();
        this.nome = utente.getNome();
        this.cognome = utente.getCognome();

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

    public String getChiaverecupero() {
        return chiaverecupero;
    }

    public void setChiaverecupero(String chiaverecupero) {
        this.chiaverecupero = chiaverecupero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }


}
