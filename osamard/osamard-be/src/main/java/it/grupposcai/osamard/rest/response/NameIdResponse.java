package it.grupposcai.osamard.rest.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import it.grupposcai.osamard.util.serializer.CustomerJsonLocalDateTimeSerializable;

import java.io.Serializable;
import java.time.LocalDateTime;

public class NameIdResponse implements Serializable {

    private static final long serialVersionUID = -4822617367801876161L;

    private Long id;
    private String name;
    @JsonSerialize(using = CustomerJsonLocalDateTimeSerializable.class)
    private LocalDateTime dtInserimento;
    @JsonSerialize(using = CustomerJsonLocalDateTimeSerializable.class)
    private LocalDateTime dtModifica;
    private Long firstUser;
    private Long lastUserModified;
    private boolean disabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDtInserimento() {
        return dtInserimento;
    }

    public void setDtInserimento(LocalDateTime dtInserimento) {
        this.dtInserimento = dtInserimento;
    }

    public LocalDateTime getDtModifica() {
        return dtModifica;
    }

    public void setDtModifica(LocalDateTime dtModifica) {
        this.dtModifica = dtModifica;
    }

    public Long getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(Long firstUser) {
        this.firstUser = firstUser;
    }

    public Long getLastUserModified() {
        return lastUserModified;
    }

    public void setLastUserModified(Long lastUserModified) {
        this.lastUserModified = lastUserModified;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}