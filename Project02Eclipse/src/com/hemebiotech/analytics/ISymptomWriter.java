package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Permet de stocker les symptômes
 */
public interface ISymptomWriter {
    /**
     * Ecrit les données des symptômes
     * @param symptoms Dictionnaire pour stocker les symptômes avec leur quantité
     */
    public void writeSymptoms(Map<String, Integer> symptoms); 
}