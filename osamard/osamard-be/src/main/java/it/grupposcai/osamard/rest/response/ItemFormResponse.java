package it.grupposcai.osamard.rest.response;

import it.grupposcai.osamard.bean.*;
import it.grupposcai.osamard.bean.NameId;

import java.io.Serializable;
import java.util.List;

public class ItemFormResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<NameIdResponse> materiale;
    private List<NameIdResponse> dimensioni;
    private List<NameIdResponse> moq;
    private List<NameIdResponse> campioni;
    private List<NameIdResponse> produzione;
    private List<NameIdResponse> trading;
    private List<NameIdResponse> certificazioniFabbrica;
    private List<NameIdResponse> fornitoreCategoria;
    private List<FornitoreSubcategoriaResponse> fornitoreSubcategoria;
    private List<NameIdResponse> certificazioniMateriali;

    public List<NameIdResponse> getMateriale() {
        return materiale;
    }

    public void setMateriale(List<NameIdResponse> materiale) {
        this.materiale = materiale;
    }

    public List<NameIdResponse> getDimensioni() {
        return dimensioni;
    }

    public void setDimensioni(List<NameIdResponse> dimensioni) {
        this.dimensioni = dimensioni;
    }

    public List<NameIdResponse> getMoq() {
        return moq;
    }

    public void setMoq(List<NameIdResponse> moq) {
        this.moq = moq;
    }

    public List<NameIdResponse> getCampioni() {
        return campioni;
    }

    public void setCampioni(List<NameIdResponse> campioni) {
        this.campioni = campioni;
    }

    public List<NameIdResponse> getProduzione() {
        return produzione;
    }

    public void setProduzione(List<NameIdResponse> produzione) {
        this.produzione = produzione;
    }

    public List<NameIdResponse> getTrading() {
        return trading;
    }

    public void setTrading(List<NameIdResponse> trading) {
        this.trading = trading;
    }

    public List<NameIdResponse> getCertificazioniFabbrica() {
        return certificazioniFabbrica;
    }

    public void setCertificazioniFabbrica(List<NameIdResponse> certificazioniFabbrica) {
        this.certificazioniFabbrica = certificazioniFabbrica;
    }

    public List<NameIdResponse> getFornitoreCategoria() {
        return fornitoreCategoria;
    }

    public void setFornitoreCategoria(List<NameIdResponse> fornitoreCategoria) {
        this.fornitoreCategoria = fornitoreCategoria;
    }

    public List<FornitoreSubcategoriaResponse> getFornitoreSubcategoria() {
        return fornitoreSubcategoria;
    }

    public void setFornitoreSubcategoria(List<FornitoreSubcategoriaResponse> fornitoreSubcategoria) {
        this.fornitoreSubcategoria = fornitoreSubcategoria;
    }

    public List<NameIdResponse> getCertificazioniMateriali() {
        return certificazioniMateriali;
    }

    public void setCertificazioniMateriali(List<NameIdResponse> certificazioniMateriali) {
        this.certificazioniMateriali = certificazioniMateriali;
    }
}