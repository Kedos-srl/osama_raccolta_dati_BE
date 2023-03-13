package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.Prodotto;
import it.grupposcai.osamard.rest.request.ProdottoRequest;
import it.grupposcai.osamard.rest.response.ProdottoResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProdottoService {

    @Transactional
    Prodotto insert(ProdottoRequest request);

    @Transactional
    Prodotto update(ProdottoRequest request);

    List<Prodotto> getProdottoByIdFornitore(Long idFornitore);

    Prodotto getProdottoById(Long id);

    ProdottoResponse getProdottoResponseById(Long id);

    List<ProdottoResponse> getProdottoResponseListByIdFornitore(Long idFornitore);
}
