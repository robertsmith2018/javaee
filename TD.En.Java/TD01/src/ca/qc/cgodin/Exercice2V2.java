package ca.qc.cgodin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Exercice2V2 {
	public void run() {
		//tableau des mots
		String[] strings = new String [] 
				{"tuples", "are", "awesome", "tuples", "are", "cool",
		           "tuples", "tuples", "tuples", "shades"};
		
		//dictionnaire vide
		HashMap<String, Integer> dictionnaire = new HashMap<String, Integer>();
		
		//parcourir le tableau et remplir le dictionnaire
		for (int i = 0; i < strings.length; i++) {
			if(!dictionnaire.containsKey(strings[i])) {
				dictionnaire.put(strings[i], Integer.valueOf(1));
				
			} else {
				int valeur = dictionnaire.get(strings[i]);
				dictionnaire.put(strings[i], valeur + 1);
			}
		}
		
		//on recupere la liste des clés
		Set keys = dictionnaire.keySet();
		
		//on parcourt les clés pour afficher les valeurs associées
		for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			//affichage du resultat
			System.out.println(key + "\t" + dictionnaire.get(key));
		}
	}
}


