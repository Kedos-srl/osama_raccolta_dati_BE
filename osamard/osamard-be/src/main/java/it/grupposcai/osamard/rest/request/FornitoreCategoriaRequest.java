package it.grupposcai.osamard.rest.request;

import java.util.List;

public class FornitoreCategoriaRequest extends CommonAttributeRequest {

    private static final long serialVersionUID = 1L;

    private Long idCategoria;
    private List<Long> idSubcategoriaList;

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public List<Long> getIdSubcategoriaList() {
        return idSubcategoriaList;
    }

    public void setIdSubcategoria(List<Long> idSubcategoria) {
        this.idSubcategoriaList = idSubcategoria;
    }
}
