package com.example.sprink;

import it.univaq.adm.goodlife.domain.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

    Utente findByEmail(String email);
}
