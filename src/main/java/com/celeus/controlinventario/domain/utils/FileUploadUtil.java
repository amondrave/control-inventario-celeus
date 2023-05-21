package com.celeus.controlinventario.domain.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

    public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            if (fileName.startsWith("/")) {
                fileName = fileName.substring(1);
            }
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new IOException("Could not save file: " + fileName, ex);
        }
    }
    
    public static byte[] readFileToByteArray(File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }
    
    
    public static void deleteImage(String filename) {
    	File imagen = new File(filename);
    	if (imagen.delete()) {
    	    System.out.println("La imagen ha sido borrada.");
    	} else {
    	    System.out.println("No se pudo borrar la imagen.");
    	}

    }
    
    public static String getImageBaseFormat(String filename) {
		try {
            File file = new File(filename);
            byte[] fileContent = FileUploadUtil.readFileToByteArray(file);
            String base64String = Base64.getEncoder().encodeToString(fileContent);
            return base64String;
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
    }

}

