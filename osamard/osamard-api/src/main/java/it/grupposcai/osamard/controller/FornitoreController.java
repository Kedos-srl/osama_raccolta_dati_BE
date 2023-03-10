package it.grupposcai.osamard.controller;

import it.grupposcai.osamard.rest.request.CommonAttributeRequest;
import it.grupposcai.osamard.rest.request.FornitoreRequest;
import it.grupposcai.osamard.rest.request.SearchFornitoreRequest;
import it.grupposcai.osamard.rest.response.FornitoreResponse;
import it.grupposcai.osamard.rest.response.ItemFormResponse;
import it.grupposcai.osamard.rest.response.SearchResponseCommon;
import it.grupposcai.osamard.rest.response.WarningResponse;
import it.grupposcai.osamard.service.FornitoreService;
import it.grupposcai.osamard.service.UtenteService;
import it.grupposcai.osamard.util.CommonsUtils;
import it.grupposcai.osamard.util.Const;
import it.grupposcai.osamard.util.JsonUtils;
import it.grupposcai.osamard.util.RESTResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("fornitore")
public class FornitoreController extends AbstractController {

    Logger logger = Logger.getLogger(FornitoreController.class);


    @Autowired
    FornitoreService fornitoreService;

    @Autowired
    UtenteService utenteService;

    // Inserimento / Modifica
    @PostMapping(value = "/save")
    public @ResponseBody
    RESTResponse save(@RequestBody FornitoreRequest request) {

        try {
            logger.debug("--- save --- input request = \n " + JsonUtils.convertObjToJsonString(request));
            if (!super.checkIfTokenIsValid(request.getToken())) {
                return new RESTResponse(Const.ESITO_KO, null, super.getMessageFromSource(Const.INVALID_SESSION));
            }

            request.setFirstUser(getIdUserFromToken(request.getToken()));
            request.setLastUserModified(getIdUserFromToken(request.getToken()));

            List<WarningResponse> warnings = checkInputFornitoreSave(request);
            if (warnings.size() > 0) {
                return new RESTResponse(Const.ESITO_KO, warnings, super.getMessageFromSource(Const.MISSING_DATA));
            }

            FornitoreResponse resp = fornitoreService.save(request);

            return new RESTResponse(HttpStatus.OK.name(), resp, super.getMessageFromSource(Const.INSERT_OK));
        } catch (Exception e) {
            logger.error("--- save ---  ERROR = \n ", e);
            return CommonsUtils.printAndReturnError(logger, "logout", e);
        }
    }


    @PostMapping(value = "/getById")
    public @ResponseBody
    RESTResponse getById(@RequestBody FornitoreRequest request) {

        try {
            logger.debug("--- getById ---  input request = \n " + JsonUtils.convertObjToJsonString(request));
            if (!super.checkIfTokenIsValid(request.getToken())) {
                return new RESTResponse(Const.ESITO_KO, null, super.getMessageFromSource(Const.INVALID_SESSION));
            }

            List<WarningResponse> warnings = checkInputFornitoreGetById(request);
            if (warnings.size() > 0) {
                return new RESTResponse(Const.ESITO_KO, warnings, super.getMessageFromSource(Const.MISSING_DATA));
            }

            FornitoreResponse resp = fornitoreService.getById(request);

            return new RESTResponse(HttpStatus.OK.name(), resp, super.getMessageFromSource(Const.SEARCH_SUCCESS));
        } catch (Exception e) {
            logger.error("--- getById ---  ERROR = \n ", e);
            return CommonsUtils.printAndReturnError(logger, "logout", e);
        }
    }

