package it.grupposcai.osamard.bean;

public class FornitoreGeolocalizzazione extends CommonsAttribute {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long id_fornitore;
    private String area;
    private String citta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_fornitore() {
        return id_fornitore;
    }

    public void setId_fornitore(Long id_fornitore) {
        this.id_fornitore = id_fornitore;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }
}
