package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.Dimensioni;
import it.grupposcai.osamard.rest.response.NameIdResponse;

public interface DimensioniService {

    Dimensioni selectById(Long idDimensioni);

    NameIdResponse getDimensioniResponseById(Long idDimensioni);
}
