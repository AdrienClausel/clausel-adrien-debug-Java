package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	/**
	 * Constructeur avec l'injection des objets pour lire et ecrire dans un fichier
	 * @param reader Objet permettant de lire les symptômes depuis un fichier
	 * @param writer Objet permettant d'écrire les résultats sur le comptage des symptômes
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Lit et renvoie la liste des symptômes
	 * @return une liste de chaînes représentant les symptômes
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 * Compte les occurences de chaque symptômes dans une liste
	 * @param symptoms une liste de symptômes
	 * @return un dictionnaire associant chaque symptôme à son nombre d'occurences
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms){
		Map<String, Integer> countedSymptoms = new HashMap<String, Integer>();
		for (String symptom:symptoms) {
			int newValue = countedSymptoms.getOrDefault(symptom, 0) + 1;
			countedSymptoms.put(symptom, newValue);
		}
		return countedSymptoms;
	}

	/**
	 * Trie les symptômes par ordre alphabétique
	 * @param symptoms un dictionnaire associant chaque symptôme à son nombre d'occurences
	 * @return un dictionnaire associant chaque symptôme à son nombre d'occurences trié par nom de symptôme
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms){
		return new TreeMap<>(symptoms);
	}

	/**
	 * Ecrit dans un fichier les résultats des symptômes et leur nombre d'occurence
	 * @param symptoms un dictionnaire associant chaque symptôme à son nombre d'occurences
	 */
	public void writeSymptoms(Map<String, Integer> symptoms){
		writer.writeSymptoms(symptoms);
	}
}