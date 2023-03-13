package it.grupposcai.osamard.controller;

import it.grupposcai.osamard.rest.request.FotoRequest;
import it.grupposcai.osamard.rest.response.FotoResponse;
import it.grupposcai.osamard.rest.response.WarningResponse;
import it.grupposcai.osamard.service.FornitoreService;
import it.grupposcai.osamard.service.FotoService;
import it.grupposcai.osamard.service.ProdottoService;
import it.grupposcai.osamard.util.CommonsUtils;
import it.grupposcai.osamard.util.Const;
import it.grupposcai.osamard.util.JsonUtils;
import it.grupposcai.osamard.util.RESTResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("foto")
public class FotoController extends AbstractController {

    Logger logger = Logger.getLogger(FotoController.class);


    @Autowired
    FotoService fotoService;
    @Autowired
    FornitoreService fornitoreService;
    @Autowired
    ProdottoService prodottoService;

    @PostMapping(value = "/save")
    public @ResponseBody
    RESTResponse save(@RequestBody FotoRequest request) {

        try {
            logger.debug("--- save --- input request = \n " + JsonUtils.convertObjToJsonString(request));
            if (!super.checkIfTokenIsValid(request.getToken())) {
                return new RESTResponse(Const.ESITO_KO, null, super.getMessageFromSource(Const.INVALID_SESSION));
            }

            request.setFirstUser(getIdUserFromToken(request.getToken()));
            request.setLastUserModified(getIdUserFromToken(request.getToken()));

            List<WarningResponse> warnings = checkInputFotoSave(request);
            if (warnings.size() > 0) {
                return new RESTResponse(Const.ESITO_KO, warnings, super.getMessageFromSource(Const.MISSING_DATA));
            }

            FotoResponse resp = fotoService.save(request);

            return new RESTResponse(HttpStatus.OK.name(), resp, super.getMessageFromSource(Const.INSERT_OK));
        } catch (Exception e) {
            logger.error("--- save ---  ERROR = \n ", e);
            return CommonsUtils.printAndReturnError(logger, "logout", e);
        }
    }

    @PostMapping(value = "/delete")
    public @ResponseBody
    RESTResponse delete(@RequestBody FotoRequest request) {

        try {
            logger.debug("--- delete --- input request = \n " + JsonUtils.convertObjToJsonString(request));
            if (!super.checkIfTokenIsValid(request.getToken())) {
                return new RESTResponse(Const.ESITO_KO, null, super.getMessageFromSource(Const.INVALID_SESSION));
            }

            List<WarningResponse> warnings = checkDeleteFotoSave(request);
            if (warnings.size() > 0) {
                return new RESTResponse(Const.ESITO_KO, warnings, super.getMessageFromSource(Const.MISSING_DATA));
            }

            fotoService.delete(request);

            return new RESTResponse(HttpStatus.OK.name(), null, super.getMessageFromSource(Const.DELETE_SUCCESS));
        } catch (Exception e) {
            logger.error("--- delete ---  ERROR = \n ", e);
            return CommonsUtils.printAndReturnError(logger, "logout", e);
        }
    }

    private List<WarningResponse> checkInputFotoSave(FotoRequest request) {
        List<WarningResponse> warningResponses = new ArrayList<>();

        if (request.getTitolo() == null || request.getTitolo().equals("")) {
            WarningResponse warningResponse = new WarningResponse("Titolo", super.getMessageFromSource("required.field"));
            warningResponses.add(warningResponse);
        }
        if (request.getIdOggetto() == null || request.getIdOggetto() < 1) {
            WarningResponse warningResponse = new WarningResponse("idOggetto", super.getMessageFromSource("required.field"));
            warningResponses.add(warningResponse);
        }
        if (request.getIdTipoOggetto() == null || request.getIdTipoOggetto() < 1) {
            WarningResponse warningResponse = new WarningResponse("idOggettoTipoOggetto", super.getMessageFromSource("required.field"));
            warningResponses.add(warningResponse);
        }
        if (request.getFoto() == null || request.getFoto().trim().equals("")) {
            WarningResponse warningResponse = new WarningResponse("foto", super.getMessageFromSource("required.field"));
            warningResponses.add(warningResponse);
        }

        if (request.getIdTipoOggetto() != null && (request.getIdTipoOggetto() < 1 || request.getIdTipoOggetto() > 2)) {
            WarningResponse warningResponse = new WarningResponse("idOggettoTipoOggetto", super.getMessageFromSource("no.data.found"));
            warningResponses.add(warningResponse);
        } else {
            if (request.getIdOggetto() != null && request.getIdOggetto() > 1) {
                if (request.getIdTipoOggetto() == Const.Oggetto.FORNITORE) {
                    if (fornitoreService.selectById(request.getIdOggetto()) == null) {
                        WarningResponse warningResponse = new WarningResponse("idOggetto", super.getMessageFromSource("no.data.found"));
                        warningResponses.add(warningResponse);
                    }
                } else if (request.getIdTipoOggetto() == Const.Oggetto.PRODOTTO) {
                    if (prodottoService.getProdottoById(request.getIdOggetto()) == null) {
                        WarningResponse warningResponse = new WarningResponse("idOggetto", super.getMessageFromSource("no.data.found"));
                        warningResponses.add(warningResponse);
                    }
                }
            }
        }

        return warningResponses;
    }

    private List<WarningResponse> checkDeleteFotoSave(FotoRequest request) {
        List<WarningResponse> warningResponses = new ArrayList<>();


        if (request.getId() == null || request.getId() < 1) {
            WarningResponse warningResponse = new WarningResponse("idOggetto", super.getMessageFromSource("required.field"));
            warningResponses.add(warningResponse);
        }
        if (request.getIdOggetto() == null || request.getIdOggetto() < 1) {
            WarningResponse warningResponse = new WarningResponse("idOggetto", super.getMessageFromSource("required.field"));
            warningResponses.add(warningResponse);
        }
        if (request.getIdTipoOggetto() == null || request.getIdTipoOggetto() < 1) {
            WarningResponse warningResponse = new WarningResponse("idOggettoTipoOggetto", super.getMessageFromSource("required.field"));
            warningResponses.add(warningResponse);
        }

        if (request.getIdTipoOggetto() != null && (request.getIdTipoOggetto() < 1 || request.getIdTipoOggetto() > 2)) {
            WarningResponse warningResponse = new WarningResponse("idOggettoTipoOggetto", super.getMessageFromSource("no.data.found"));
            warningResponses.add(warningResponse);
        } else {
            if (request.getIdOggetto() != null && request.getIdOggetto() > 1) {
                if (request.getIdTipoOggetto() == Const.Oggetto.FORNITORE) {
                    if (fornitoreService.selectById(request.getIdOggetto()) == null) {
                        WarningResponse warningResponse = new WarningResponse("idOggetto", super.getMessageFromSource("no.data.found"));
                        warningResponses.add(warningResponse);
                    }
                } else if (request.getIdTipoOggetto() == Const.Oggetto.PRODOTTO) {
                    if (prodottoService.getProdottoById(request.getIdOggetto()) == null) {
                        WarningResponse warningResponse = new WarningResponse("idOggetto", super.getMessageFromSource("no.data.found"));
                        warningResponses.add(warningResponse);
                    }
                }
            }
        }

        return warningResponses;
    }

}
