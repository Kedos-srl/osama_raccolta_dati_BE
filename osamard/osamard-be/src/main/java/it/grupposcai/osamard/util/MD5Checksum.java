package it.grupposcai.osamard.util;

import org.apache.log4j.Logger;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Checksum {

    private static Logger log = Logger.getLogger(MD5Checksum.class.getName());

    /**
     * Dato un File calcola il codice checksum usando l'algoritmo MD5.<br>
     *
     * @param filename nome del file di cui calcolare il checksum
     * @return restituisce il codice di checksum
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws Exception                se il nome del file non è valido
     */
    public static String getMD5Checksum(String filename) throws FileNotFoundException, NoSuchAlgorithmException,
            IOException {
        if (filename == null || filename.trim().equalsIgnoreCase(""))
            throw new FileNotFoundException("nome del file non valido :\"" + filename + "\"");
        byte[] b = createChecksum(filename);
        String result = "";
        for (int i = 0; i < b.length; i++) {
            result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }

    private static byte[] createChecksum(String filename) throws NoSuchAlgorithmException, IOException {
        InputStream fis;
        try {
            fis = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("nome del file non valido :\"" + filename + "\"");
        }

        byte[] buffer = new byte[1024];
        MessageDigest complete = MessageDigest.getInstance("MD5");
        int numRead;
        do {
            numRead = fis.read(buffer);
            if (numRead > 0) {
                complete.update(buffer, 0, numRead);
            }
        } while (numRead != -1);
        fis.close();
        return complete.digest();
    }

    /**
     * Dato un File calcola il codice checksum usando l'algoritmo MD5 e lo
     * compara con il codice presente nel file checkFilename.<br>
     *
     * @param filename      nome del file di cui calcolare il checksum.
     * @param checkFilename nome del file contenente il codice checksum da confrontare.
     * @return restituisce true se il checksum di filename e quello passato
     * checkFile sono uguali
     */
    public static boolean check(String filename, String checkFilename) {
        boolean rc = false;
        try {
            String stringChkFile = readFileAsString(checkFilename);
            String md5Checksum = getMD5Checksum(filename);
            if (md5Checksum.equals(stringChkFile))
                rc = true;
        } catch (Exception e) {
            log.error("", e);
        }
        return rc;
    }

    private static String readFileAsString(String filePath) throws java.io.IOException {
        StringBuffer fileData = new StringBuffer(1000);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }
        reader.close();
        return fileData.toString();
    }


    /**
     * Dato un File crea un file con lo stesso nome ed estensione .chk
     * contenente il codice checksum usando l'algoritmo MD5
     *
     * @param filename   nome del file di cui calcolare il checksum.
     * @param estensione estensione del file check.
     * @return restituisce il nome del file check.
     */
    public static String createChecksumFile(String filename, String estensione) throws IOException, Exception {
        File fileCHK = new File(filename + "." + estensione);
        OutputStream os = new FileOutputStream(fileCHK);
        os.write(getMD5Checksum(filename).getBytes());
        os.close();
        return fileCHK.getAbsolutePath();
    }

    /**
     * Dato un File crea un file con lo stesso nome ed estensione .chk
     * contenente il codice checksum usando l'algoritmo MD5
     *
     * @param filename nome del file di cui calcolare il checksum.
     * @return restituisce il nome del file .chk.
     */
    public static String createChecksumFile(String filename) throws IOException, Exception {
        return createChecksumFile(filename, "chk");
    }

    /**
     * Dati due file ne calcola il codice checksum usando l'algoritmo MD5 e li
     * confronta
     *
     * @param firstFilename  nome del primo file.
     * @param secondFilename nome del secondo file.
     * @return true se il checksum dei due file è uguale.
     * @throws Exception if the checksum of the two files are not equals.
     */
    public static boolean compareChecksumOfFiles(String firstFilename, String secondFilename) throws Exception,
            FileNotFoundException, IOException {

        String expectedMD5Checksum = getMD5Checksum(firstFilename);
        String actualMD5Checksum = getMD5Checksum(secondFilename);
        if (!actualMD5Checksum.equals(expectedMD5Checksum))
            throw new Exception("The checksum of file " + firstFilename + "[" + expectedMD5Checksum
                    + "] and the checksum of file " + secondFilename + "[" + actualMD5Checksum + "] are different.");
        return true;
    }
}
