package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.FornitoreCategoria;
import it.grupposcai.osamard.rest.response.NameIdResponse;

public interface FornitoreCategoriaService {

    FornitoreCategoria selectById(Long idCategoria);

    NameIdResponse getCategoriaResponseById(Long id_subcategoria);
}
