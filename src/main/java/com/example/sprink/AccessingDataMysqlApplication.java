package com.example.sprink;

import com.example.sprink.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AccessingDataMysqlApplication {
    @Bean
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Qualifier("getEncoder")
    @Autowired
    private PasswordEncoder passwordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(AccessingDataMysqlApplication.class, args);
    }
    @Bean
    public CommandLineRunner loadData(UserRepository utenteRepository) {
        return (args) -> {


/*

    Utente piri = new Utente();
            piri.setUsername("piri");
            piri.setPassword(passwordEncoder.encode("piri"));
           piri.setChiaverecupero("piri");
           piri.setNome("piri");
           piri.setCognome("piri");


           utenteRepository.save(piri);

*/

};
}}
