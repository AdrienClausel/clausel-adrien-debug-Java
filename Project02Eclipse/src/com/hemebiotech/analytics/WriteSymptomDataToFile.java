package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filePath;

    /**
     * Constructeur
     * @param filePath Chemin vers le fichier qui va stocker les symptômes
     */
    public WriteSymptomDataToFile(String filePath){
        this.filePath = filePath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        
        try (FileWriter writer = new FileWriter(filePath)) {
            symptoms.forEach((symptom, quantity) -> {
                try {
                    writer.write(symptom + ": " + quantity + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}