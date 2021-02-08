package com.example.sprink.api;

import com.example.sprink.UtenteServiceImpl;
import com.example.sprink.common.security.JWTTokenUtil;
import com.example.sprink.domain.Utente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080", "http://10.0.2.2:8080/"})
@RequestMapping("/api")
public class RESTUtenteController {

    @Value("${jwt.token.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private UtenteServiceImpl utenteService;



    @GetMapping("/utenti")
    public List<Utente> getAll() {
        return utenteService.findAllUtenti();
    }

    @PostMapping("/utenti")
    public void insert(@RequestBody Utente utente) {
        utenteService.createUtente(utente);
    }
    @PostMapping("/registration")
    public void registration(@RequestBody Utente utente) {


        utenteService.createUtente(utente);
    }
}
