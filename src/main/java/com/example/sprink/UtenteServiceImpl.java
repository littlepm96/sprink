package com.example.sprink;

import com.example.sprink.domain.Utente;
import com.example.sprink.services.UtenteService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UtenteServiceImpl implements UtenteService {

@Qualifier("getEncoder")
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public Utente findUtenteByUsername(String username) throws BusinessException {
        return utenteRepository.findByUsername(username);
    }

    @Override
    public List<Utente> findAllUtenti() throws BusinessException {
        return utenteRepository.findAll(JpaSort.unsafe(Sort.Direction.DESC, "username"));
    }

    @Override
    public void createUtente(Utente utente) throws BusinessException {
        utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        utenteRepository.save(utente);
    }
}
