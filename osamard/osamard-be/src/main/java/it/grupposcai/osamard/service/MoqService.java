package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.Moq;
import it.grupposcai.osamard.rest.response.NameIdResponse;

public interface MoqService {

    Moq selectById(Long idMoq);

    NameIdResponse getMoqResponseById(Long idMoq);
}
