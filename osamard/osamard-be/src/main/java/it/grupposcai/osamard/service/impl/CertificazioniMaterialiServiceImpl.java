package it.grupposcai.osamard.service.impl;

import it.grupposcai.osamard.bean.CertificazioniMateriali;
import it.grupposcai.osamard.bean.FornitoreCertificazione;
import it.grupposcai.osamard.bean.NameId;
import it.grupposcai.osamard.dao.CertificazioniMaterialiDao;
import it.grupposcai.osamard.rest.response.NameIdResponse;
import it.grupposcai.osamard.service.CertificazioniMaterialiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("certificazioniMaterialiService")
public class CertificazioniMaterialiServiceImpl implements CertificazioniMaterialiService {


    @Autowired
    CertificazioniMaterialiDao certificazioniMaterialiDao;

    @Override
    public CertificazioniMateriali selectById(Long id) {
        return certificazioniMaterialiDao.getCertificazioneMaterialiById(id);
    }

    @Override
    public List<CertificazioniMateriali> selectByIdFornitore(Long idFornitore) {
        return certificazioniMaterialiDao.getCertificazioniMaterialiByIdFornitore(idFornitore);
    }

    @Override
    public void insertCertificazioniMateriali(FornitoreCertificazione request) {
        certificazioniMaterialiDao.insertFornitoreCertificazioniMateriali(request);
    }

    @Override
    public List<NameId> selectAll() {
        return certificazioniMaterialiDao.getAll();
    }


    @Override
    public NameIdResponse getCertificazioniMaterialiResponseById(Long id) {
        CertificazioniMateriali CertificazioneMateriali = selectById(id);
        if (CertificazioneMateriali == null){
            return null;
        }
        NameIdResponse resp = new NameIdResponse();
        resp.setName(CertificazioneMateriali.getNome());
        resp.setId(CertificazioneMateriali.getId());
        resp.setDisabled(CertificazioneMateriali.isDisabled());
        resp.setDtInserimento(CertificazioneMateriali.getDt_inserimento());
        resp.setDtModifica(CertificazioneMateriali.getDt_modifica());
        resp.setLastUserModified(CertificazioneMateriali.getLast_user_modified());
        resp.setFirstUser(CertificazioneMateriali.getFirst_user());
        return resp;
    }

    @Override
    public List<NameIdResponse> selectCertificazioneMaterialiResponseByIdFornitore(Long idFornitore) {
        List<CertificazioniMateriali> FornitoreCertificazioniMaterialiList = selectByIdFornitore(idFornitore);
        List<NameIdResponse> responseList = new ArrayList<>();
        if (FornitoreCertificazioniMaterialiList != null && !FornitoreCertificazioniMaterialiList.isEmpty()) {
            FornitoreCertificazioniMaterialiList.forEach(FornitoreCertificazione -> {
                responseList.add(getCertificazioniMaterialiResponseById(FornitoreCertificazione.getId()));
            });
        }
        return responseList;
    }

    @Override
    public void deleteCertificazioniMaterialiByIdFornitore(Long idFornitore) {
        certificazioniMaterialiDao.deleteCertificazioniMaterialiByIdFornitore(idFornitore);
    }
}
