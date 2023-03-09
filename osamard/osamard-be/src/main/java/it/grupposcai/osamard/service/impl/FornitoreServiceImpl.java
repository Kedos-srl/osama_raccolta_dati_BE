package it.grupposcai.osamard.service.impl;

import it.grupposcai.osamard.bean.*;
import it.grupposcai.osamard.dao.*;
import it.grupposcai.osamard.rest.request.FornitoreRequest;
import it.grupposcai.osamard.rest.response.FornitoreResponse;
import it.grupposcai.osamard.rest.response.FornitoreSubcategoriaResponse;
import it.grupposcai.osamard.rest.response.ItemFormResponse;
import it.grupposcai.osamard.rest.response.NameIdResponse;
import it.grupposcai.osamard.service.*;
import it.grupposcai.osamard.util.Const;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service("fornitoreService")
public class FornitoreServiceImpl implements FornitoreService {

    Logger logger = Logger.getLogger(FornitoreService.class);

    @Autowired
    FornitoreDao fornitoreDao;
    @Autowired
    CampioniDao campioniDao;
    @Autowired
    ProduzioneDao produzioneDao;
    @Autowired
    MoqService moqService;
    @Autowired
    DimensioniService dimensioniService;
    @Autowired
    MaterialeService materialeService;
    @Autowired
    FornitoreCategoriaService fornitoreCategoriaService;
    @Autowired
    FornitoreSubcategoriaService fornitoreSubcategoriaService;
    @Autowired
    ContattoService contattoService;
    @Autowired
    TradingService tradingService;
    @Autowired
    ProdottoService prodottoService;
    @Autowired
    FotoService fotoService;
    @Autowired
    FornitoreGeolocalizzazioneService fornitoreGeolocalizzazioneService;
    @Autowired
    CertificazioniFabbricaService certificazioniFabbricaService;
    @Autowired
    CertificazioniMaterialiService certificazioniMaterialiService;


