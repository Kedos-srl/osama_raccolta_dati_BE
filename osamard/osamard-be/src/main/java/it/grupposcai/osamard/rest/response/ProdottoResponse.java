package it.grupposcai.osamard.rest.response;

import java.util.List;

public class ProdottoResponse extends CommonAttributeResponse {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String codArticolo;
    private NameIdResponse materiale;
    private NameIdResponse dimensioni;
    private NameIdResponse moq;
    private Long idPrezzo;
    private Long idFornitore;
    private List<FotoResponse> fotoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodArticolo() {
        return codArticolo;
    }

    public void setCodArticolo(String codArticolo) {
        this.codArticolo = codArticolo;
    }

    public NameIdResponse getMateriale() {
        return materiale;
    }

    public void setMateriale(NameIdResponse materiale) {
        this.materiale = materiale;
    }

    public NameIdResponse getDimensioni() {
        return dimensioni;
    }

    public void setDimensioni(NameIdResponse dimensioni) {
        this.dimensioni = dimensioni;
    }

    public NameIdResponse getMoq() {
        return moq;
    }

    public void setMoq(NameIdResponse moq) {
        this.moq = moq;
    }

    public Long getIdPrezzo() {
        return idPrezzo;
    }

    public void setIdPrezzo(Long idPrezzo) {
        this.idPrezzo = idPrezzo;
    }

    public Long getIdFornitore() {
        return idFornitore;
    }

    public void setIdFornitore(Long idFornitore) {
        this.idFornitore = idFornitore;
    }

    public List<FotoResponse> getFotoList() {
        return fotoList;
    }

    public void setFotoList(List<FotoResponse> fotoList) {
        this.fotoList = fotoList;
    }
}
