package it.grupposcai.osamard.rest.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import it.grupposcai.osamard.util.CustomerJsonDateDeserializable;

import java.util.Date;

public class UtenteRequest extends CommonAttributeRequest {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    @JsonDeserialize(using = CustomerJsonDateDeserializable.class)
    private Date dtAttivazione;
    @JsonDeserialize(using = CustomerJsonDateDeserializable.class)
    private Date dtScadenza;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDtAttivazione() {
        return dtAttivazione;
    }

    public void setDtAttivazione(Date dtAttivazione) {
        this.dtAttivazione = dtAttivazione;
    }

    public Date getDtScadenza() {
        return dtScadenza;
    }

    public void setDtScadenza(Date dtScadenza) {
        this.dtScadenza = dtScadenza;
    }
}
