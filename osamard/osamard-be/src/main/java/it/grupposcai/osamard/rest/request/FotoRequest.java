package it.grupposcai.osamard.rest.request;

public class FotoRequest extends CommonAttributeRequest {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String titolo;
    private String pathFile;
    private Long idOggetto;
    private Long idTipoOggetto;
    private String foto;

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

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
