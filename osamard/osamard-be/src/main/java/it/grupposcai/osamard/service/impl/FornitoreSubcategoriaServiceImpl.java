package it.grupposcai.osamard.service.impl;

import it.grupposcai.osamard.bean.*;
import it.grupposcai.osamard.dao.FornitoreSubcategoriaDao;
import it.grupposcai.osamard.rest.response.FornitoreSubcategoriaResponse;
import it.grupposcai.osamard.service.FornitoreSubcategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fornitoreSubcategoriaServiceImpl")
public class FornitoreSubcategoriaServiceImpl implements FornitoreSubcategoriaService {


    @Autowired
    FornitoreSubcategoriaDao fornitoreSubcategoriaDao;

    @Override
    public FornitoreSubcategoria selectById(Long idSubcategoria) {
        return fornitoreSubcategoriaDao.getSubcategoriaById(idSubcategoria);
    }

    @Override
    public List<FornitoreSubcategoria> selectAll() {
        return fornitoreSubcategoriaDao.getAll();
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

    @Override
    public List<FornitoreSubcategoriaResponse> getFornitoreSubcategoriaResponseListByIdFornitoreAndIdCategoria(Long idFornitore, Long idCategoria) {
        List<FornitoreCategoriaSubcategoria> subcategoriaList = fornitoreSubcategoriaDao.getFornitoreCategoriaSubcategoriaListByIdFornitoreAndIdCategoria(idFornitore, idCategoria);
        if (subcategoriaList == null || subcategoriaList.isEmpty()){
            return null;
        }
        List<FornitoreSubcategoriaResponse> responseList = new ArrayList<>();

        subcategoriaList.forEach(fornitoreCategoriaSubcategoria -> {
            if (fornitoreCategoriaSubcategoria.getId_subcategoria() == null){
                return;
            }
            responseList.add(getSubcategoriaResponseById(fornitoreCategoriaSubcategoria.getId_subcategoria()));
        });
        return responseList;
    }

    @Override
    public List<FornitoreSubcategoriaResponse> subcategoriaToSubcategoriaResponse(List<FornitoreSubcategoria> subcategoriaList) {
        if (subcategoriaList == null) {
            return null;
        }
        if (subcategoriaList.isEmpty()) {
            return new ArrayList<>();
        }
        List<FornitoreSubcategoriaResponse> respList = new ArrayList<>();
        subcategoriaList.forEach(nameId -> {
            FornitoreSubcategoriaResponse resp = new FornitoreSubcategoriaResponse();
            resp.setName(nameId.getNome());
            resp.setId(nameId.getId());
            resp.setIdCategoria(nameId.getId_categoria());
            resp.setDisabled(nameId.isDisabled());
            resp.setDtInserimento(nameId.getDt_inserimento());
            resp.setDtModifica(nameId.getDt_modifica());
            resp.setLastUserModified(nameId.getLast_user_modified());
            resp.setFirstUser(nameId.getFirst_user());
            respList.add(resp);
        });
        return respList;
    }

    @Override
    public List<FornitoreSubcategoriaResponse> getAllsubcategoriaResponse() {
        return subcategoriaToSubcategoriaResponse(selectAll());
    }


}
