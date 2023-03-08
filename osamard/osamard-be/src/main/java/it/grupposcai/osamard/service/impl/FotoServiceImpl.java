package it.grupposcai.osamard.service.impl;

import it.grupposcai.osamard.bean.Foto;
import it.grupposcai.osamard.dao.FotoDao;
import it.grupposcai.osamard.rest.request.FotoRequest;
import it.grupposcai.osamard.rest.response.FotoResponse;
import it.grupposcai.osamard.service.FotoService;
import it.grupposcai.osamard.util.FileUtility;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service("fotoService")
public class FotoServiceImpl implements FotoService {


    @Autowired
    FotoDao fotoDao;

    @Value("file.path.external")
    String filePathExternal;


    @Override
    @Transactional
    public Foto insert(FotoRequest request) throws Exception {
        Foto foto = fotoRequestToFoto(request);
        byte[] imageDataBytes = Base64.decodeBase64(request.getFoto().substring(request.getFoto().indexOf(",") + 1));
        InputStream is = new ByteArrayInputStream(imageDataBytes);

        String destinationPathAbsolute = FileUtility.generatePathDestinationFile(filePathExternal, is, request.getTitolo());
        String pathFile = "";
        pathFile = destinationPathAbsolute.replace(filePathExternal.trim(), "");
        pathFile = pathFile.replace("\\", "/");
        request.setPathFile(pathFile);

        fotoDao.insert(foto);
        return foto;
    }

    @Override
    public List<Foto> getFotoByIdOggettoAndTipoOggetto(Long idOggetto, Long idTipoOggetto) {
        if (idOggetto == null) {
            return null;
        }
        return fotoDao.getFotoByIdOggettoAndTipoOggetto(idOggetto, idTipoOggetto);
    }

    @Override
    public Foto getFotoById(Long id) {
        if (id == null) {
            return null;
        }
        return fotoDao.getFotoById(id);
    }

    @Override
    public FotoResponse getFotoResponseById(Long id) {

        Foto foto = getFotoById(id);
        if (foto == null){
            return null;
        }
        FotoResponse resp = new FotoResponse();
        resp.setId(foto.getId());
        resp.setTitolo(foto.getTitolo());
        resp.setIdOggetto(foto.getId_oggetto());
        resp.setIdTipoOggetto(foto.getId_tipo_oggetto());
        resp.setPathFile(foto.getPath_file());

        resp.setDisabled(foto.isDisabled());
        resp.setDtInserimento(foto.getDt_inserimento());
        resp.setDtModifica(foto.getDt_modifica());
        resp.setLastUserModified(foto.getLast_user_modified());
        resp.setFirstUser(foto.getFirst_user());
        return resp;
    }
    
    @Override
    public List<FotoResponse> getFotoResponseByIdOggettoAndTipoOggetto(Long idOggetto, Long idFotoTipoOggetto) {
        List<Foto> fotoList = getFotoByIdOggettoAndTipoOggetto(idOggetto, idFotoTipoOggetto);
        List<FotoResponse> responseList = new ArrayList<>();
        if (fotoList != null && !fotoList.isEmpty()){
            fotoList.forEach(foto -> {
                responseList.add(getFotoResponseById(foto.getId()));
            });
        }
        return responseList;
    }

    private Foto fotoRequestToFoto(FotoRequest request) {
        Foto foto = new Foto();
        foto.setTitolo(request.getTitolo());
        foto.setPath_file(request.getPathFile());
        foto.setId_oggetto(request.getIdOggetto());
        foto.setId_tipo_oggetto(request.getIdTipoOggetto());

        foto.setDisabled(request.getDisabled());
        foto.setDt_inserimento(request.getDtInserimento());
        foto.setDt_modifica(request.getDtModifica());
        foto.setFirst_user(request.getFirstUser());
        foto.setLast_user_modified(request.getLastUserModified());

        return foto;
    }

}
