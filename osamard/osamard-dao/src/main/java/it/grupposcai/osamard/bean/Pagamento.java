package it.grupposcai.osamard.bean;

public class Pagamento extends CommonsAttribute {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long id_campione;
    private Long id_produzione;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_campione() {
        return id_campione;
    }

    public void setId_campione(Long id_campione) {
        this.id_campione = id_campione;
    }

    public Long getId_produzione() {
        return id_produzione;
    }

    public void setId_produzione(Long id_produzione) {
        this.id_produzione = id_produzione;
    }
}
