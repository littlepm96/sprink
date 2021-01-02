package com.example.sprink.common.security;

import com.example.sprink.domain.Utente;
import com.example.sprink.services.UtenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UtenteService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utente utente = service.findUtenteByUsername(username);
        if (utente == null) {
            throw new UsernameNotFoundException("utente inesistente");
        }
        return new UserDetailsImpl(utente);

    }

}
