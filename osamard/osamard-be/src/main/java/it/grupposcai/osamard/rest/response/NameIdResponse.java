package it.grupposcai.osamard.rest.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import it.grupposcai.osamard.util.serializer.CustomerJsonLocalDateTimeSerializable;

import java.io.Serializable;
import java.time.LocalDateTime;

public class NameIdResponse extends CommonAttributeResponse implements Serializable {

    private static final long serialVersionUID = -4822617367801876161L;

    private Long id;
    private String name;

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

}