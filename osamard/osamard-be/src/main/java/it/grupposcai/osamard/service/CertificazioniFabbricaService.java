package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.CertificazioniFabbrica;
import it.grupposcai.osamard.bean.FornitoreCertificazione;
import it.grupposcai.osamard.bean.NameId;
import it.grupposcai.osamard.rest.response.NameIdResponse;

import java.util.List;

public interface CertificazioniFabbricaService {

    CertificazioniFabbrica selectById(Long id);

    NameIdResponse getCertificazioniFabbricaResponseById(Long id);

    List<CertificazioniFabbrica> selectByIdFornitore(Long idFornitore);

    void insertCertificazioniFabbrica(FornitoreCertificazione request);

    List<NameId> selectAll();

    List<NameIdResponse> selectCertificazioneFabbricaResponseByIdFornitore(Long idFornitore);
}
