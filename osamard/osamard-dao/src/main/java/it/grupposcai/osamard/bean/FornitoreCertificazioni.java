package it.grupposcai.osamard.bean;

public class FornitoreCertificazioni extends CommonsAttribute {

    private static final long serialVersionUID = 1L;

    private Long id_fornitore;
    private Long id_certificazione;

    public Long getId_fornitore() {
        return id_fornitore;
    }

    public void setId_fornitore(Long id_fornitore) {
        this.id_fornitore = id_fornitore;
    }

    public Long getId_certificazione() {
        return id_certificazione;
    }

    public void setId_certificazione(Long id_certificazione) {
        this.id_certificazione = id_certificazione;
    }
}
