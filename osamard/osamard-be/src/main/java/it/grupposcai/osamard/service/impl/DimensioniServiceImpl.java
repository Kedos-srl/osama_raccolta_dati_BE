package it.grupposcai.osamard.service.impl;

import it.grupposcai.osamard.bean.Dimensioni;
import it.grupposcai.osamard.dao.DimensioniDao;
import it.grupposcai.osamard.rest.response.NameIdResponse;
import it.grupposcai.osamard.service.DimensioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dimensioniService")
public class DimensioniServiceImpl implements DimensioniService {


    @Autowired
    DimensioniDao dimensioniDao;

    @Override
    public Dimensioni selectById(Long idDimensioni) {
        return dimensioniDao.getDimensioniById(idDimensioni);
    }

    @Override
    public NameIdResponse getDimensioniResponseById(Long idDimensioni) {
        Dimensioni dimensioni = selectById(idDimensioni);
        if (dimensioni == null){
            return null;
        }
        NameIdResponse resp = new NameIdResponse();
        resp.setName(dimensioni.getNome());
        resp.setId(dimensioni.getId());
        resp.setDisabled(dimensioni.isDisabled());
        resp.setDtInserimento(dimensioni.getDt_inserimento());
        resp.setDtModifica(dimensioni.getDt_modifica());
        resp.setLastUserModified(dimensioni.getLast_user_modified());
        resp.setFirstUser(dimensioni.getFirst_user());
        return resp;
    }

}
