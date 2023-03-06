package it.grupposcai.osamard.bean;

import it.grupposcai.osamard.dao.util.ObjectMapping;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CommonsAttribute implements Serializable, ObjectMapping {

    private static final long serialVersionUID = -4822617367801876161L;

    private LocalDateTime dt_inserimento;
    private LocalDateTime dt_modifica;
    private Long first_user;
    private Long last_user_modified;
    private boolean disabled;

    public LocalDateTime getDt_inserimento() {
        return dt_inserimento;
    }

    public void setDt_inserimento(LocalDateTime dt_inserimento) {
        this.dt_inserimento = dt_inserimento;
    }

    public LocalDateTime getDt_modifica() {
        return dt_modifica;
    }

    public void setDt_modifica(LocalDateTime dt_modifica) {
        this.dt_modifica = dt_modifica;
    }

    public Long getFirst_user() {
        return first_user;
    }

    public void setFirst_user(Long first_user) {
        this.first_user = first_user;
    }

    public Long getLast_user_modified() {
        return last_user_modified;
    }

    public void setLast_user_modified(Long last_user_modified) {
        this.last_user_modified = last_user_modified;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

}