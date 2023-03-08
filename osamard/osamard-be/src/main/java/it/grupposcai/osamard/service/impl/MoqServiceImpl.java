package it.grupposcai.osamard.service.impl;

import it.grupposcai.osamard.bean.Moq;
import it.grupposcai.osamard.dao.MoqDao;
import it.grupposcai.osamard.rest.response.NameIdResponse;
import it.grupposcai.osamard.service.MoqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("moqService")
public class MoqServiceImpl implements MoqService {


    @Autowired
    MoqDao moqDao;

    @Override
    public Moq selectById(Long idMoq) {
        return moqDao.getMoqById(idMoq);
    }

    @Override
    public NameIdResponse getMoqResponseById(Long idMoq) {
        Moq moq = selectById(idMoq);
        if (moq == null){
            return null;
        }
        NameIdResponse resp = new NameIdResponse();
        resp.setName(moq.getNome());
        resp.setId(moq.getId());
        resp.setDisabled(moq.isDisabled());
        resp.setDtInserimento(moq.getDt_inserimento());
        resp.setDtModifica(moq.getDt_modifica());
        resp.setLastUserModified(moq.getLast_user_modified());
        resp.setFirstUser(moq.getFirst_user());
        return resp;
    }

}
