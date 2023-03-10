package it.grupposcai.osamard.rest.request;

public class SearchFornitoreRequest extends CommonAttributeRequest {
    private static final long serialVersionUID = 1L;

    private String ragioneSociale;
    private Long idCategoria;
    private String citta;
    private String orderBy;
    private String orderType;
    private Long numRecordIniziale;
    private Long numRecordDaEstrarre;

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Long getNumRecordIniziale() {
        return numRecordIniziale;
    }

    public void setNumRecordIniziale(Long numRecordIniziale) {
        this.numRecordIniziale = numRecordIniziale;
    }

    public Long getNumRecordDaEstrarre() {
        return numRecordDaEstrarre;
    }

    public void setNumRecordDaEstrarre(Long numRecordDaEstrarre) {
        this.numRecordDaEstrarre = numRecordDaEstrarre;
    }
}