    private Fornitore insert(FornitoreRequest request) {

        // Salvo il contatto
        if (request.getContatto() != null) {
            request.getContatto().setDisabled(false);
            request.getContatto().setDtInserimento(LocalDateTime.now());
            request.getContatto().setDtModifica(LocalDateTime.now());
            request.getContatto().setFirstUser(request.getFirstUser());
            request.getContatto().setLastUserModified(request.getLastUserModified());
        }
        Contatto contatto = contattoService.save(request.getContatto());

        Fornitore fornitore = new Fornitore();
        fornitore.setRagione_sociale(request.getRagioneSociale());
        fornitore.setTempo_mercato(request.getTempoMercato());
        fornitore.setFat_tot(request.getFatTot());
        fornitore.setFat_it(request.getFatIt());
        fornitore.setNumero_dipendenti(request.getNumeroDipendenti());
        fornitore.setRd_interno(request.getRdInterno());
        fornitore.setId_contatto(contatto.getId());

        Trading trading = tradingService.selectById(request.getIdTrading());
        if (trading != null) {
            fornitore.setId_trading(trading.getId());
        }

        fornitore.setDisabled(request.getDisabled() == null ? false : request.getDisabled());
        fornitore.setDt_inserimento(LocalDateTime.now());
        fornitore.setDt_modifica(LocalDateTime.now());
        fornitore.setLast_user_modified(request.getLastUserModified());
        fornitore.setFirst_user(request.getFirstUser());

        fornitoreDao.insert(fornitore);

        // Salvo le categorie
        if (request.getFornitoreCategoria() != null && !request.getFornitoreCategoria().isEmpty()) {
            request.getFornitoreCategoria().forEach(categoria -> {
                if (categoria.getIdCategoria() == null) {
                    return;
                }
                FornitoreCategoria fornitoreCategoria = fornitoreCategoriaService.selectById(categoria.getIdCategoria());
                if (fornitoreCategoria == null) {
                    return;
                }

                FornitoreCategoriaSubcategoria fornitoreCategoriaSubcategoria = new FornitoreCategoriaSubcategoria();
                fornitoreCategoriaSubcategoria.setId_categoria(fornitoreCategoria.getId());
                fornitoreCategoriaSubcategoria.setId_fornitore(fornitore.getId());

                if (categoria.getIdSubcategoriaList() != null && !categoria.getIdSubcategoriaList().isEmpty()) {
                    categoria.getIdSubcategoriaList().forEach(idSubcategoria -> {
                        FornitoreSubcategoria fornitoreSubcategoria = fornitoreSubcategoriaService.selectById(idSubcategoria);
                        if (fornitoreSubcategoria != null) {
                            FornitoreCategoriaSubcategoria fornitoreCategoriaSubcategoria2 = new FornitoreCategoriaSubcategoria();
                            fornitoreCategoriaSubcategoria2.setId_fornitore(fornitore.getId());
                            fornitoreCategoriaSubcategoria2.setId_categoria(fornitoreCategoria.getId());
                            fornitoreCategoriaSubcategoria2.setId_subcategoria(fornitoreSubcategoria.getId());
                            fornitoreDao.insertFornitoreCategoriaSubcategoria(fornitoreCategoriaSubcategoria2);
                        }
                    });
                    return;
                }
                fornitoreDao.insertFornitoreCategoriaSubcategoria(fornitoreCategoriaSubcategoria);
            });
        }

        // Salvo le certificazioni
        if (request.getIdCertificatiFabbricaList() != null && !request.getIdCertificatiFabbricaList().isEmpty()) {
            request.getIdCertificatiFabbricaList().forEach(idCertificazione -> {
                if (idCertificazione == null){
                    return;
                }
                CertificazioniFabbrica certificazioniFabbrica =  certificazioniFabbricaService.selectById(idCertificazione);
                if (certificazioniFabbrica != null) {
                    FornitoreCertificazione fornitoreCertificazione = new FornitoreCertificazione();
                    fornitoreCertificazione.setId_fornitore(fornitore.getId());
                    fornitoreCertificazione.setId_certificazione(certificazioniFabbrica.getId());
                    certificazioniFabbricaService.insertCertificazioniFabbrica(fornitoreCertificazione);
                }
            });
        }

        if (request.getIdCertificatiMaterialiList() != null && !request.getIdCertificatiMaterialiList().isEmpty()) {
            request.getIdCertificatiMaterialiList().forEach(idCertificazione -> {
                if (idCertificazione == null){
                    return;
                }
                CertificazioniMateriali certificazioniMateriali =  certificazioniMaterialiService.selectById(idCertificazione);
                if (certificazioniMateriali != null) {
                    FornitoreCertificazione fornitoreCertificazione = new FornitoreCertificazione();
                    fornitoreCertificazione.setId_fornitore(fornitore.getId());
                    fornitoreCertificazione.setId_certificazione(certificazioniMateriali.getId());
                    certificazioniMaterialiService.insertCertificazioniMateriali(fornitoreCertificazione);
                }
            });
        }

        if (request.getProdottoList() != null && !request.getProdottoList().isEmpty()) {
            request.getProdottoList().forEach(prodottoRequest -> {
                prodottoRequest.setIdFornitore(fornitore.getId());
                prodottoRequest.setDisabled(request.getDisabled() == null ? false : request.getDisabled());
                prodottoRequest.setDtInserimento(LocalDateTime.now());
                prodottoRequest.setDtModifica(LocalDateTime.now());
                prodottoRequest.setFirstUser(request.getFirstUser());
                prodottoRequest.setLastUserModified(request.getLastUserModified());
                prodottoService.insert(prodottoRequest);
            });
        }

        // Salvo le foto
        if (request.getFotoList() != null && !request.getFotoList().isEmpty()) {
            request.getFotoList().forEach(fotoRequest -> {
                fotoRequest.setIdOggetto(fornitore.getId());
                fotoRequest.setIdTipoOggetto(Const.Oggetto.FORNITORE);
                fotoRequest.setDisabled(request.getDisabled() == null ? false : request.getDisabled());
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

        // forniotre geolocalizzazione

        if (request.getFornitoreGeolocalizzazione() != null) {
            request.getFornitoreGeolocalizzazione().setIdFornitore(fornitore.getId());
            request.getFornitoreGeolocalizzazione().setDisabled(request.getDisabled() == null ? false : request.getDisabled());
            request.getFornitoreGeolocalizzazione().setDtInserimento(LocalDateTime.now());
            request.getFornitoreGeolocalizzazione().setDtModifica(LocalDateTime.now());
            request.getFornitoreGeolocalizzazione().setFirstUser(request.getFirstUser());
            request.getFornitoreGeolocalizzazione().setLastUserModified(request.getLastUserModified());
            fornitoreGeolocalizzazioneService.insert(request.getFornitoreGeolocalizzazione());
        }

        return fornitore;
    }

    private Fornitore update(FornitoreRequest fornitore) {
        // TODO ZAMMA implementare metodo
        return null;
    }

    @Override
    public List<Fornitore> selectAll() {
        return null;
    }

    @Override
    public List<Fornitore> selectAllEnabled() {
        return null;
    }

    @Override
    public Fornitore selectById(Fornitore fornitore) {
        return null;
    }

    @Override
    public ItemFormResponse getItemsForm() {
        ItemFormResponse response = new ItemFormResponse();
        response.setMateriale(nameIdToNameIdResponse(materialeService.selectAll()));
        response.setDimensioni(nameIdToNameIdResponse(dimensioniService.selectAll()));
        response.setMoq(nameIdToNameIdResponse(moqService.selectAll()));
        response.setCampioni(nameIdToNameIdResponse(campioniDao.getAll()));
        response.setProduzione(nameIdToNameIdResponse(produzioneDao.getAll()));
        response.setTrading(nameIdToNameIdResponse(tradingService.selectAll()));
        response.setCertificazioniFabbrica(nameIdToNameIdResponse(certificazioniFabbricaService.selectAll()));
        response.setCertificazioniMateriali(nameIdToNameIdResponse(certificazioniMaterialiService.selectAll()));
        response.setFornitoreCategoria(nameIdToNameIdResponse(fornitoreCategoriaService.getAll()));
        response.setFornitoreSubcategoria(fornitoreSubcategoriaService.getAllsubcategoriaResponse());

        return response;
    }

    @Override
    @Transactional
    public FornitoreResponse save(FornitoreRequest request) {
        if (request == null) {
            return null;
        }
        Fornitore fornitore;
        if (request.getId() != null && request.getId() > 0) {
            fornitore = update(request);
        } else {
            fornitore = insert(request);
        }

        return fornitoreToFornitoreResponse(fornitore);

    }

    @Override
    public FornitoreResponse getById(FornitoreRequest request) {
        Fornitore fornitore = fornitoreDao.getById(request.getId());
        if (fornitore == null) {
            throw new RuntimeException("Fornitore non trovato");
        }
        return fornitoreToFornitoreResponse(fornitore);
    }

    private FornitoreResponse fornitoreToFornitoreResponse(Fornitore fornitore) {
        FornitoreResponse response = new FornitoreResponse();

        response.setId(fornitore.getId());
        response.setRagioneSociale(fornitore.getRagione_sociale());
        response.setTempoMercato(fornitore.getTempo_mercato());
        response.setCategoriaList(fornitoreCategoriaService.getFornitoreCategoriaResponseByCategorieAssociate(getFornitoreCategoriaByIdFornitoreGroupByIdCategoria(fornitore.getId())));
        response.setFatTot(fornitore.getFat_tot());
        response.setFatIt(fornitore.getFat_it());
        response.setNumeroDipendenti(fornitore.getNumero_dipendenti());
        response.setRdInterno(fornitore.getRd_interno());
        response.setTrading(tradingService.getTradingResponseById(fornitore.getId_trading()));
        response.setContatto(contattoService.getContattoResponseById(fornitore.getId_contatto()));
        response.setProdottoList(prodottoService.getProdottoResponseListByIdFornitore(fornitore.getId()));
        response.setFotoList(fotoService.getFotoResponseByIdOggettoAndTipoOggetto(fornitore.getId(), Const.Oggetto.FORNITORE));
        response.setFornitoreGeolocalizzazione(fornitoreGeolocalizzazioneService.getFornitoreGeolocalizzazioneResponseByIdFornitore(fornitore.getId()));
        response.setCertificazioniFabbrica(certificazioniFabbricaService.selectCertificazioneFabbricaResponseByIdFornitore(fornitore.getId()));
        response.setCertificazioniMateriali(certificazioniMaterialiService.selectCertificazioneMaterialiResponseByIdFornitore(fornitore.getId()));

        response.setFatIt(fornitore.getFat_it());

        return response;
    }

    private List<FornitoreCategoriaSubcategoria> getFornitoreCategoriaByIdFornitoreGroupByIdCategoria(Long id) {
        if (id == null){
            return null;
        }
        return fornitoreDao.getFornitoreCategoriaByIdFornitoreGroupByIdCategoria(id);
    }



    private List<NameIdResponse> nameIdToNameIdResponse(List<NameId> allList) {
        if (allList == null) {
            return null;
        }
        if (allList.isEmpty()) {
            return new ArrayList<>();
        }
        List<NameIdResponse> respList = new ArrayList<>();
        allList.forEach(nameId -> {
            NameIdResponse resp = new NameIdResponse();
            resp.setName(nameId.getNome());
            resp.setId(nameId.getId());
            resp.setDisabled(nameId.isDisabled());
            resp.setDtInserimento(nameId.getDt_inserimento());
            resp.setDtModifica(nameId.getDt_modifica());
            resp.setLastUserModified(nameId.getLast_user_modified());
            resp.setFirstUser(nameId.getFirst_user());
            respList.add(resp);
        });
        return respList;
    }

}
