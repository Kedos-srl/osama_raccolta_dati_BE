package it.grupposcai.osamard.util;


import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FileUtility {

    public static final String SEPARATOR = System.getProperty("file.separator");

    static Logger logger = Logger.getLogger(FileUtility.class);

    /**
     * Hash path
     */
    public static String generateHashPath(InputStream is) throws Exception {

        /** Digest file bytes */
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] buffer = new byte[is.available()];
        String digest = DigestUtils.md5Hex(buffer);
        byte[] bytes = (is.hashCode() + "" + digest.length()).getBytes("UTF-8");
        bytes = md.digest(bytes);

        return generateHashPath(bytes);
    }

    private static String generateHashPath(byte[] bytes) throws Exception {

        StringBuilder path = new StringBuilder();
        /** Create path */
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < bytes.length; i++)
            hexString.append(Integer.toHexString(0xFF & bytes[i]));
        String pathSource = hexString.toString();

        /** Normalize path */
        //int segmentLength = Config.getInt("file.path.segment.length");
        //int maxLength = Config.getInt("file.path.segment.max");
        int segmentLength = 2;
        int maxLength = 4;
        if (pathSource.length() > (maxLength * segmentLength))
            pathSource = pathSource.substring(0, (maxLength * segmentLength) + 1);
        int segmentCount = (pathSource.length() / segmentLength);
        for (int i = 0; i < segmentCount; i++) {
            int nextIndex = (i * segmentLength) + segmentLength;
            if (nextIndex >= pathSource.length()) {
                pathSource = pathSource.substring(i * segmentLength);
                path.append(pathSource);
                break;
            } else {
                String subString = pathSource.substring(i * segmentLength, nextIndex);
                path.append(subString + SEPARATOR);
            }
        }
        return path.substring(0, path.length() - 1);
    }

    public static String basePathOut(String basePathOut, String filename) throws Exception {
        return getResolvedNamePath(basePathOut, filename);
    }

    public static String getResolvedNamePath(String path, String filename) {
        return Paths.get(path.trim()).resolve(filename).toString();
    }

    public static void createPathDirectories(Path path) throws Exception {
        Files.createDirectories(path);
    }


    public static String getFullDocumentPath(String basePathOut, String filename) throws Exception {
        return getResolvedNamePath(basePathOut, filename);
    }


    public static String ripulisciNomeFile(String nomeFileOriginale) {

        String nomeFileRipulito = "";
        try {


            //String fileBaseName = FilenameUtils.getBaseName(nomeFileOriginale);

            String fileExtension = FilenameUtils.getExtension(nomeFileOriginale);

            nomeFileRipulito = CommonsUtils.ripulisciTesto(nomeFileOriginale) + "." + fileExtension;

            logger.debug("nomeFileOriginale<" + nomeFileOriginale + "> nomeFileRipulito<" + nomeFileRipulito + ">");

        } catch (Exception e) {
            logger.error("Exception in ripulisciNomeFile : " + e.toString());
            e.printStackTrace();
        }

        return nomeFileRipulito;

    }


    public static String generatePathDestinationFile(String basePathOut, InputStream is, String nomeFileOriginale) throws Exception {

        String destinationFile = "";

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        //String baseName = FilenameUtils.getBaseName(nomeFileOriginale);
        String estensioneFile = FilenameUtils.getExtension(nomeFileOriginale);

        String nomeFile = now.format(formatter) + "." + estensioneFile;

        /** Get folder out */
        String folderOutPath = getFullDocumentPath(basePathOut, generateHashPath(is));
        Path folderOut = Paths.get(folderOutPath);
        createPathDirectories(folderOut);

        File fileOut = new File(FileUtility.getResolvedNamePath(folderOutPath, nomeFile));
        fileOut.setWritable(true, false);
        fileOut.setReadable(true, false);
        fileOut.setExecutable(true, false);
        destinationFile = fileOut.getAbsolutePath();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();

        destinationFile = destinationFile.replace(basePathOut, "");
        destinationFile = destinationFile.replace("\\", "/");

        return destinationFile;
    }

    public static boolean deleteFile(String pathFile) {

        File file = new File(pathFile);
        return file.delete();

    }

    public static String getFilenameFromPath(String path) {
        Path p = Paths.get(path);
        String file = p.getFileName().toString();
        return file;
    }

    public static String getFormato(String ImageName) {

        return (ImageName.substring(ImageName.indexOf('.'), ImageName.length()));
    }
}
