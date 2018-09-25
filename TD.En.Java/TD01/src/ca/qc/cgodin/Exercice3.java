package ca.qc.cgodin;

import java.util.ArrayList;
import java.util.Random;

public class Exercice3 {
	
	private ArrayList<Integer> myList;
	
    public Exercice3() {
    	myList = new ArrayList<Integer>();
    	Random  rand = new Random();
        for (int i = 0; i < 10; i++) {
            myList.add(rand.nextInt(100));
            System.out.print(myList.get(i) +  "  ");
        }
        System.out.println();
    }
   
    public void run() {
	    ArrayList<Integer> listInversee = inverser(3, 8);
	    for (int i = 0; i < listInversee.size() ; i++) {
	        System.out.print(listInversee.get(i) +  "  ");
	    } 
	    System.out.println();
    }
 
     
    public ArrayList<Integer> inverser(int i, int j){
        if(i>myList.size() || (i<0))
            return null;
        if(j>myList.size() || (j<0))
            return null;
        if(i>j)
            return null;
     
        for (int k = i; k <= (j/2 + 1); k++) {
            int tmp = myList.get(k);
            myList.set(k, myList.get((j-k+i)));
            myList.set((j-k+i), tmp);
        }
         
        return myList;
    }
}
