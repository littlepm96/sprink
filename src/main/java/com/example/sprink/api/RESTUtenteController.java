package com.example.sprink.api;

import com.example.sprink.UtenteServiceImpl;
import com.example.sprink.common.security.JWTTokenUtil;
import com.example.sprink.common.security.UserDetailsImpl;
import com.example.sprink.domain.Utente;
import com.example.sprink.services.UtenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

    @PostMapping("/login")
    public UtenteResponse login(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws AuthenticationException {
        // Effettuo l'autenticazione
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Genero Token e lo inserisco nell'header di risposta
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtTokenUtil.generateToken(userDetails);
        response.setHeader(tokenHeader, token);

        // Ritorno l'utente
        return new UtenteResponse(((UserDetailsImpl) userDetails).getUtente());
    }

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
