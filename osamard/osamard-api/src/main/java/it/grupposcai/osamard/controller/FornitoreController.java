package it.grupposcai.osamard.controller;

import it.grupposcai.osamard.rest.request.CommonAttributeRequest;
import it.grupposcai.osamard.rest.request.FornitoreRequest;
import it.grupposcai.osamard.rest.request.SearchFornitoreRequest;
import it.grupposcai.osamard.rest.response.FornitoreResponse;
import it.grupposcai.osamard.rest.response.ItemFormResponse;
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
            return CommonsUtils.printAndReturnError(logger, "logout", e);
        }
    }

//
//    // getById
//    @RequestMapping(value = "/getById", method = RequestMethod.POST)
//    public @ResponseBody
//    RESTResponse getById(@RequestBody FornitoreRequest request) {
//
//        try {
//            logger.debug("--- getById ---  input request = \n " + JsonUtils.convertObjToJsonString(request));
//            if (super.checkIfTokenIsValid(request.getToken())) {
//
//                Long idUser = super.getIdUserFromToken(request.getToken());
//
//                if (utenteService.isAutorizzato(idUser, Const.TipoServizio.MODIFY)) {
//
//                    FornitoreResponse response = new FornitoreResponse();
//
//                    Fornitore fornitore = new Fornitore();
//                    fornitore.setId(request.getIdFornitore());
//                    fornitore = fornitoreService.selectById(fornitore);
//
//                    if (fornitore != null) {
//
//                        FornitoreSubcategoria subcategoria = new FornitoreSubcategoria();
//                        subcategoria.setId_subcategoria(fornitore.getId_subcategoria());
//                        subcategoria = fornitoreSubcategoriaService.selectById(subcategoria);
//
//                        FornitoreCategoria categoria = new FornitoreCategoria();
//                        categoria.setId(fornitore.getId());
//                        categoria = fornitoreCategoriaService.selectById(categoria);
//
//                        List<FornitoreMultilingua> zonaLinguaList = null;
//
//                        zonaLinguaList = fornitoreService.selectAllByIdFornitore(fornitore.getId());
//                        response = ConversionResponseUtils.convertFornitoretoFornitoreResponse(fornitore, zonaLinguaList);
//
//
//                    } else {
//
//                        List<FornitoreMultilinguaResponse> elencoMultilingua = new ArrayList<FornitoreMultilinguaResponse>();
//                        List<Lingua> lingueAbilitate = linguaService.getAllEnabledBackoffice();
//
//                        for (Lingua lingua : lingueAbilitate) {
//                            FornitoreMultilinguaResponse ssmr = new FornitoreMultilinguaResponse();
//                            ssmr.setCdLingua(lingua.getCd_lingua());
//                            ssmr.setLinguaDefault(lingua.isFlg_default());
//
//                            if (ssmr.getDescrizione() != null) {
//                                //niente
//                            } else {
//                                if (lingua.isFlg_default()) {
//                                    ssmr.setDisabled(false);
//                                } else {
//                                    ssmr.setDisabled(true);
//                                }
//                            }
//
//                            elencoMultilingua.add(ssmr);
//                        }
//
//                        response = new FornitoreResponse();
//                        response.setElencoMultilingua(elencoMultilingua);
//
//                    }
//
//                    return new RESTResponse(HttpStatus.OK.name(), response, super.getMessageFromSource(Const.SEARCH_SUCCESS, request.getLanguage()));
//                } else {
//                    return new RESTResponse(Const.ESITO_KO, null, super.getMessageFromSource(Const.UNAUTHORIZED, request.getLanguage()));
//                }
//
//            } else {
//                return new RESTResponse(Const.ESITO_KO, null, super.getMessageFromSource(Const.INVALID_SESSION, request.getLanguage()));
//            }
//
//        } catch (Exception e) {
//            return CommonsUtils.printAndReturnError(logger, "getById", e);
//        }
//
//    }
//
//
//    @RequestMapping(value = "/searchFornitori", method = RequestMethod.POST)
//    public @ResponseBody
//    RESTResponse searchUtentiPerProfilo(@RequestBody SearchFornitoreRequest request) {
//
//        try {
//            logger.debug("--- searchFornitori---  input request = \n " + JsonUtils.convertObjToJsonString(request));
//            if (super.checkIfTokenIsValid(request.getToken())) {
//
//                Long idUser = super.getIdUserFromToken(request.getToken());
//
//                if (utenteService.isAutorizzato(idUser, Const.TipoServizio.LIST)) {
//
//
//                    Map<Long, String> categorie = new HashMap<Long, String>();
//                    Map<Long, String> subcategorie = new HashMap<Long, String>();
//
//
//                    List<FornitoreCategoria> listCategorie = fornitoreCategoriaService.selectAll();
//
//                    if (listCategorie != null && listCategorie.size() > 0) {
//                        for (FornitoreCategoria fc : listCategorie) {
//                            FornitoreCategoriaMultilingua fcm = new FornitoreCategoriaMultilingua();
//                            fcm = fornitoreCategoriaService.selectByIdAndLanguage(fc.getId(), "IT");
//                            if (fcm != null)
//                                categorie.put(fc.getId(), fcm.getTitolo());
//                        }
//                    }
//
//                    List<FornitoreSubcategoria> listSubcategorie = fornitoreSubcategoriaService.selectAll();
//
//                    if (listSubcategorie != null && listSubcategorie.size() > 0) {
//                        for (FornitoreSubcategoria fsc : listSubcategorie) {
//                            FornitoreSubcategoriaMultilingua fsm = new FornitoreSubcategoriaMultilingua();
//                            fsm = fornitoreSubcategoriaService.selectByIdAndLanguage(fsc.getId_subcategoria(), "IT");
//                            if (fsm != null)
//                                subcategorie.put(fsc.getId_subcategoria(), fsm.getTitolo());
//                        }
//                    }
//
//                    List<Fornitore> elencoFornitori = fornitoreService.searchFornitori(this.createSearchCriteria(request));
//
//                    SearchFornitoreResponse out = new SearchFornitoreResponse();
//
//                    if (elencoFornitori != null && elencoFornitori.size() > 0) {
//
//                        List<FornitoreResponse> fornitori = ConversionResponseUtils.convertFornitoreResponseList(elencoFornitori, categorie, subcategorie);
//
//                        for (FornitoreResponse fornitore : fornitori) {
//
//                            List<LinguaCompilataResponse> lingueCompilate = new ArrayList<LinguaCompilataResponse>();
//
//                            if (fornitore != null) {
//                                List<FornitoreMultilingua> fml = new ArrayList<FornitoreMultilingua>();
//
//                                fml = fornitoreService.selectAllByIdFornitore(fornitore.getIdFornitore());
//
//                                for (FornitoreMultilingua fm : fml) {
//
//                                    if (fm != null) {
//                                        LinguaCompilataResponse lcr = new LinguaCompilataResponse();
//                                        lcr.setCdLingua(fm.getCd_lingua());
//                                        if (fm.getDescrizione() != null) {
//                                            lcr.setCompilata(!fm.isDisabled());
//                                        } else {
//                                            lcr.setCompilata(false);
//                                        }
//                                        lingueCompilate.add(lcr);
//                                    }
//                                }
//
//                                fornitore.setLingueCompilate(lingueCompilate);
//                            }
//
//
//                        }
//
//                        out.setFornitori(fornitori);
//
//                        out.setNumRecordTotali(fornitoreService.countFornitori(this.createSearchCriteria(request)));
//
//                        return new RESTResponse(HttpStatus.OK.name(), out, super.getMessageFromSource(Const.SEARCH_SUCCESS, request.getLanguage()));
//                    } else {
//                        return new RESTResponse(HttpStatus.OK.name(), null, super.getMessageFromSource(Const.NO_DATA_FOUND, request.getLanguage()));
//                    }
//
//                } else {
//                    return new RESTResponse(Const.ESITO_KO, null, super.getMessageFromSource(Const.UNAUTHORIZED, request.getLanguage()));
//                }
//
//            } else {
//                return new RESTResponse(Const.ESITO_KO, null, super.getMessageFromSource(Const.INVALID_SESSION, request.getLanguage()));
//            }
//        } catch (Exception e) {
//            return CommonsUtils.printAndReturnError(logger, "searchFornitori", e);
//        }
//
//    }
//

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
            return CommonsUtils.printAndReturnError(logger, "logout", e);
        }
    }


    @SuppressWarnings("unlikely-arg-type")
    private Map<String, Object> createSearchCriteria(SearchFornitoreRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();

        if (request.getTipologia() != null) {
            params.put("tipologia", request.getTipologia());
        }

        if (!StringUtils.isEmpty(request.getRagioneSociale())) {
            params.put("ragione_sociale", request.getRagioneSociale().replaceAll("'", "''"));
        }


        if (request.getDisabled() != null) {
            params.put("disabled", request.getDisabled());
        }

        if (request.getOrderBy() != null && !request.getOrderBy().equals("")) {
            params.put("orderBy", request.getOrderBy());
        } else {
            //default remail
            params.put("orderBy", "ragione_sociale");
        }

        if (request.getOrderType() != null && !request.getOrderType().equals("")) {
            params.put("orderType", request.getOrderType());
        } else {
            //default asc
            params.put("orderType", "asc");
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

        //TODO ZAMMA Aggiungere campi obbligatori

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

}
