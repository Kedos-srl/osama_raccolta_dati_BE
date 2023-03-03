package it.grupposcai.osamard.controller;

import it.grupposcai.osamard.rest.request.UtenteRequest;
import it.grupposcai.osamard.rest.response.UtenteResponse;
import it.grupposcai.osamard.rest.response.WarningResponse;
import it.grupposcai.osamard.service.UtenteService;
import it.grupposcai.osamard.util.CommonsUtils;
import it.grupposcai.osamard.util.Const;
import it.grupposcai.osamard.util.JsonUtils;
import it.grupposcai.osamard.util.RESTResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("utente")
public class UtenteController extends AbstractController {

    Logger logger = Logger.getLogger(UtenteController.class);

    @Autowired
    UtenteService utenteService;


    @PostMapping(value = "/login")
    public @ResponseBody
    RESTResponse login(HttpServletRequest httpServletRequest, @RequestBody UtenteRequest request) {

        try {
            logger.debug("--- login--- input request = \n " + JsonUtils.convertObjToJsonString(request));
            List<WarningResponse> warnings = checkInputLogin(request);
            if (warnings.size() > 0) {
                return new RESTResponse(Const.ESITO_KO, warnings, super.getMessageFromSource(Const.LOGIN_FAILED));
            }

            UtenteResponse utenteResponse = utenteService.login(request);

            if (utenteResponse == null) {
                return new RESTResponse(Const.ESITO_KO, null, super.getMessageFromSource(Const.NO_DATA_FOUND));
            }

            String token = AbstractController.generateToken(utenteResponse.getId(), httpServletRequest);
            utenteResponse.setToken(token);
            return new RESTResponse(HttpStatus.OK.name(), utenteResponse, super.getMessageFromSource(Const.LOGIN_SUCCESS));
        } catch (Exception e) {
            return CommonsUtils.printAndReturnError(logger, "login", e);
        }
    }


    @PostMapping(value = "/logout")
    public @ResponseBody
    RESTResponse logout(@RequestBody UtenteRequest request) {

        try {
            logger.debug("--- logout--- input request = \n " + JsonUtils.convertObjToJsonString(request));
            if (super.checkIfTokenIsValid(request.getToken())) {
                super.invalidateSession(request.getToken());
                return new RESTResponse(HttpStatus.OK.name(), null, super.getMessageFromSource(Const.LOGOUT_SUCCESS));
            }
            return new RESTResponse(Const.ESITO_KO, null, super.getMessageFromSource(Const.INVALID_SESSION));

        } catch (Exception e) {
            return CommonsUtils.printAndReturnError(logger, "logout", e);
        }
    }


    private List<WarningResponse> checkInputLogin(UtenteRequest request) {
        List<WarningResponse> warningResponses = new ArrayList<>();

        if (request.getEmail() == null || request.getEmail().equals("")) {
            WarningResponse warningResponse = new WarningResponse("EMAIL", super.getMessageFromSource("required.field"));
            warningResponses.add(warningResponse);
        }
        if (request.getPassword() == null || request.getPassword().equals("")) {
            WarningResponse warningResponse = new WarningResponse("PASSWORD", super.getMessageFromSource("required.field"));
            warningResponses.add(warningResponse);
        }
        return warningResponses;
    }

}
