package com.example.sprink.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_UTENTE", nullable = false)
    private Long IDutente;

    @Column(name = "USERNAME", nullable = false, length = 16, updatable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "CHIAVERECUPERO", nullable = false, length = 6, updatable = false)
    private String chiaverecupero;

    @Column(name = "NOME", nullable = false, length = 255)
    private String nome;

    @Column(name = "COGNOME", nullable = false, length = 255)
    private String cognome;


    public Utente(String username, String password, String chiaverecupero, String nome, String cognome) {
        this.username = username;
        this.password = password;
        this.chiaverecupero = chiaverecupero;
        this.nome = nome;
        this.cognome = cognome;
    }


    public Utente() {

    }

    public Long getIDutente() {
        return IDutente;
    }

    public void setIDutente(Long IDutente) {
        this.IDutente = IDutente;
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
