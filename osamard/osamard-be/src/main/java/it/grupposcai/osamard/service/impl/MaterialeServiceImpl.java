package it.grupposcai.osamard.service.impl;

import it.grupposcai.osamard.bean.Materiale;
import it.grupposcai.osamard.bean.NameId;
import it.grupposcai.osamard.dao.MaterialeDao;
import it.grupposcai.osamard.rest.response.NameIdResponse;
import it.grupposcai.osamard.service.MaterialeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("materialeService")
public class MaterialeServiceImpl implements MaterialeService {


    @Autowired
    MaterialeDao materialeDao;

    @Override
    public Materiale selectById(Long idMateriale) {
        return materialeDao.getMaterialeById(idMateriale);
    }

    @Override
    public List<NameId> selectAll(){
        return materialeDao.getAll();
    }

    @Override
    public NameIdResponse getMaterialeResponseById(Long idMateriale) {
        Materiale materiale = selectById(idMateriale);
        if (materiale == null){
            return null;
        }
        NameIdResponse resp = new NameIdResponse();
        resp.setName(materiale.getNome());
        resp.setId(materiale.getId());
        resp.setDisabled(materiale.isDisabled());
        resp.setDtInserimento(materiale.getDt_inserimento());
        resp.setDtModifica(materiale.getDt_modifica());
        resp.setLastUserModified(materiale.getLast_user_modified());
        resp.setFirstUser(materiale.getFirst_user());
        return resp;
    }

}
