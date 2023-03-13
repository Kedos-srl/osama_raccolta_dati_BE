package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.Foto;
import it.grupposcai.osamard.rest.request.FotoRequest;
import it.grupposcai.osamard.rest.response.FotoResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface FotoService {

    @Transactional
    Foto insert(FotoRequest request) throws Exception;

    List<Foto> getFotoByIdOggettoAndTipoOggetto(Long idOggetto, Long idTipoOggetto);

    Foto getFotoById(Long id);

    FotoResponse getFotoResponseById(Long id);

    List<FotoResponse> getFotoResponseByIdOggettoAndTipoOggetto(Long id, Long prodotto);

    FotoResponse save(FotoRequest request) throws Exception;

    void delete(FotoRequest request);
}
