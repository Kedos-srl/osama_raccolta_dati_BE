package it.grupposcai.osamard.service.impl;

import it.grupposcai.osamard.bean.NameId;
import it.grupposcai.osamard.bean.Trading;
import it.grupposcai.osamard.dao.TradingDao;
import it.grupposcai.osamard.rest.response.NameIdResponse;
import it.grupposcai.osamard.service.TradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tradingService")
public class TradingServiceImpl implements TradingService {


    @Autowired
    TradingDao tradingDao;

    @Override
    public Trading selectById(Long id) {
        return tradingDao.getTradingById(id);
    }

    @Override
    public List<NameId> selectAll() {
        return tradingDao.getAll();
    }

    @Override
    public NameIdResponse getTradingResponseById(Long idTrading) {
        Trading trading = selectById(idTrading);
        if (trading == null){
            return null;
        }
        NameIdResponse resp = new NameIdResponse();
        resp.setName(trading.getNome());
        resp.setId(trading.getId());
        resp.setDisabled(trading.isDisabled());
        resp.setDtInserimento(trading.getDt_inserimento());
        resp.setDtModifica(trading.getDt_modifica());
        resp.setLastUserModified(trading.getLast_user_modified());
        resp.setFirstUser(trading.getFirst_user());
        return resp;
    }


}
