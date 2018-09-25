package ca.qc.cgodin;

public class Exercice2 {

	public void run() {
		//tableau des mots
		String[] strings = new String [] 
				{"tuples", "are", "awesome", "tuples", "are", "cool",
		           "tuples", "tuples", "tuples", "shades"};
		
		//trouver le nombre d'occurences de chaque mot
		for (int i = 0; i < strings.length; i++) {
			if(!strings[i].equals("flag")) {
				int cmpt = 1;
				for(int j = i+1 ; j<strings.length ; j++) {
					if(strings[j].equals(strings[i])) {
						cmpt++;
						strings[j] = "flag";
					}
				}
				System.out.println(strings[i] + "\t" + cmpt);
			}
			
		}
		
	}
}
