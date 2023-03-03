package it.grupposcai.osamard.dao.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Interfaccia che riunisce i metodi toMap e fromMap per permettere ai tre livelli di oggetto (request, bean, response) di implementare l'interfaccia e centralizzare il controllo di questi metodi.
 * Dove è necessario un adattamento la classe che implementa l'interfaccia farà Override del metodo da modificare.
 *
 * @author sbrioschi
 */
public interface ObjectMapping {

    final static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Metodo gemello del metodo in CommonsUtils, messo in questa interfaccia per problemi di visibilità degli utils da questo punto del progetto
     *
     * @param date
     * @return
     */
    private static String convertDateInString(Date date) {
        String dataStr = null;
        if (date != null) {
            dataStr = dateFormat.format(date);
        }
        return dataStr;
    }

    //_________________________________PRIVATE METHODs________________________________//

    /**
     * Metodo gemello del metodo in PasswordCriptUtils, messo in questa interfaccia per problemi di visibilità degli utils da questo punto del progetto
     *
     * @param paramArrayOfByte
     * @param paramString
     * @return
     * @throws NoSuchAlgorithmException
     */
    private byte[] cripta(byte[] paramArrayOfByte, String paramString) throws NoSuchAlgorithmException {
        MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
        localMessageDigest.reset();
        return localMessageDigest.digest(paramArrayOfByte);
    }

    /**
     * Metodo gemello del metodo in PasswordCriptUtils, messo in questa interfaccia per problemi di visibilità degli utils da questo punto del progetto
     *
     * @param paramString
     * @return
     */
    private String cripta(String paramString) {
        try {
            return cripta(paramString, "SHA");
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {

        }
        return "";
    }

    /**
     * Metodo gemello del metodo in PasswordCriptUtils, messo in questa interfaccia per problemi di visibilità degli utils da questo punto del progetto
     *
     * @param paramString1
     * @param paramString2
     * @return
     * @throws NoSuchAlgorithmException
     */
    private String cripta(String paramString1, String paramString2) throws NoSuchAlgorithmException {
        byte[] arrayOfByte = cripta(paramString1.getBytes(), paramString2);
        String str = byteArrayToHexString(arrayOfByte);
        return "{" + paramString2 + "}" + str;
    }

    /**
     * Metodo gemello del metodo in PasswordCriptUtils, messo in questa interfaccia per problemi di visibilità degli utils da questo punto del progetto
     *
     * @param paramArrayOfByte
     * @return
     */
    private String byteArrayToHexString(byte[] paramArrayOfByte) {
        StringBuffer localStringBuffer = new StringBuffer();
        for (int i = 0; i < paramArrayOfByte.length; i++) {
            int j = paramArrayOfByte[i] & 0xFF;
            localStringBuffer.append("0123456789abcdef".charAt(j / 16));
            localStringBuffer.append("0123456789abcdef".charAt(j % 16));
        }
        return localStringBuffer.toString();
    }

    /**
     * Metodo gemello del metodo in CommonsUtils, messo in questa interfaccia per problemi di visibilità degli utils da questo punto del progetto
     *
     * @param dataStr
     * @return
     */
    private Date convertStringInDate(String dataStr) {
        Date date = null;
        if (dataStr != null) {
            try {
                date = dateFormat.parse(dataStr);
            } catch (ParseException e) {
            }
        }
        return date;
    }
}
