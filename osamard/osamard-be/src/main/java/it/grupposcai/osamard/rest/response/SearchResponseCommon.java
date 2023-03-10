package it.grupposcai.osamard.rest.response;

import java.util.List;

public class SearchResponseCommon {
    private static final long serialVersionUID = 1L;

    private Long numRecordTotali;
    private List<Object> responses;

    public Long getNumRecordTotali() {
        return numRecordTotali;
    }

    public void setNumRecordTotali(Long numRecordTotali) {
        this.numRecordTotali = numRecordTotali;
    }

    public List<Object> getResponses() {
        return responses;
    }

    public void setResponses(List<Object> responses) {
        this.responses = responses;
    }
}
