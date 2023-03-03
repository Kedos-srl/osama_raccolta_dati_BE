package it.grupposcai.osamard.service.impl;

import it.grupposcai.osamard.bean.Fornitore;
import it.grupposcai.osamard.dao.*;
import it.grupposcai.osamard.rest.response.ItemFormResponse;
import it.grupposcai.osamard.service.FornitoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        response.setMateriale(materialeDao.getAll());
        response.setDimensioni(dimensioniDao.getAll());
        response.setMoq(moqDao.getAll());
        response.setCampioni(campioniDao.getAll());
        response.setProduzione(produzioneDao.getAll());
        response.setTrading(tradingDao.getAll());
        response.setCertificazioni(certificazioniFabbricaDao.getAll());
        response.setFornitoreCategoria(fornitoreCategoriaDao.getAll());
        response.setFornitoreSubcategoria(fornitoreSubcategoriaDao.getAll());
        response.setCertificazioniMateriali(certificazioniMaterialiDao.getAll());

        return response;
    }


}
