package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.Fornitore;
import it.grupposcai.osamard.rest.response.ItemFormResponse;

import java.util.List;

public interface FornitoreService {

    public Fornitore insert(Fornitore fornitore);

    public Fornitore update(Fornitore fornitore);

    public List<Fornitore> selectAll();

    public List<Fornitore> selectAllEnabled();

    public Fornitore selectById(Fornitore fornitore);


    ItemFormResponse getItemsForm();
}
