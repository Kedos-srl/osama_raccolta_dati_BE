package it.grupposcai.osamard.service;

import it.grupposcai.osamard.bean.Fornitore;
import it.grupposcai.osamard.rest.request.FornitoreRequest;
import it.grupposcai.osamard.rest.response.FornitoreResponse;
import it.grupposcai.osamard.rest.response.ItemFormResponse;
import it.grupposcai.osamard.rest.response.SearchResponseCommon;

import java.util.List;
import java.util.Map;

public interface FornitoreService {

    List<Fornitore> selectAll();

    Fornitore selectById(Long id);

    ItemFormResponse getItemsForm();

    FornitoreResponse save(FornitoreRequest request);

    FornitoreResponse getById(FornitoreRequest request);

    SearchResponseCommon searchFornitori(Map<String, Object> searchCriteria);
}
