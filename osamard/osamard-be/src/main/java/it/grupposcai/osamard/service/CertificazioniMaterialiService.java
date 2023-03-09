package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.CertificazioniMateriali;
import it.grupposcai.osamard.bean.FornitoreCertificazione;
import it.grupposcai.osamard.bean.NameId;
import it.grupposcai.osamard.rest.response.NameIdResponse;

import java.util.List;

public interface CertificazioniMaterialiService {


    CertificazioniMateriali selectById(Long id);

    List<CertificazioniMateriali> selectByIdFornitore(Long idFornitore);

    void insertCertificazioniMateriali(FornitoreCertificazione request);

    List<NameId> selectAll();

    NameIdResponse getCertificazioniMaterialiResponseById(Long id);

    List<NameIdResponse> selectCertificazioneMaterialiResponseByIdFornitore(Long idFornitore);
}
