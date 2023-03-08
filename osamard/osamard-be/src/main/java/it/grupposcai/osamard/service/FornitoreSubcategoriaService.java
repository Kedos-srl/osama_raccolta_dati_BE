package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.FornitoreSubcategoria;
import it.grupposcai.osamard.rest.response.FornitoreSubcategoriaResponse;

public interface FornitoreSubcategoriaService {

    FornitoreSubcategoria selectById(Long idSubcategoria);

    FornitoreSubcategoriaResponse getSubcategoriaResponseById(Long id_subcategoria);
}
