package it.grupposcai.osamard.rest.request;

import java.util.List;

public class FornitoreRequest extends CommonAttributeRequest {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String ragioneSociale;
    private String tempoMercato;
    private Long idCategoria;
    private Long idSubcategoria;
    private String fatTot;
    private String fatIt;
    private Long numeroDipendenti;
    private Boolean rdInterno;
    private Long idTrading;
    private ContattoRequest contatto;
    private List<ProdottoRequest> prodottoList;
    private List<FotoRequest> fotoList;

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

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(Long idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
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

    public Long getIdTrading() {
        return idTrading;
    }

    public void setIdTrading(Long idTrading) {
        this.idTrading = idTrading;
    }

    public ContattoRequest getContatto() {
        return contatto;
    }

    public void setContatto(ContattoRequest contatto) {
        this.contatto = contatto;
    }

    public List<ProdottoRequest> getProdottoList() {
        return prodottoList;
    }

    public void setProdottoList(List<ProdottoRequest> prodottoList) {
        this.prodottoList = prodottoList;
    }

    public List<FotoRequest> getFotoList() {
        return fotoList;
    }

    public void setFotoList(List<FotoRequest> fotoList) {
        this.fotoList = fotoList;
    }
}
