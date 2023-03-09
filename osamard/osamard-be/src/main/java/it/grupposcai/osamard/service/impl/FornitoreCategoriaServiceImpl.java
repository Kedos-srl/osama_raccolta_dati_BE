package it.grupposcai.osamard.service.impl;

import it.grupposcai.osamard.bean.FornitoreCategoria;
import it.grupposcai.osamard.bean.FornitoreCategoriaSubcategoria;
import it.grupposcai.osamard.bean.NameId;
import it.grupposcai.osamard.dao.FornitoreCategoriaDao;
import it.grupposcai.osamard.rest.response.FornitoreCategoriaResponse;
import it.grupposcai.osamard.rest.response.NameIdResponse;
import it.grupposcai.osamard.service.FornitoreCategoriaService;
import it.grupposcai.osamard.service.FornitoreSubcategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fornitoreCategoriaService")
public class FornitoreCategoriaServiceImpl implements FornitoreCategoriaService {


    @Autowired
    FornitoreCategoriaDao fornitoreCategoriaDao;
    @Autowired
    FornitoreSubcategoriaService fornitoreSubcategoriaService;

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

    @Override
    public List<FornitoreCategoriaResponse> getFornitoreCategoriaResponseByCategorieAssociate(List<FornitoreCategoriaSubcategoria> fornitoreCategoriaSubcategoriaList) {
        if (fornitoreCategoriaSubcategoriaList == null || fornitoreCategoriaSubcategoriaList.isEmpty()){
            return null;
        }
        List<FornitoreCategoriaResponse> responseList = new ArrayList<>();

        fornitoreCategoriaSubcategoriaList.forEach(fornitoreCategoriaSubcategoria -> {
            responseList.add(getFornitoreCategoriaResponseByIdCategoria(fornitoreCategoriaSubcategoria));
        });
        return responseList;
    }

    @Override
    public FornitoreCategoriaResponse getFornitoreCategoriaResponseByIdCategoria(FornitoreCategoriaSubcategoria fornitoreCategoriaSubcategoria) {
        if (fornitoreCategoriaSubcategoria.getId_categoria() == null) {
            return null;
        }
        NameIdResponse categoria = getCategoriaResponseById(fornitoreCategoriaSubcategoria.getId_categoria());
        FornitoreCategoriaResponse response = new FornitoreCategoriaResponse();
        response.setId(categoria.getId());
        response.setName(categoria.getName());

        response.setDisabled(categoria.getDisabled());
        response.setDtInserimento(categoria.getDtInserimento());
        response.setDtModifica(categoria.getDtModifica());
        response.setLastUserModified(categoria.getLastUserModified());
        response.setFirstUser(categoria.getFirstUser());
        response.setSubcategoriaList(fornitoreSubcategoriaService.getFornitoreSubcategoriaResponseListByIdFornitoreAndIdCategoria(fornitoreCategoriaSubcategoria.getId_fornitore(), categoria.getId()));

        return response;

    }

    @Override
    public List<NameId> getAll() {
        return fornitoreCategoriaDao.getAll();
    }

}
