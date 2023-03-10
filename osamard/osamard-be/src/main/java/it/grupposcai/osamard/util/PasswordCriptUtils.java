package it.grupposcai.osamard.util;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class PasswordCriptUtils {
    @SuppressWarnings("unused")
    private static final String _cifrePerEsadecimale = "0123456789abcdef";
    private static Logger log = Logger.getLogger(PasswordCriptUtils.class.getName());


    private static byte[] cripta(byte[] paramArrayOfByte, String paramString) throws NoSuchAlgorithmException {
        MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
        localMessageDigest.reset();
        return localMessageDigest.digest(paramArrayOfByte);
    }

    public static String byteArrayToHexString(byte[] paramArrayOfByte) {
        StringBuffer localStringBuffer = new StringBuffer();
        for (int i = 0; i < paramArrayOfByte.length; i++) {
            int j = paramArrayOfByte[i] & 0xFF;
            localStringBuffer.append("0123456789abcdef".charAt(j / 16));
            localStringBuffer.append("0123456789abcdef".charAt(j % 16));
        }
        return localStringBuffer.toString();
    }

    @SuppressWarnings("unused")
    private static byte[] hexStringToByteArray(String paramString) throws IllegalArgumentException {
        if (paramString.length() % 2 != 0) {
            throw new IllegalArgumentException("Stringa esadecimale non valida, numero di caratteri dispari.");
        }
        byte[] arrayOfByte = new byte[paramString.length() / 2];
        for (int i = 0; i < paramString.length(); i += 2) {
            arrayOfByte[(i / 2)] = ((byte) ("0123456789abcdef".indexOf(paramString.charAt(i)) << 4
                    | "0123456789abcdef".indexOf(paramString.charAt(i + 1))));
        }
        return arrayOfByte;
    }

    protected static String cripta(String paramString1, String paramString2) throws NoSuchAlgorithmException {
        byte[] arrayOfByte = cripta(paramString1.getBytes(), paramString2);
        String str = byteArrayToHexString(arrayOfByte);
        return "{" + paramString2 + "}" + str;
    }

    public static String cripta(String paramString) {
        try {
            return cripta(paramString, "SHA");
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            log.error(
                    "UtilityPerCriptare | cripta(String) | NoSuchAlgorithmException... errore nell'algoritmo di default",
                    localNoSuchAlgorithmException);
        }
        return "";
    }

    public static void main(String args[]) throws Exception {
        String a = cripta("hfuiog7ewg3!few6");
        System.out.println(a);

    }

}
