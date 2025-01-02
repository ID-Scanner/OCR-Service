package com.extaction.ocr_service.service;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

@Service
public class OcrService {

    public String processImage(InputStream imageInputStream) throws Exception {
        // Charger l'image depuis le flux d'entrée (InputStream) en BufferedImage
        BufferedImage image = ImageIO.read(imageInputStream);

        // Initialisation de Tesseract avec la langue et le chemin de tessdata
        ITesseract instance = new Tesseract();
        instance.setLanguage("eng");  // Langue pour l'OCR (vous pouvez changer la langue ici)
        instance.setDatapath("C:/tesseract/tessdata");  // Chemin vers les données de Tesseract

        // Traiter l'image et obtenir le texte
        String result = instance.doOCR(image);

        // Retourner le texte extrait
        return result;
    }
}
