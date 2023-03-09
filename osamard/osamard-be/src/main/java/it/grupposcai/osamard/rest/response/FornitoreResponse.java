package it.grupposcai.osamard.rest.response;

import java.io.Serializable;
import java.util.List;

public class FornitoreResponse implements Serializable {

    private static final long serialVersionUID = -4822617367801876161L;

    private Long id;
    private String ragioneSociale;
    private String tempoMercato;
    private List<FornitoreCategoriaResponse> CategoriaList;
    private String fatTot;
    private String fatIt;
    private Long numeroDipendenti;
    private Boolean rdInterno;
    private NameIdResponse trading;
    private ContattoResponse contatto;

    private List<ProdottoResponse> prodottoList;
    private List<FotoResponse> fotoList;
    private FornitoreGeolocalizzazioneResponse fornitoreGeolocalizzazione;
    private List<NameIdResponse> certificazioniMateriali;
    private List<NameIdResponse> certificazioniFabbrica;

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

    public FornitoreGeolocalizzazioneResponse getFornitoreGeolocalizzazione() {
        return fornitoreGeolocalizzazione;
    }

    public void setFornitoreGeolocalizzazione(FornitoreGeolocalizzazioneResponse fornitoreGeolocalizzazione) {
        this.fornitoreGeolocalizzazione = fornitoreGeolocalizzazione;
    }

    public List<NameIdResponse> getCertificazioniMateriali() {
        return certificazioniMateriali;
    }

    public void setCertificazioniMateriali(List<NameIdResponse> certificazioniMateriali) {
        this.certificazioniMateriali = certificazioniMateriali;
    }

    public List<NameIdResponse> getCertificazioniFabbrica() {
        return certificazioniFabbrica;
    }

    public void setCertificazioniFabbrica(List<NameIdResponse> certificazioniFabbrica) {
        this.certificazioniFabbrica = certificazioniFabbrica;
    }

    public List<FornitoreCategoriaResponse> getCategoriaList() {
        return CategoriaList;
    }

    public void setCategoriaList(List<FornitoreCategoriaResponse> categoriaList) {
        CategoriaList = categoriaList;
    }
}