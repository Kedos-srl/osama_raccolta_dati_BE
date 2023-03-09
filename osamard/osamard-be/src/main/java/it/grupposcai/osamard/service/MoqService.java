package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.Moq;
import it.grupposcai.osamard.bean.NameId;
import it.grupposcai.osamard.rest.response.NameIdResponse;

import java.util.List;

public interface MoqService {

    Moq selectById(Long idMoq);

    List<NameId> selectAll();

    NameIdResponse getMoqResponseById(Long idMoq);
}
