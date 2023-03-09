package it.grupposcai.osamard.service.impl;

import it.grupposcai.osamard.bean.Prodotto;
import it.grupposcai.osamard.dao.ProdottoDao;
import it.grupposcai.osamard.rest.request.ProdottoRequest;
import it.grupposcai.osamard.rest.response.ProdottoResponse;
import it.grupposcai.osamard.service.*;
import it.grupposcai.osamard.util.Const;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service("prodottoService")
public class ProdottoServiceImpl implements ProdottoService {

    Logger logger = Logger.getLogger(ProdottoService.class);


    @Autowired
    ProdottoDao prodottoDao;
    @Autowired
    FotoService fotoService;
    @Autowired
    MaterialeService materialeService;
    @Autowired
    DimensioniService dimensioniService;
    @Autowired
    MoqService moqService;

    @Override
    @Transactional
    public Prodotto insert(ProdottoRequest request) {
        Prodotto prodotto = prodottoRequestToProdotto(request);
        prodottoDao.insert(prodotto);

        // Salvo le foto
        if (request.getFotoList() != null && !request.getFotoList().isEmpty()) {
            request.getFotoList().forEach(fotoRequest -> {
                fotoRequest.setIdOggetto(prodotto.getId());
                fotoRequest.setIdTipoOggetto(Const.Oggetto.PRODOTTO);

                fotoRequest.setDisabled(false);
                fotoRequest.setDtInserimento(LocalDateTime.now());
                fotoRequest.setDtModifica(LocalDateTime.now());
                fotoRequest.setFirstUser(request.getFirstUser());
                fotoRequest.setLastUserModified(request.getLastUserModified());
                try {
                    fotoService.insert(fotoRequest);
                } catch (Exception e) {
                    logger.error("insert prodotto - Errore caricamento foto", e);
                }
            });
        }
        return prodotto;
    }

    @Override
    public List<Prodotto> getProdottoByIdFornitore(Long idFornitore) {
        if (idFornitore == null) {
            return null;
        }
        return prodottoDao.getProdottoByIdFornitore(idFornitore);
    }

    @Override
    public Prodotto getProdottoById(Long id) {
        if (id == null) {
            return null;
        }
        return prodottoDao.getProdottoById(id);
    }

    @Override
    public ProdottoResponse getProdottoResponseById(Long id) {

        Prodotto prodotto = getProdottoById(id);
        if (prodotto == null){
            return null;
        }
        ProdottoResponse resp = new ProdottoResponse();
        resp.setId(prodotto.getId());
        resp.setCodArticolo(prodotto.getCod_articolo());
        resp.setMateriale(materialeService.getMaterialeResponseById(prodotto.getId_materiale()));
        resp.setDimensioni(dimensioniService.getDimensioniResponseById(prodotto.getId_dimensioni()));
        resp.setMoq(moqService.getMoqResponseById(prodotto.getId_moq()));
        resp.setIdPrezzo(prodotto.getId_prezzo());
        resp.setIdFornitore(prodotto.getId_fornitore());
        resp.setFotoList(fotoService.getFotoResponseByIdOggettoAndTipoOggetto(prodotto.getId(), Const.Oggetto.PRODOTTO));

        resp.setDisabled(prodotto.isDisabled());
        resp.setDtInserimento(prodotto.getDt_inserimento());
        resp.setDtModifica(prodotto.getDt_modifica());
        resp.setLastUserModified(prodotto.getLast_user_modified());
        resp.setFirstUser(prodotto.getFirst_user());
        return resp;
    }

    @Override
    public List<ProdottoResponse> getProdottoResponseListByIdFornitore(Long idFornitore) {
        List<Prodotto> prodottoList = getProdottoByIdFornitore(idFornitore);
        List<ProdottoResponse> responseList = new ArrayList<>();
        if (prodottoList != null && !prodottoList.isEmpty()){
            prodottoList.forEach(prodotto -> {
                responseList.add(getProdottoResponseById(prodotto.getId()));
            });
        }
        return responseList;
    }

    private Prodotto prodottoRequestToProdotto(ProdottoRequest request) {
        Prodotto prodotto = new Prodotto();
        prodotto.setCod_articolo(request.getCodArticolo());
        prodotto.setId_materiale(request.getIdMateriale());
        prodotto.setId_dimensioni(request.getIdDimensioni());
        prodotto.setId_moq(request.getIdMoq());
        prodotto.setId_prezzo(request.getIdPrezzo());
        prodotto.setId_fornitore(request.getIdFornitore());

        prodotto.setDisabled(request.getDisabled());
        prodotto.setDt_inserimento(request.getDtInserimento());
        prodotto.setDt_modifica(request.getDtModifica());
        prodotto.setFirst_user(request.getFirstUser());
        prodotto.setLast_user_modified(request.getLastUserModified());

        return prodotto;
    }

}
