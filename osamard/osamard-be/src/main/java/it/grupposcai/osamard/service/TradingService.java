package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.Trading;
import it.grupposcai.osamard.rest.response.NameIdResponse;

public interface TradingService {

    Trading selectById(Long id);

    NameIdResponse getTradingResponseById(Long id_trading);
}
