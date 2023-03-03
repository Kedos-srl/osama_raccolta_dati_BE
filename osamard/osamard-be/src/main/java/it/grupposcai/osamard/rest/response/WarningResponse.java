package it.grupposcai.osamard.rest.response;

public class WarningResponse {

    private String nomeCampo;
    private String descrizione;

    public WarningResponse(String nomeCampo, String descrizione) {
        super();
        this.nomeCampo = nomeCampo;
        this.descrizione = descrizione;
    }


    public String getNomeCampo() {
        return nomeCampo;
    }

    public void setNomeCampo(String nomeCampo) {
        this.nomeCampo = nomeCampo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }


}
