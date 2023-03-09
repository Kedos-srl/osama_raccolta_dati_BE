package it.grupposcai.osamard.service.impl;

import it.grupposcai.osamard.bean.FornitoreGeolocalizzazione;
import it.grupposcai.osamard.dao.FornitoreGeolocalizzazioneDao;
import it.grupposcai.osamard.rest.request.FornitoreGeolocalizzazioneRequest;
import it.grupposcai.osamard.rest.response.FornitoreGeolocalizzazioneResponse;
import it.grupposcai.osamard.service.FornitoreGeolocalizzazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fornitoreGeolocalizzazioneService")
public class FornitoreGeolocalizzazioneServiceImpl implements FornitoreGeolocalizzazioneService {


    @Autowired
    FornitoreGeolocalizzazioneDao fornitoreGeolocalizzazioneDao;

    @Override
    public FornitoreGeolocalizzazione selectById(Long idCategoria) {
        return fornitoreGeolocalizzazioneDao.getGeolocalizzazioneById(idCategoria);
    }

    @Override
    public FornitoreGeolocalizzazione selectByIdFornitore(Long idFornitore) {
        return fornitoreGeolocalizzazioneDao.getGeolocalizzazioneByIdFornitore(idFornitore);
    }

    @Override
    public FornitoreGeolocalizzazione insert(FornitoreGeolocalizzazioneRequest request) {
        FornitoreGeolocalizzazione fornitoreGeolocalizzazione = fornitoreGeolocalizzazioneRequestToFornitoreGeolocalizzazione(request);
        fornitoreGeolocalizzazioneDao.insert(fornitoreGeolocalizzazione);
        return fornitoreGeolocalizzazione;
    }

    private FornitoreGeolocalizzazione fornitoreGeolocalizzazioneRequestToFornitoreGeolocalizzazione(FornitoreGeolocalizzazioneRequest request) {
        FornitoreGeolocalizzazione fornitoreGeolocalizzazione = new FornitoreGeolocalizzazione();
        fornitoreGeolocalizzazione.setId(request.getId());
        fornitoreGeolocalizzazione.setId_fornitore(request.getIdFornitore());
        fornitoreGeolocalizzazione.setArea(request.getArea());
        fornitoreGeolocalizzazione.setCitta(request.getCitta());

        fornitoreGeolocalizzazione.setDisabled(request.getDisabled());
        fornitoreGeolocalizzazione.setDt_inserimento(request.getDtInserimento());
        fornitoreGeolocalizzazione.setDt_modifica(request.getDtModifica());
        fornitoreGeolocalizzazione.setFirst_user(request.getFirstUser());
        fornitoreGeolocalizzazione.setLast_user_modified(request.getLastUserModified());
        return fornitoreGeolocalizzazione;
    }

    @Override
    public FornitoreGeolocalizzazioneResponse getFornitoreGeolocalizzazioneResponseById(Long idFornitoreGeolocalizzazione) {
        FornitoreGeolocalizzazione fornitoreGeolocalizzazione = selectById(idFornitoreGeolocalizzazione);
        return fornitoreGeolocalizzazioneToFornitoreGeolocalizzazioneResponse(fornitoreGeolocalizzazione);
    }

    @Override
    public FornitoreGeolocalizzazioneResponse getFornitoreGeolocalizzazioneResponseByIdFornitore(Long idFornitore) {
        FornitoreGeolocalizzazione fornitoreGeolocalizzazione = selectByIdFornitore(idFornitore);
        return fornitoreGeolocalizzazioneToFornitoreGeolocalizzazioneResponse(fornitoreGeolocalizzazione);
    }

    private FornitoreGeolocalizzazioneResponse fornitoreGeolocalizzazioneToFornitoreGeolocalizzazioneResponse(FornitoreGeolocalizzazione fornitoreGeolocalizzazione) {
        if (fornitoreGeolocalizzazione == null) {
            return new FornitoreGeolocalizzazioneResponse();
        }
        FornitoreGeolocalizzazioneResponse resp = new FornitoreGeolocalizzazioneResponse();
        resp.setId(fornitoreGeolocalizzazione.getId());
        resp.setIdFornitore(fornitoreGeolocalizzazione.getId_fornitore());
        resp.setArea(fornitoreGeolocalizzazione.getArea());
        resp.setCitta(fornitoreGeolocalizzazione.getCitta());

        resp.setDisabled(fornitoreGeolocalizzazione.isDisabled());
        resp.setDtInserimento(fornitoreGeolocalizzazione.getDt_inserimento());
        resp.setDtModifica(fornitoreGeolocalizzazione.getDt_modifica());
        resp.setLastUserModified(fornitoreGeolocalizzazione.getLast_user_modified());
        resp.setFirstUser(fornitoreGeolocalizzazione.getFirst_user());
        return resp;
    }
}
