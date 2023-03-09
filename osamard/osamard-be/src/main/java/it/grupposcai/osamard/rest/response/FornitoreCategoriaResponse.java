package it.grupposcai.osamard.rest.response;

import java.io.Serializable;
import java.util.List;

public class FornitoreCategoriaResponse extends NameIdResponse implements Serializable {

    private static final long serialVersionUID = -4822617367801876161L;

    private List<FornitoreSubcategoriaResponse> subcategoriaList;

    public List<FornitoreSubcategoriaResponse> getSubcategoriaList() {
        return subcategoriaList;
    }

    public void setSubcategoriaList(List<FornitoreSubcategoriaResponse> subcategoriaList) {
        this.subcategoriaList = subcategoriaList;
    }
}