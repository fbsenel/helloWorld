//11.01.2021
//This code compares the search time of ArrayList, LinkedList, HashMap and BST.




import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.*;

public class searchPerformance {



	public static void main(String[] args) {

		int M = 1000; //Array size

		while(M<=100000) {
			ArrayList<Integer> randomNumbers = new ArrayList<Integer>(); //creating an ArrayList named "randomNumbers"
			LinkedList<Integer> randomLinked = new LinkedList<Integer>(); //creating and LinkedList named "randomLinked"
			BST<Integer> randomTree = new BST<Integer>(); //creating a BST named "randomTree"
			HashMap<Integer,Integer> randomHash = new HashMap<Integer,Integer>(); //creating an HashMap named "randomHash"



			//a while loop which will continue to run until my array size is 100 000
			for(int i=1; i<=M; i++) { //adding elements to my ArrayList, its sorted ---> [1,2,3,4...,M]
				randomNumbers.add(i); //add operation for ArrayList
				//randomLinked.add(i);
				//randomTree.insert(i);
			}

			Collections.shuffle(randomNumbers); //shuffle operation for shuffling my ArrayList
			//Collections.shuffle(randomLinked);		
			for(int n = 0; n<randomNumbers.size(); n++) {	 //copying ALL the elements from my ArrayList and adding it to the LinkedList, BST and HashMap with EXACT copy
				randomLinked.add(randomNumbers.get(n));	
				randomTree.insert(randomNumbers.get(n));
				randomHash.put(randomNumbers.get(n),randomNumbers.get(n)); //giving same values to key and value
			}

			double startTime4 = System.nanoTime(); //starting time for HashMap

			for(int d = 0; d < M; d++) { //my HashMap searching
				randomHash.get(d); 
			}	

			double endTime4 = System.nanoTime(); //ending time for HashMap
			double timeForHash = endTime4-startTime4; //calculating the real execution time for HashMap



			double startTime3 = System.nanoTime(); //starting time for BST

			for(int c = 1; c <= M; c++) {
				randomTree.search(c); //my BST searching
			}	

			double endTime3 = System.nanoTime(); //ending time for BST
			double timeForBST = endTime3-startTime3; //calculating the real execution time for BST



			double startTime = System.nanoTime(); //starting time for ArrayList
			for(int j = 1; j <= M; j++) { //my ArrayList searching
				randomNumbers.indexOf(j);
			}		

			double endTime = System.nanoTime(); //ending time for ArrayList
			double timeForArrayList = endTime-startTime; //calculating the real execution time for ArrayList



			double startTime2 = System.nanoTime(); //starting time for LinkedList

			for(int a = 1; a<=M ; a++) { //my LinkedList searching
				randomLinked.contains(a);
			}

			double endTime2 = System.nanoTime(); //ending time for LinkedList
			double timeForLinkedList = endTime2-startTime2; //calculating the real execution time for LinkedList

			
			System.out.println(M +". " + timeForLinkedList/1000000+" "+ timeForArrayList/1000000+" "+ timeForBST/1000000+" "+ timeForHash/1000000); //printing times and changing nanosecond to msec
			
			M = M + 1000; //increasing array size to 1000
			

		}
		// bst < array < hash < linked



	}
}