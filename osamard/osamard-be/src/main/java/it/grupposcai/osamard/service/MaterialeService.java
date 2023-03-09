package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.Materiale;
import it.grupposcai.osamard.bean.NameId;
import it.grupposcai.osamard.rest.response.NameIdResponse;

import java.util.List;

public interface MaterialeService {

    Materiale selectById(Long idMateriale);

    List<NameId> selectAll();

    NameIdResponse getMaterialeResponseById(Long idMateriale);
}
