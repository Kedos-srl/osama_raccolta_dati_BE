package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.Utente;
import it.grupposcai.osamard.rest.request.UtenteRequest;
import it.grupposcai.osamard.rest.response.UtenteResponse;

public interface UtenteService {

    public UtenteResponse login(UtenteRequest utente);

    public Utente getById(Long id_utente);

    public Utente getByEmail(String email);

}

