package it.grupposcai.osamard.bean;

public class Foto extends CommonsAttribute {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String titolo;
    private String path_file;
    private Long id_oggetto;
    private Long id_tipo_oggetto;

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

    public String getPath_file() {
        return path_file;
    }

    public void setPath_file(String path_file) {
        this.path_file = path_file;
    }

    public Long getId_oggetto() {
        return id_oggetto;
    }

    public void setId_oggetto(Long id_oggetto) {
        this.id_oggetto = id_oggetto;
    }

    public Long getId_tipo_oggetto() {
        return id_tipo_oggetto;
    }

    public void setId_tipo_oggetto(Long id_tipo_oggetto) {
        this.id_tipo_oggetto = id_tipo_oggetto;
    }
}
