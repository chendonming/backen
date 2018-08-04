package com.xl.backen.util;

import java.io.File;
import java.io.FileOutputStream;

/**
 * FileUtil
 */
public class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName + "." + suffix);
        out.write(file);
        out.flush();
        out.close();
    }
}