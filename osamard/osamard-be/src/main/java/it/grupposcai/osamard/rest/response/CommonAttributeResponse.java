package it.grupposcai.osamard.rest.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import it.grupposcai.osamard.util.serializer.CustomerJsonLocalDateTimeSerializable;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CommonAttributeResponse implements Serializable {

    private static final long serialVersionUID = -550256436576674360L;

    private Boolean disabled;
    private Long firstUser;
    private Long lastUserModified;
    @JsonSerialize(using = CustomerJsonLocalDateTimeSerializable.class)
    private LocalDateTime dtInserimento;
    @JsonSerialize(using = CustomerJsonLocalDateTimeSerializable.class)
    private LocalDateTime dtModifica;


    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
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
}
