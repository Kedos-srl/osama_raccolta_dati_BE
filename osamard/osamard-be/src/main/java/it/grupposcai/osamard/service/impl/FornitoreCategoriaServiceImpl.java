package it.grupposcai.osamard.service.impl;

import it.grupposcai.osamard.bean.FornitoreCategoria;
import it.grupposcai.osamard.dao.FornitoreCategoriaDao;
import it.grupposcai.osamard.rest.response.NameIdResponse;
import it.grupposcai.osamard.service.FornitoreCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fornitoreCategoriaService")
public class FornitoreCategoriaServiceImpl implements FornitoreCategoriaService {


    @Autowired
    FornitoreCategoriaDao fornitoreCategoriaDao;

    @Override
    public FornitoreCategoria selectById(Long idCategoria) {
        return fornitoreCategoriaDao.getCategoriaById(idCategoria);
    }

    @Override
    public NameIdResponse getCategoriaResponseById(Long idCategoria) {
        FornitoreCategoria fornitoreCategoria = selectById(idCategoria);
        if (fornitoreCategoria == null){
            return null;
        }
        NameIdResponse resp = new NameIdResponse();
        resp.setName(fornitoreCategoria.getNome());
        resp.setId(fornitoreCategoria.getId());
        resp.setDisabled(fornitoreCategoria.isDisabled());
        resp.setDtInserimento(fornitoreCategoria.getDt_inserimento());
        resp.setDtModifica(fornitoreCategoria.getDt_modifica());
        resp.setLastUserModified(fornitoreCategoria.getLast_user_modified());
        resp.setFirstUser(fornitoreCategoria.getFirst_user());
        return resp;
    }

}
