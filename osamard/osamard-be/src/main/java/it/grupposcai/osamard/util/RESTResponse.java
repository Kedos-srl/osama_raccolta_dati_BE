package it.grupposcai.osamard.util;

import java.io.Serializable;

public class RESTResponse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String esito;
    private String descrizione;
    private Object result;


    public RESTResponse(String esito, Object result, String descrizione) {
        this.esito = esito;
        this.result = result;
        this.descrizione = descrizione;
    }

    public String getEsito() {
        return esito;
    }

    public void setEsito(String esito) {
        this.esito = esito;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
