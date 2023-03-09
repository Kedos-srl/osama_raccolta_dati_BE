package it.grupposcai.osamard.rest.request;

public class FornitoreGeolocalizzazioneRequest extends CommonAttributeRequest {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idFornitore;
    private String area;
    private String citta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdFornitore() {
        return idFornitore;
    }

    public void setIdFornitore(Long idFornitore) {
        this.idFornitore = idFornitore;
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
