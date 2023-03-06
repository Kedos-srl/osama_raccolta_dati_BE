package it.grupposcai.osamard.service.impl;

import it.grupposcai.osamard.bean.Fornitore;
import it.grupposcai.osamard.bean.FornitoreSubcategoria;
import it.grupposcai.osamard.bean.NameId;
import it.grupposcai.osamard.dao.*;
import it.grupposcai.osamard.rest.response.FornitoreSubcategoriaResponse;
import it.grupposcai.osamard.rest.response.ItemFormResponse;
import it.grupposcai.osamard.rest.response.NameIdResponse;
import it.grupposcai.osamard.service.FornitoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fornitoreService")
public class FornitoreServiceImpl implements FornitoreService {


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


    @Override
    public Fornitore insert(Fornitore fornitore) {
        return null;
    }

    @Override
    public Fornitore update(Fornitore fornitore) {
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
