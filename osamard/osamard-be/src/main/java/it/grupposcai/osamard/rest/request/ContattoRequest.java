package it.grupposcai.osamard.rest.request;

public class ContattoRequest extends NameIdRequest {

    private static final long serialVersionUID = 1L;

    public String posizione;

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }
}
