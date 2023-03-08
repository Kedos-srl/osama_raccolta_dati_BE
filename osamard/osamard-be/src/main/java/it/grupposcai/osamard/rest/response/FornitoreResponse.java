package it.grupposcai.osamard.rest.response;

import java.io.Serializable;
import java.util.List;

public class FornitoreResponse implements Serializable {

    private static final long serialVersionUID = -4822617367801876161L;

    private Long id;
    private String ragioneSociale;
    private String tempoMercato;
    private NameIdResponse categoria;
    private FornitoreSubcategoriaResponse subcategoria;

    private String fatTot;
    private String fatIt;
    private Long numeroDipendenti;
    private Boolean rdInterno;
    private NameIdResponse trading;
    private ContattoResponse contatto;

    private List<ProdottoResponse> prodottoList;
    private List<FotoResponse> fotoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getTempoMercato() {
        return tempoMercato;
    }

    public void setTempoMercato(String tempoMercato) {
        this.tempoMercato = tempoMercato;
    }

    public NameIdResponse getCategoria() {
        return categoria;
    }

    public void setCategoria(NameIdResponse categoria) {
        this.categoria = categoria;
    }

    public FornitoreSubcategoriaResponse getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(FornitoreSubcategoriaResponse subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getFatTot() {
        return fatTot;
    }

    public void setFatTot(String fatTot) {
        this.fatTot = fatTot;
    }

    public String getFatIt() {
        return fatIt;
    }

    public void setFatIt(String fatIt) {
        this.fatIt = fatIt;
    }

    public Long getNumeroDipendenti() {
        return numeroDipendenti;
    }

    public void setNumeroDipendenti(Long numeroDipendenti) {
        this.numeroDipendenti = numeroDipendenti;
    }

    public Boolean getRdInterno() {
        return rdInterno;
    }

    public void setRdInterno(Boolean rdInterno) {
        this.rdInterno = rdInterno;
    }

    public NameIdResponse getTrading() {
        return trading;
    }

    public void setTrading(NameIdResponse trading) {
        this.trading = trading;
    }

    public ContattoResponse getContatto() {
        return contatto;
    }

    public void setContatto(ContattoResponse contatto) {
        this.contatto = contatto;
    }

    public List<ProdottoResponse> getProdottoList() {
        return prodottoList;
    }

    public void setProdottoList(List<ProdottoResponse> prodottoList) {
        this.prodottoList = prodottoList;
    }

    public List<FotoResponse> getFotoList() {
        return fotoList;
    }

    public void setFotoList(List<FotoResponse> fotoList) {
        this.fotoList = fotoList;
    }
}