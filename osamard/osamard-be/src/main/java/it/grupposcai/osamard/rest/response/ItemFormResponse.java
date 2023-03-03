package it.grupposcai.osamard.rest.response;

import it.grupposcai.osamard.bean.*;

import java.io.Serializable;
import java.util.List;

public class ItemFormResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Materiale> materiale;
    private List<Dimensioni> dimensioni;
    private List<Moq> moq;
    private List<Campioni> campioni;
    private List<Produzione> produzione;
    private List<Trading> trading;
    private List<CertificazioniFabbrica> certificazioniFabbrica;
    private List<FornitoreCategoria> fornitoreCategoria;
    private List<FornitoreSubcategoria> fornitoreSubcategoria;
    private List<CertificazioniMateriali> certificazioniMateriali;

    public List<Materiale> getMateriale() {
        return materiale;
    }

    public void setMateriale(List<Materiale> materiale) {
        this.materiale = materiale;
    }

    public List<Dimensioni> getDimensioni() {
        return dimensioni;
    }

    public void setDimensioni(List<Dimensioni> dimensioni) {
        this.dimensioni = dimensioni;
    }

    public List<Moq> getMoq() {
        return moq;
    }

    public void setMoq(List<Moq> moq) {
        this.moq = moq;
    }

    public List<Campioni> getCampioni() {
        return campioni;
    }

    public void setCampioni(List<Campioni> campioni) {
        this.campioni = campioni;
    }

    public List<Produzione> getProduzione() {
        return produzione;
    }

    public void setProduzione(List<Produzione> produzione) {
        this.produzione = produzione;
    }

    public List<Trading> getTrading() {
        return trading;
    }

    public void setTrading(List<Trading> trading) {
        this.trading = trading;
    }

    public List<CertificazioniFabbrica> getCertificazioni() {
        return certificazioniFabbrica;
    }

    public void setCertificazioni(List<CertificazioniFabbrica> certificazioniFabbrica) {
        this.certificazioniFabbrica = certificazioniFabbrica;
    }

    public List<FornitoreCategoria> getFornitoreCategoria() {
        return fornitoreCategoria;
    }

    public void setFornitoreCategoria(List<FornitoreCategoria> fornitoreCategoria) {
        this.fornitoreCategoria = fornitoreCategoria;
    }

    public List<FornitoreSubcategoria> getFornitoreSubcategoria() {
        return fornitoreSubcategoria;
    }

    public void setFornitoreSubcategoria(List<FornitoreSubcategoria> fornitoreSubcategoria) {
        this.fornitoreSubcategoria = fornitoreSubcategoria;
    }

    public List<CertificazioniFabbrica> getCertificazioniFabbrica() {
        return certificazioniFabbrica;
    }

    public void setCertificazioniFabbrica(List<CertificazioniFabbrica> certificazioniFabbrica) {
        this.certificazioniFabbrica = certificazioniFabbrica;
    }

    public List<CertificazioniMateriali> getCertificazioniMateriali() {
        return certificazioniMateriali;
    }

    public void setCertificazioniMateriali(List<CertificazioniMateriali> certificazioniMateriali) {
        this.certificazioniMateriali = certificazioniMateriali;
    }
}