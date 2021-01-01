package com.example.sprink;

import it.univaq.adm.goodlife.business.repositories.InformazioniFisicheUtenteRepository;
import it.univaq.adm.goodlife.business.repositories.UtenteRepository;
import it.univaq.adm.goodlife.common.Utility;
import it.univaq.adm.goodlife.domain.Dieta;
import it.univaq.adm.goodlife.domain.InformazioniFisicheUtente;
import it.univaq.adm.goodlife.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UtenteService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UtenteRepository utenteRepository;

    public Utente getUtente() {
        return Utility.getUtente();
    }

    public void storeUtente(Utente utente) {
        String encodePassword = passwordEncoder.encode(utente.getPassword());
        utente.setPassword(encodePassword);

        utenteRepository.save(utente);
    }

    public Utente updateProfilo(Utente utente) {


        return utenteRepository.save(utente);
    }




}
