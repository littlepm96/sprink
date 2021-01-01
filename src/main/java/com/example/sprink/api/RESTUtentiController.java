package com.example.sprink.api;

import it.univaq.adm.goodlife.api.request.AuthenticationRequest;
import it.univaq.adm.goodlife.business.UtenteService;
import it.univaq.adm.goodlife.common.security.JWTTokenUtil;
import it.univaq.adm.goodlife.common.security.UserDetailsImpl;
import it.univaq.adm.goodlife.domain.InformazioniFisicheUtente;
import it.univaq.adm.goodlife.domain.Utente;
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
@RequestMapping("/api")
public class RESTUtentiController {

    @Autowired
    UtenteService utenteService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Value("${jwt.token.header}")
    private String tokenHeader;

    @PostMapping("/login")
    public Utente login(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws AuthenticationException {
        // Effettuo l'autenticazione
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Genero Token e lo inserisco nell'header di risposta
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtTokenUtil.generateToken(userDetails);
        response.setHeader(tokenHeader, token);

        // Ritorno l'utente
        return ((UserDetailsImpl) userDetails).getUtente();
    }

    @PostMapping("utente/updateprofilo")
    public Utente updateProfilo(@RequestBody Utente utente) {
        return utenteService.updateProfilo(utente);
    }

    @PostMapping("/signup")
    public void signup(@RequestBody Utente utente) {
        utenteService.storeUtente(utente);
    }

    @GetMapping("/utente/account")
    public Utente getAccountUtente() {
        return utenteService.getUtente();
    }

    @GetMapping("/utente/informazioni")
    public List<InformazioniFisicheUtente> getInformazioniUtente() {
        return utenteService.getInformazioniFisiche();
    }

    @PostMapping("/utente/informazioni")
    public InformazioniFisicheUtente updateInformazioniUtente(@RequestBody InformazioniFisicheUtente informazioniFisicheUtente) {
        return utenteService.updateInformazioniFisiche(informazioniFisicheUtente);
    }
}
