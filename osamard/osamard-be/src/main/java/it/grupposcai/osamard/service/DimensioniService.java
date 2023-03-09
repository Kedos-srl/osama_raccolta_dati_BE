package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.Dimensioni;
import it.grupposcai.osamard.bean.NameId;
import it.grupposcai.osamard.rest.response.NameIdResponse;

import java.util.List;

public interface DimensioniService {

    Dimensioni selectById(Long idDimensioni);

    List<NameId> selectAll();

    NameIdResponse getDimensioniResponseById(Long idDimensioni);
}
