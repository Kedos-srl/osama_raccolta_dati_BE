package it.grupposcai.osamard.bean;

public class Prodotto extends CommonsAttribute {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String cod_articolo;

    private Long id_materiale;
    private Long id_dimensioni;
    private Long id_moq;
    private Long id_prezzo;
    private Long id_fornitore;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCod_articolo() {
        return cod_articolo;
    }

    public void setCod_articolo(String cod_articolo) {
        this.cod_articolo = cod_articolo;
    }

    public Long getId_materiale() {
        return id_materiale;
    }

    public void setId_materiale(Long id_materiale) {
        this.id_materiale = id_materiale;
    }

    public Long getId_dimensioni() {
        return id_dimensioni;
    }

    public void setId_dimensioni(Long id_dimensioni) {
        this.id_dimensioni = id_dimensioni;
    }

    public Long getId_moq() {
        return id_moq;
    }

    public void setId_moq(Long id_moq) {
        this.id_moq = id_moq;
    }

    public Long getId_prezzo() {
        return id_prezzo;
    }

    public void setId_prezzo(Long id_prezzo) {
        this.id_prezzo = id_prezzo;
    }

    public Long getId_fornitore() {
        return id_fornitore;
    }

    public void setId_fornitore(Long id_fornitore) {
        this.id_fornitore = id_fornitore;
    }
}
