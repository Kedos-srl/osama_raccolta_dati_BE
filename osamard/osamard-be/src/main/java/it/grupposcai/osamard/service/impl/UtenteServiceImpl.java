package it.grupposcai.osamard.service.impl;

import it.grupposcai.osamard.bean.Utente;
import it.grupposcai.osamard.dao.UtenteDao;
import it.grupposcai.osamard.rest.request.UtenteRequest;
import it.grupposcai.osamard.rest.response.UtenteResponse;
import it.grupposcai.osamard.service.UtenteService;
import it.grupposcai.osamard.util.PasswordCriptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("utenteService")
public class UtenteServiceImpl implements UtenteService {

    @Autowired
    UtenteDao utenteDao;


    public Utente login(Utente utente) {
        return utenteDao.login(utente);
    }

    @Override
    public UtenteResponse login(UtenteRequest utenteRequest) {
        Utente utente = new Utente();
        utenteRequestToUtente(utenteRequest, utente);
        utente = utenteDao.login(utente);

        if (utente == null) {
            return null;
        }

        UtenteResponse utenteResponse = new UtenteResponse();
        utenteToUtenteResponse(utente, utenteResponse);
        return utenteResponse;
    }


    public Utente getById(Long id_utente) {
        return utenteDao.getById(id_utente);
    }

    public Utente getByEmail(String email) {

        return utenteDao.getByEmail(email);
    }


    private void utenteRequestToUtente(UtenteRequest request, Utente utente) {

        if (request.getId() != null) {
            utente.setId(request.getId());
        }
        if (request.getNome() != null && !request.getNome().equals("")) {
            utente.setNome(request.getNome());
        }
        if (request.getCognome() != null && !request.getCognome().equals("")) {
            utente.setCognome(request.getCognome());
        }
        if (request.getEmail() != null && !request.getEmail().equals("")) {
            utente.setEmail(request.getEmail());
        }
        if (request.getPassword() != null && !request.getPassword().equals("")) {
            utente.setPassword(PasswordCriptUtils.cripta(request.getPassword()));
        }
        if (request.getDisabled() != null)
            utente.setDisabled(request.getDisabled());

        utente.setFirst_user(request.getFirstUser());
        utente.setLast_user_modified(request.getLastUserModified());

    }

    private void utenteToUtenteResponse(Utente utente, UtenteResponse utenteResponse) {
        utenteResponse.setId(utente.getId());
        utenteResponse.setNome(utente.getNome());
        utenteResponse.setCognome(utente.getCognome());
        utenteResponse.setPassword("");
        utenteResponse.setEmail(utente.getEmail());
        utenteResponse.setDisabled(utente.isDisabled());

    }


}