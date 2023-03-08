package it.grupposcai.osamard.rest.response;

public class FotoResponse extends CommonAttributeResponse {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String titolo;
    private Long idOggetto;
    private Long idTipoOggetto;
    private String pathFile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Long getIdOggetto() {
        return idOggetto;
    }

    public void setIdOggetto(Long idOggetto) {
        this.idOggetto = idOggetto;
    }

    public Long getIdTipoOggetto() {
        return idTipoOggetto;
    }

    public void setIdTipoOggetto(Long idTipoOggetto) {
        this.idTipoOggetto = idTipoOggetto;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }
}
