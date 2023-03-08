package it.grupposcai.osamard.rest.request;

import java.util.List;

public class ProdottoRequest extends CommonAttributeRequest {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String codArticolo;
    private Long idMateriale;
    private Long idDimensioni;
    private Long idMoq;
    private Long idPrezzo;
    private Long idFornitore;
    private List<FotoRequest> fotoList;

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

    public Long getIdMateriale() {
        return idMateriale;
    }

    public void setIdMateriale(Long idMateriale) {
        this.idMateriale = idMateriale;
    }

    public Long getIdDimensioni() {
        return idDimensioni;
    }

    public void setIdDimensioni(Long idDimensioni) {
        this.idDimensioni = idDimensioni;
    }

    public Long getIdMoq() {
        return idMoq;
    }

    public void setIdMoq(Long idMoq) {
        this.idMoq = idMoq;
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

    public List<FotoRequest> getFotoList() {
        return fotoList;
    }

    public void setFotoList(List<FotoRequest> fotoList) {
        this.fotoList = fotoList;
    }
}
