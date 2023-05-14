package com.celeus.controlinventario.domain.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

    public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
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

}

