package com.example.sprink;

import com.example.sprink.domain.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

    Utente findByUsername(String username);

}
