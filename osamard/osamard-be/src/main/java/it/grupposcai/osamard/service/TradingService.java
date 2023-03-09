package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.NameId;
import it.grupposcai.osamard.bean.Trading;
import it.grupposcai.osamard.rest.response.NameIdResponse;

import java.util.List;

public interface TradingService {

    Trading selectById(Long id);

    List<NameId> selectAll();

    NameIdResponse getTradingResponseById(Long id_trading);
}
