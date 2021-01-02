package com.example.sprink.services;

import com.example.sprink.BusinessException;
import com.example.sprink.domain.Utente;

import java.util.List;

public interface UtenteService {

    Utente findUtenteByUsername(String username) throws BusinessException;

    List<Utente> findAllUtenti() throws BusinessException;

    void createUtente(Utente utente) throws BusinessException;
}
