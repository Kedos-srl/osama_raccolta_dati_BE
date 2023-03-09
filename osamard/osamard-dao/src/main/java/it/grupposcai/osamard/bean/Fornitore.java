package it.grupposcai.osamard.bean;

public class Fornitore extends CommonsAttribute {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String ragione_sociale;
    private String tempo_mercato;
    private String fat_tot;
    private String fat_it;
    private Long numero_dipendenti;
    private Boolean rd_interno;
    private Long id_trading;
    private Long id_contatto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRagione_sociale() {
        return ragione_sociale;
    }

    public void setRagione_sociale(String ragione_sociale) {
        this.ragione_sociale = ragione_sociale;
    }

    public String getTempo_mercato() {
        return tempo_mercato;
    }

    public void setTempo_mercato(String tempo_mercato) {
        this.tempo_mercato = tempo_mercato;
    }

    public String getFat_tot() {
        return fat_tot;
    }

    public void setFat_tot(String fat_tot) {
        this.fat_tot = fat_tot;
    }

    public String getFat_it() {
        return fat_it;
    }

    public void setFat_it(String fat_it) {
        this.fat_it = fat_it;
    }

    public Long getNumero_dipendenti() {
        return numero_dipendenti;
    }

    public void setNumero_dipendenti(Long numero_dipendenti) {
        this.numero_dipendenti = numero_dipendenti;
    }

    public Boolean getRd_interno() {
        return rd_interno;
    }

    public void setRd_interno(Boolean rd_interno) {
        this.rd_interno = rd_interno;
    }

    public Long getId_trading() {
        return id_trading;
    }

    public void setId_trading(Long id_trading) {
        this.id_trading = id_trading;
    }

    public Long getId_contatto() {
        return id_contatto;
    }

    public void setId_contatto(Long id_contatto) {
        this.id_contatto = id_contatto;
    }
}