    @PostMapping(value = "/searchFornitori")
    public @ResponseBody
    RESTResponse searchFornitori(@RequestBody SearchFornitoreRequest request) {

        try {
            logger.debug("--- searchFornitori ---  input request = \n " + JsonUtils.convertObjToJsonString(request));
            if (!super.checkIfTokenIsValid(request.getToken())) {
                return new RESTResponse(Const.ESITO_KO, null, super.getMessageFromSource(Const.INVALID_SESSION));
            }

            SearchResponseCommon elencoFornitori = fornitoreService.searchFornitori(this.createSearchCriteria(request));

            return new RESTResponse(HttpStatus.OK.name(), elencoFornitori, super.getMessageFromSource(Const.SEARCH_SUCCESS));

        } catch (Exception e) {
            logger.error("--- searchFornitori ---  ERROR = \n ", e);
            return CommonsUtils.printAndReturnError(logger, "logout", e);
        }
    }


    @PostMapping(value = "/getItemsForm")
    public @ResponseBody
    RESTResponse getItemsForm(@RequestBody CommonAttributeRequest request) {
        try {
            logger.debug("--- getItemsForm--- input request = \n " + JsonUtils.convertObjToJsonString(request));
            if (!super.checkIfTokenIsValid(request.getToken())) {
                return new RESTResponse(Const.ESITO_KO, null, super.getMessageFromSource(Const.INVALID_SESSION));
            }

            ItemFormResponse resp = fornitoreService.getItemsForm();

            return new RESTResponse(HttpStatus.OK.name(), resp, super.getMessageFromSource(Const.REQUEST_SUCCESS));
        } catch (Exception e) {
            logger.error("--- getItemsForm ---  ERROR = \n ", e);
            return CommonsUtils.printAndReturnError(logger, "logout", e);
        }
    }


    private Map<String, Object> createSearchCriteria(SearchFornitoreRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();

        if (request.getRagioneSociale() != null) {
            params.put("ragioneSociale", request.getRagioneSociale());
        }

        if (request.getIdCategoria() != null) {
            params.put("idCategoria", request.getIdCategoria());
        }

        if (request.getCitta() != null) {
            params.put("citta", request.getCitta());
        }

        if (request.getDisabled() != null) {
            params.put("disabled", request.getDisabled());
        }

        if (request.getOrderBy() != null && !request.getOrderBy().equals("")) {
            params.put("orderBy", request.getOrderBy());
        } else {
            params.put("orderBy", "dt_inserimento");
        }

        if (request.getOrderType() != null && !request.getOrderType().equals("")) {
            params.put("orderType", request.getOrderType());
        } else {
            //default desc
            params.put("orderType", "desc");
        }

        if (request.getNumRecordIniziale() != null) {
            if (request.getNumRecordIniziale() <= 0)
                params.put("numRecordIniziale", 0);
            else
                params.put("numRecordIniziale", request.getNumRecordIniziale() - 1);
        } else {
            //default 1
            params.put("numRecordIniziale", 0);
        }

        if (request.getNumRecordDaEstrarre() != null && !request.getNumRecordDaEstrarre().equals("")) {
            params.put("numRecordDaEstrarre", request.getNumRecordDaEstrarre());
        } else {
            //default 25
            params.put("numRecordDaEstrarre", 25);
        }

        return params;
    }


    private List<WarningResponse> checkInputFornitoreSave(FornitoreRequest request) {
        List<WarningResponse> warningResponses = new ArrayList<>();

        //TODO Aggiungere campi obbligatori

//        if (request.getEmail() == null || request.getEmail().equals("")) {
//            WarningResponse warningResponse = new WarningResponse("EMAIL", super.getMessageFromSource("required.field"));
//            warningResponses.add(warningResponse);
//        }
//        if (request.getPassword() == null || request.getPassword().equals("")) {
//            WarningResponse warningResponse = new WarningResponse("PASSWORD", super.getMessageFromSource("required.field"));
//            warningResponses.add(warningResponse);
//        }
        return warningResponses;
    }

    private List<WarningResponse> checkInputFornitoreGetById(FornitoreRequest request) {
        List<WarningResponse> warningResponses = new ArrayList<>();

        if (request.getId() == null || request.getId().equals("")) {
            WarningResponse warningResponse = new WarningResponse("id", super.getMessageFromSource("required.field"));
            warningResponses.add(warningResponse);
        }

        return warningResponses;
    }

}
