package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.FornitoreSubcategoria;
import it.grupposcai.osamard.rest.response.FornitoreSubcategoriaResponse;

import java.util.List;

public interface FornitoreSubcategoriaService {

    FornitoreSubcategoria selectById(Long idSubcategoria);

    List<FornitoreSubcategoria> selectAll();

    FornitoreSubcategoriaResponse getSubcategoriaResponseById(Long id_subcategoria);

    List<FornitoreSubcategoriaResponse> getFornitoreSubcategoriaResponseListByIdFornitoreAndIdCategoria(Long idFornitore, Long idCategoria);

    List<FornitoreSubcategoriaResponse> subcategoriaToSubcategoriaResponse(List<FornitoreSubcategoria> all);

    List<FornitoreSubcategoriaResponse> getAllsubcategoriaResponse();
}
