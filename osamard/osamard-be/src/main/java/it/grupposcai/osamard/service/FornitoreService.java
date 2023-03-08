package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.Fornitore;
import it.grupposcai.osamard.rest.request.FornitoreRequest;
import it.grupposcai.osamard.rest.response.FornitoreResponse;
import it.grupposcai.osamard.rest.response.ItemFormResponse;

import java.util.List;

public interface FornitoreService {

    public List<Fornitore> selectAll();

    public List<Fornitore> selectAllEnabled();

    public Fornitore selectById(Fornitore fornitore);

    ItemFormResponse getItemsForm();

    FornitoreResponse save(FornitoreRequest request);

}
