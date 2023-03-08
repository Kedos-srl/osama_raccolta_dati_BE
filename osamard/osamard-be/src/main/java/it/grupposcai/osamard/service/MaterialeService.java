package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.Materiale;
import it.grupposcai.osamard.rest.response.NameIdResponse;

public interface MaterialeService {

    Materiale selectById(Long idMateriale);

    NameIdResponse getMaterialeResponseById(Long idMateriale);
}
