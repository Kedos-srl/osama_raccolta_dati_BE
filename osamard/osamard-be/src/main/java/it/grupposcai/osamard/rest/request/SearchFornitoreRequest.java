package it.grupposcai.osamard.rest.request;

public class SearchFornitoreRequest extends CommonAttributeRequest {
    private static final long serialVersionUID = 1L;

    private String ragioneSociale;
    private String tipologia;
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

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }


}
