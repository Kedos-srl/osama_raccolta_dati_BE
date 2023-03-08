package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.Contatto;
import it.grupposcai.osamard.rest.request.ContattoRequest;
import it.grupposcai.osamard.rest.response.ContattoResponse;

public interface ContattoService {

    Contatto selectById(Long id);

    Contatto save(ContattoRequest request);

    ContattoResponse getContattoResponseById(Long id_contatto);
}
