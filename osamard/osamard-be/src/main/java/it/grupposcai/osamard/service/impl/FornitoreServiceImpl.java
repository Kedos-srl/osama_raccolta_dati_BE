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
    MaterialeDao materialeDao;
    @Autowired
    DimensioniDao dimensioniDao;
    @Autowired
    MoqDao moqDao;
    @Autowired
    CampioniDao campioniDao;
    @Autowired
    ProduzioneDao produzioneDao;
    @Autowired
    TradingDao tradingDao;
    @Autowired
    CertificazioniFabbricaDao certificazioniFabbricaDao;
    @Autowired
    FornitoreCategoriaDao fornitoreCategoriaDao;
    @Autowired
    FornitoreSubcategoriaDao fornitoreSubcategoriaDao;
    @Autowired
    CertificazioniMaterialiDao certificazioniMaterialiDao;
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

    @Transactional
    private Fornitore insert(FornitoreRequest request) {

        // Salvo il contatto
        if (request.getContatto() != null){
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
        FornitoreCategoria fornitoreCategoria = fornitoreCategoriaService.selectById(request.getIdCategoria());
        if (fornitoreCategoria != null){
            fornitore.setId_categoria(fornitoreCategoria.getId());
        }

        FornitoreSubcategoria fornitoreSubcategoria = fornitoreSubcategoriaService.selectById(request.getIdSubcategoria());
        if (fornitoreSubcategoria != null){
            fornitore.setId_subcategoria(fornitoreSubcategoria.getId());
        }

        fornitore.setFat_tot(request.getFatTot());
        fornitore.setFat_it(request.getFatIt());
        fornitore.setNumero_dipendenti(request.getNumeroDipendenti());
        fornitore.setRd_interno(request.getRdInterno());
        fornitore.setId_contatto(contatto.getId());

        Trading trading = tradingService.selectById(request.getIdTrading());
        if (trading != null){
            fornitore.setId_trading(trading.getId());
        }

        fornitore.setDisabled(request.getDisabled() == null ? false : request.getDisabled());
        fornitore.setDt_inserimento(LocalDateTime.now());
        fornitore.setDt_modifica(LocalDateTime.now());
        fornitore.setLast_user_modified(request.getLastUserModified());
        fornitore.setFirst_user(request.getFirstUser());

        //TODO SALVARE CERTIFICATI

        fornitoreDao.insert(fornitore);

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
        response.setMateriale(nameIdToNameIdResponse(materialeDao.getAll()));
        response.setDimensioni(nameIdToNameIdResponse(dimensioniDao.getAll()));
        response.setMoq(nameIdToNameIdResponse(moqDao.getAll()));
        response.setCampioni(nameIdToNameIdResponse(campioniDao.getAll()));
        response.setProduzione(nameIdToNameIdResponse(produzioneDao.getAll()));
        response.setTrading(nameIdToNameIdResponse(tradingDao.getAll()));
        response.setCertificazioniFabbrica(nameIdToNameIdResponse(certificazioniFabbricaDao.getAll()));
        response.setCertificazioniMateriali(nameIdToNameIdResponse(certificazioniMaterialiDao.getAll()));
        response.setFornitoreCategoria(nameIdToNameIdResponse(fornitoreCategoriaDao.getAll()));
        response.setFornitoreSubcategoria(subcategoriaToSubcategoriaResponse(fornitoreSubcategoriaDao.getAll()));

        return response;
    }

    @Override
    public FornitoreResponse save(FornitoreRequest request) {
        if (request == null){
            return null;
        }
        Fornitore fornitore ;
        if (request.getId() != null && request.getId() > 0){
            fornitore = update(request);
        } else {
            fornitore = insert(request);
        }

        return fornitoreToFornitoreResponse(fornitore);

    }

    private FornitoreResponse fornitoreToFornitoreResponse(Fornitore fornitore) {
        FornitoreResponse response = new FornitoreResponse();

        response.setId(fornitore.getId());
        response.setRagioneSociale(fornitore.getRagione_sociale());
        response.setTempoMercato(fornitore.getTempo_mercato());
        response.setCategoria(fornitoreCategoriaService.getCategoriaResponseById(fornitore.getId_categoria()));
        response.setSubcategoria(fornitoreSubcategoriaService.getSubcategoriaResponseById(fornitore.getId_subcategoria()));
        response.setFatTot(fornitore.getFat_tot());
        response.setFatIt(fornitore.getFat_it());
        response.setNumeroDipendenti(fornitore.getNumero_dipendenti());
        response.setRdInterno(fornitore.getRd_interno());
        response.setTrading(tradingService.getTradingResponseById(fornitore.getId_trading()));
        response.setContatto(contattoService.getContattoResponseById(fornitore.getId_contatto()));
        response.setProdottoList(prodottoService.getProdottoResponseListByIdFornitore(fornitore.getId()));
        response.setFotoList(fotoService.getFotoResponseByIdOggettoAndTipoOggetto(fornitore.getId(), Const.Oggetto.FORNITORE));

        response.setFatIt(fornitore.getFat_it());

        return response;
    }

    private List<FornitoreSubcategoriaResponse> subcategoriaToSubcategoriaResponse(List<FornitoreSubcategoria> subcategoriaList) {
        if (subcategoriaList == null){
            return null;
        }
        if (subcategoriaList.isEmpty()){
            return new ArrayList<>();
        }
        List<FornitoreSubcategoriaResponse> respList = new ArrayList<>();
        subcategoriaList.forEach(nameId -> {
            FornitoreSubcategoriaResponse resp = new FornitoreSubcategoriaResponse();
            resp.setName(nameId.getNome());
            resp.setId(nameId.getId());
            resp.setIdCategoria(nameId.getId_categoria());
            resp.setDisabled(nameId.isDisabled());
            resp.setDtInserimento(nameId.getDt_inserimento());
            resp.setDtModifica(nameId.getDt_modifica());
            resp.setLastUserModified(nameId.getLast_user_modified());
            resp.setFirstUser(nameId.getFirst_user());
            respList.add(resp);
        });
        return respList;
    }

    private List<NameIdResponse> nameIdToNameIdResponse(List<NameId> allList) {
        if (allList == null){
            return null;
        }
        if (allList.isEmpty()){
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
