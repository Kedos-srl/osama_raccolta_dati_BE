package it.grupposcai.osamard.controller;

import it.grupposcai.osamard.service.FornitoreService;
import it.grupposcai.osamard.service.UtenteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("fornitore")
public class FornitoreController extends AbstractController {

    Logger logger = Logger.getLogger(FornitoreController.class);


}
