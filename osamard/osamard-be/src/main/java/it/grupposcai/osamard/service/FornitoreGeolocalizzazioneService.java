package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.FornitoreGeolocalizzazione;
import it.grupposcai.osamard.rest.request.FornitoreGeolocalizzazioneRequest;
import it.grupposcai.osamard.rest.response.FornitoreGeolocalizzazioneResponse;

public interface FornitoreGeolocalizzazioneService {

    FornitoreGeolocalizzazione selectById(Long idCategoria);

    FornitoreGeolocalizzazione selectByIdFornitore(Long idFornitore);

    FornitoreGeolocalizzazione insert(FornitoreGeolocalizzazioneRequest request);

    FornitoreGeolocalizzazioneResponse getFornitoreGeolocalizzazioneResponseById(Long idFornitoreGeolocalizzazione);

    FornitoreGeolocalizzazioneResponse getFornitoreGeolocalizzazioneResponseByIdFornitore(Long idFornitore);
}
