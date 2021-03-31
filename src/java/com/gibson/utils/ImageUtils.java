package com.gibson.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 *
 * @author Filip Kisic
 */
public class ImageUtils {

    public static String convertBytesToBase64Image(byte[] image) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(image);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        byte[] imageBytes = outputStream.toByteArray();
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        inputStream.close();
        outputStream.close();
        return base64Image;
    }
}
