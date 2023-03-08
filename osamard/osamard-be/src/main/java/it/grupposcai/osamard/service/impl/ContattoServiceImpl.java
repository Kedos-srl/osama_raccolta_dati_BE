package it.grupposcai.osamard.service.impl;

import it.grupposcai.osamard.bean.Contatto;
import it.grupposcai.osamard.bean.FornitoreCategoria;
import it.grupposcai.osamard.dao.ContattoDao;
import it.grupposcai.osamard.rest.request.ContattoRequest;
import it.grupposcai.osamard.rest.response.ContattoResponse;
import it.grupposcai.osamard.rest.response.NameIdResponse;
import it.grupposcai.osamard.service.ContattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("contattoService")
public class ContattoServiceImpl implements ContattoService {


    @Autowired
    ContattoDao contattoDao;

    @Override
    public Contatto selectById(Long id) {
        return contattoDao.getContattoById(id);
    }

    @Override
    public Contatto save(ContattoRequest request){
        if (request == null){
            return null;
        }

        Contatto contatto = contattoRequestToContatt(request);
        contattoDao.insert(contatto);
        return contatto;
    }

    @Override
    public ContattoResponse getContattoResponseById(Long idContatto) {
        Contatto contatto = selectById(idContatto);
        if (contatto == null){
            return null;
        }
        ContattoResponse resp = new ContattoResponse();
        resp.setName(contatto.getNome());
        resp.setId(contatto.getId());
        resp.setPosizione(contatto.getPosizione());
        resp.setDisabled(contatto.isDisabled());
        resp.setDtInserimento(contatto.getDt_inserimento());
        resp.setDtModifica(contatto.getDt_modifica());
        resp.setLastUserModified(contatto.getLast_user_modified());
        resp.setFirstUser(contatto.getFirst_user());
        return resp;
    }

    private Contatto contattoRequestToContatt(ContattoRequest request) {
        Contatto contatto = new Contatto();
        contatto.setNome(request.getNome());
        contatto.setPosizione(request.getPosizione());
        contatto.setDisabled(request.getDisabled());
        contatto.setDt_inserimento(request.getDtInserimento());
        contatto.setDt_modifica(request.getDtModifica());
        contatto.setFirst_user(request.getFirstUser());
        contatto.setLast_user_modified(request.getLastUserModified());

        return contatto;
    }

}
