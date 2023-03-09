package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.FornitoreCategoria;
import it.grupposcai.osamard.bean.FornitoreCategoriaSubcategoria;
import it.grupposcai.osamard.bean.NameId;
import it.grupposcai.osamard.rest.response.FornitoreCategoriaResponse;
import it.grupposcai.osamard.rest.response.NameIdResponse;

import java.util.List;

public interface FornitoreCategoriaService {

    FornitoreCategoria selectById(Long idCategoria);

    NameIdResponse getCategoriaResponseById(Long id_subcategoria);

    List<FornitoreCategoriaResponse> getFornitoreCategoriaResponseByCategorieAssociate(List<FornitoreCategoriaSubcategoria> fornitoreCategoriaSubcategoriaByIdForniotre);

    FornitoreCategoriaResponse getFornitoreCategoriaResponseByIdCategoria(FornitoreCategoriaSubcategoria fornitoreCategoriaSubcategoria);

    List<NameId> getAll();
}
