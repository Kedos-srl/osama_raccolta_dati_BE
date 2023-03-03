package it.grupposcai.osamard.util;


import org.apache.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;

public class CommonsUtils {


    public final static Map<String, Integer> myMap = new HashMap<String, Integer>();
    public final static Map<Integer, String> myMapMounthDescription = new HashMap<Integer, String>();

    static {
        myMap.put("GENNAIO", 0);
        myMap.put("FEBBRAIO", 1);
        myMap.put("MARZO", 2);
        myMap.put("APRILE", 3);
        myMap.put("MAGGIO", 4);
        myMap.put("GIUGNO", 5);
        myMap.put("LUGLIO", 6);
        myMap.put("AGOSTO", 7);
        myMap.put("SETTEMBRE", 8);
        myMap.put("OTTOBRE", 9);
        myMap.put("NOVEMBRE", 10);
        myMap.put("DICEMBRE", 11);
    }

    static {
        myMapMounthDescription.put(1, "GENNAIO");
        myMapMounthDescription.put(2, "FEBBRAIO");
        myMapMounthDescription.put(3, "MARZO");
        myMapMounthDescription.put(4, "APRILE");
        myMapMounthDescription.put(5, "MAGGIO");
        myMapMounthDescription.put(6, "GIUGNO");
        myMapMounthDescription.put(7, "LUGLIO");
        myMapMounthDescription.put(8, "AGOSTO");
        myMapMounthDescription.put(9, "SETTEMBRE");
        myMapMounthDescription.put(10, "OTTOBRE");
        myMapMounthDescription.put(11, "NOVEMBRE");
        myMapMounthDescription.put(12, "DICEMBRE");
    }

    public static RESTResponse printAndReturnError(Logger logger, String method, Exception e) {
        String strErrore = method + " ERRORE :";
        logger.error(strErrore + e.toString());
        logger.error(strErrore + e.getLocalizedMessage());
        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));
        logger.error(strErrore + "   XXXXXXX   " + errors.toString());
        return new RESTResponse(Const.ESITO_KO, e.getLocalizedMessage(), Const.SERVER_ERROR);
    }

    //utilizzato per generae lo slug e per rinominare gli allegati e le immagini con un nome pulito
    public static String ripulisciTesto(String testo) throws UnsupportedEncodingException {
        if (testo == null) {
            return "";
        }

        testo = testo.replaceAll("\\\\", "");
        testo = testo.replaceAll("\\(", "");
        testo = testo.replaceAll("\\)", "");
        testo = testo.replaceAll("<br/>", "-");
        testo = testo.replaceAll(" ", "-");
        testo = testo.replaceAll("[':;!.,&]", "");
        testo = testo.replaceAll("['\\':;?!.,'&’()/|^+\"#<>]", ""); //Aggiunto a seguito di export seo per htaccess
        testo = unaccent(testo);

        testo = testo.toLowerCase();
        testo = testo.replaceAll("[-]+", "-");
        testo = URLEncoder.encode(testo, "UTF-8");
        return testo;
    }

    private static String unaccent(String src) {
        return Normalizer
                .normalize(src, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }

}
