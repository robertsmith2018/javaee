package ca.qc.cgodin;

public class Exercice1 {

	public void run() {
		// le tableau initial
		int[] numbers = new int[]{1, 2, 3, 2, 1, 3, 5, 2, 3, 1};
		
		//un compteur de nombre de peaks
		int numPeaks = 0;
		
		//le traitement pour touver le nombre de peaks
		
		for(int i=1; i<numbers.length - 1; i++) {
			if(numbers[i]> numbers[i-1] && numbers[i]> numbers[i+1]) {
				numPeaks++;
			}
		}
		
		System.out.println("Le nombre de peaks est " + numPeaks);		
		
	}
}
