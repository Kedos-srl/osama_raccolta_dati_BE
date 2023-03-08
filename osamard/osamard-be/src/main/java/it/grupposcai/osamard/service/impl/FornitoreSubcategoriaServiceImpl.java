package it.grupposcai.osamard.service.impl;

import it.grupposcai.osamard.bean.FornitoreCategoria;
import it.grupposcai.osamard.bean.FornitoreSubcategoria;
import it.grupposcai.osamard.dao.FornitoreSubcategoriaDao;
import it.grupposcai.osamard.rest.response.FornitoreSubcategoriaResponse;
import it.grupposcai.osamard.rest.response.NameIdResponse;
import it.grupposcai.osamard.service.FornitoreSubcategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fornitoreSubcategoriaServiceImpl")
public class FornitoreSubcategoriaServiceImpl implements FornitoreSubcategoriaService {


    @Autowired
    FornitoreSubcategoriaDao fornitoreSubcategoriaDao;

    @Override
    public FornitoreSubcategoria selectById(Long idSubcategoria) {
        return fornitoreSubcategoriaDao.getSubcategoriaById(idSubcategoria);
    }

    @Override
    public FornitoreSubcategoriaResponse getSubcategoriaResponseById(Long idSubcategoria) {
        FornitoreSubcategoria fornitoreSubcategoria = selectById(idSubcategoria);
        if (fornitoreSubcategoria == null){
            return null;
        }
        FornitoreSubcategoriaResponse resp = new FornitoreSubcategoriaResponse();
        resp.setName(fornitoreSubcategoria.getNome());
        resp.setId(fornitoreSubcategoria.getId());
        resp.setIdCategoria(fornitoreSubcategoria.getId_categoria());
        resp.setDisabled(fornitoreSubcategoria.isDisabled());
        resp.setDtInserimento(fornitoreSubcategoria.getDt_inserimento());
        resp.setDtModifica(fornitoreSubcategoria.getDt_modifica());
        resp.setLastUserModified(fornitoreSubcategoria.getLast_user_modified());
        resp.setFirstUser(fornitoreSubcategoria.getFirst_user());
        return resp;
    }

}
