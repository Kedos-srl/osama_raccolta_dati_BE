package it.grupposcai.osamard.service.impl;

import it.grupposcai.osamard.bean.CertificazioniFabbrica;
import it.grupposcai.osamard.bean.FornitoreCertificazione;
import it.grupposcai.osamard.bean.NameId;
import it.grupposcai.osamard.dao.CertificazioniFabbricaDao;
import it.grupposcai.osamard.rest.response.NameIdResponse;
import it.grupposcai.osamard.service.CertificazioniFabbricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("certificazioniFabbricaService")
public class CertificazioniFabbricaServiceImpl implements CertificazioniFabbricaService {


    @Autowired
    CertificazioniFabbricaDao certificazioniFabbricaDao;

    @Override
    public CertificazioniFabbrica selectById(Long id) {
        return certificazioniFabbricaDao.getCertificazioneFabbricaById(id);
    }

    @Override
    public List<CertificazioniFabbrica> selectByIdFornitore(Long idFornitore) {
        return certificazioniFabbricaDao.getCertificazioniFabbricaByIdFornitore(idFornitore);
    }

    @Override
    public void insertCertificazioniFabbrica(FornitoreCertificazione request) {
        certificazioniFabbricaDao.insertFornitoreCertificazioniFabbrica(request);
    }

    @Override
    public List<NameId> selectAll() {
        return certificazioniFabbricaDao.getAll();
    }

    @Override
    public NameIdResponse getCertificazioniFabbricaResponseById(Long id) {
        CertificazioniFabbrica CertificazioneFabbrica = selectById(id);
        if (CertificazioneFabbrica == null){
            return null;
        }
        NameIdResponse resp = new NameIdResponse();
        resp.setName(CertificazioneFabbrica.getNome());
        resp.setId(CertificazioneFabbrica.getId());
        resp.setDisabled(CertificazioneFabbrica.isDisabled());
        resp.setDtInserimento(CertificazioneFabbrica.getDt_inserimento());
        resp.setDtModifica(CertificazioneFabbrica.getDt_modifica());
        resp.setLastUserModified(CertificazioneFabbrica.getLast_user_modified());
        resp.setFirstUser(CertificazioneFabbrica.getFirst_user());
        return resp;
    }

    @Override
    public List<NameIdResponse> selectCertificazioneFabbricaResponseByIdFornitore(Long idFornitore) {
        List<CertificazioniFabbrica> FornitoreCertificazioniFabbricaList = selectByIdFornitore(idFornitore);
        List<NameIdResponse> responseList = new ArrayList<>();
        if (FornitoreCertificazioniFabbricaList != null && !FornitoreCertificazioniFabbricaList.isEmpty()) {
            FornitoreCertificazioniFabbricaList.forEach(FornitoreCertificazione -> {
                responseList.add(getCertificazioniFabbricaResponseById(FornitoreCertificazione.getId()));
            });
        }
        return responseList;
    }

}
