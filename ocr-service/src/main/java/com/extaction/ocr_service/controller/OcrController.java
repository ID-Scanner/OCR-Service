package com.extaction.ocr_service.controller;

import com.extaction.ocr_service.service.OcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.InputStream;

@RestController
@RequestMapping("/ocr")
public class OcrController {

    @Autowired
    private OcrService ocrService;

    @PostMapping("/process")
    public String processImage(@RequestParam("image") MultipartFile imageFile) {
        try {
            // Convertir l'image reçue en un InputStream
            InputStream imageInputStream = imageFile.getInputStream();

            // Utiliser le service OCR pour traiter l'image
            String result = ocrService.processImage(imageInputStream);

            // Retourner le texte extrait
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return "Erreur lors du traitement de l'image : " + e.getMessage();
        }
    }
}
