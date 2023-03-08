package it.grupposcai.osamard.rest.response;

public class ContattoResponse extends CommonAttributeResponse {

    private static final long serialVersionUID = -4822617367801876161L;

    private Long id;
    private String name;
    private String posizione;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }
}