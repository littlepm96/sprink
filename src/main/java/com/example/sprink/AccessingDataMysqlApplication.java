package com.example.sprink;

import com.example.sprink.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AccessingDataMysqlApplication {
    @Bean
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private PasswordEncoder passwordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(AccessingDataMysqlApplication.class, args);
    }
    @Bean
    public CommandLineRunner loadData(UtenteRepository utenteRepository) {
        return (args) -> {


/*

    Utente piri = new Utente();
            piri.setUsername("piri");
            piri.setPassword(passwordEncoder.encode("piri"));
           piri.setChiaverecupero("piri");
           piri.setNome("piri");
           piri.setCognome("piri");

           piri.setDatanascita(java.sql.Date.valueOf("1968-01-01"));
           utenteRepository.save(piri);

*/

};
}}
