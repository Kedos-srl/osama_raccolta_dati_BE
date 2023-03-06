package it.grupposcai.osamard.rest.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import it.grupposcai.osamard.dao.util.ObjectMapping;
import it.grupposcai.osamard.util.deserializer.CustomerJsonLocalDateTimeDeserializable;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CommonAttributeRequest implements Serializable, ObjectMapping {

    private static final long serialVersionUID = -550256436576674360L;

    private String token;
    private String language;
    private Boolean disabled;
    private Long firstUser;
    private Long lastUserModified;
    @JsonDeserialize(using = CustomerJsonLocalDateTimeDeserializable.class)
    private LocalDateTime dtInserimento;
    @JsonDeserialize(using = CustomerJsonLocalDateTimeDeserializable.class)
    private LocalDateTime dtModifica;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

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
