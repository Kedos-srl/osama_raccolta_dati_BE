package it.grupposcai.osamard.controller;

import it.grupposcai.osamard.filter.SessionListener;
import it.grupposcai.osamard.util.TokenCriptUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;


public class AbstractController {

    @Value("${pathWebApp}")
    public String pathWebApp;
    @Value("${file.path.external}")
    public String basePathUpload;
    @Value("${file.path.external}")
    public String basePathImage;
    @Value("${dominioSito}")
    public String dominioSito;
    @Autowired
    protected MessageSource messageSource;
    Logger logger = Logger.getLogger(AbstractController.class);

    public static String generateToken(Long id, HttpServletRequest request) throws Exception {

        HttpSession httpSession = request.getSession(false);
        if (httpSession != null && !httpSession.isNew()) {
            httpSession.invalidate();
        }

        String token = request.getSession(true).getId() + "|" + id;
        return TokenCriptUtils.encrypt(token);
    }

    public static Long getIdUserFromToken(String token) throws Exception {
        String tokenDecrittato = TokenCriptUtils.decrypt(token);
        String[] arrayToken = tokenDecrittato.split("\\|");
        return Long.decode(arrayToken[1]);
    }

    public String getPathImageHeader() {
        return pathWebApp + "/images/logo.png";
    }

    public String getMessageFromSource(String code) {
        return getMessage(code, null, new Locale("IT"));
    }

    /**
     * Get message
     */
    protected String getMessage(String code, Object[] args, Locale locale) {
        return messageSource.getMessage(code, args, locale);
    }

    public void invalidateSession(String tokenCriptato) throws Exception {
        String decript = TokenCriptUtils.decrypt(tokenCriptato);
        String[] arr = decript.split("\\|");
        String sessionId = arr[0];
        HttpSession httpSession = SessionListener.getSession(sessionId);
        httpSession.invalidate();
    }


    public boolean checkIfTokenIsValid(String tokenCriptato) throws Exception {
        boolean isValid = false;
        try {
            String decript = TokenCriptUtils.decrypt(tokenCriptato);
            String[] arr = decript.split("\\|");
            String sessionId = arr[0];

            HttpSession httpSession = SessionListener.getSession(sessionId);

            if (httpSession != null) {
                if (httpSession.getId() != null && httpSession.getId().equals(sessionId)) {
                    isValid = true;
                }
            }
        } catch (Exception e) {
            logger.error("Sessione invalida");
            e.printStackTrace();
        }
        return isValid;
    }
}
