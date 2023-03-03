package it.grupposcai.osamard.filter;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class SessionListener implements HttpSessionListener {

    private static Logger logger = Logger.getLogger(SessionListener.class);

    /**
     * Attributes
     */
    private static Map<String, HttpSession> registry = Collections.synchronizedMap(new HashMap<String, HttpSession>());

    public static HttpSession getSession(String sessionId) {
        if (sessionId != null) {
            /** Loop session in registry */
            synchronized (registry) {
                Iterator<HttpSession> itRegistry = registry.values().iterator();
                while (itRegistry.hasNext()) {
                    HttpSession sessionRegistry = (HttpSession) itRegistry.next();
                    if (sessionRegistry != null) {
                        if (sessionRegistry.getId().equals(sessionId))
                            return sessionRegistry;
                    }
                }
            }

        }
        return null;
    }

    /**
     * Session created
     */
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        registry.put(session.getId(), session);
        logger.info("CREATED SESSION " + session.getId());
        logger.info("Sessioni attive: " + registry.size() + ".");
    }

    /**
     * Session destroyed
     */
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        registry.remove(session.getId());
        logger.info("DESTROYED SESSION " + session.getId());
        logger.info("Sessioni attive: " + registry.size() + ".");
    }


}
