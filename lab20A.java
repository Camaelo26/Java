// Macarthur Diby
// Lab 20 A
// PROGRAM THAT CREATE A RANDOM ARRAY LIST AND ANOTHER LIST AND DO SOME TASKS 



import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Main {
	
	public static void main(String[] arr) {
	    // array containing 20 random numbers 
		ArrayList<Integer> randomnumbers =new ArrayList<Integer>();
		Random rand=new Random(); // set the random generator
		for(int i=0;i<20;i++)
		{
			randomnumbers.add(rand.nextInt(101));
		}
		
		createArray(randomnumbers);
		
		int avg=createArray2(randomnumbers);
		
		System.out.println();
		
		System.out.println("\nAverage is  "+avg);
		
		Collections.sort(randomnumbers);
		
		System.out.println("\n  sorted list is :\n");
		for(int n:randomnumbers)
			System.out.print(n+" ");
		
	}
	
	private static void createArray(ArrayList<Integer> randomnumbers) {
		
		System.out.println(" Original List is");
		//Print the  original list
		for(int n:randomnumbers)
		System.out.print(n+" ");
		System.out.println();
		//create list1
		ArrayList<Integer> list1=(ArrayList<Integer>) randomnumbers.clone();
		//create  list2
		ArrayList<Integer> list2=new ArrayList<Integer>(Arrays.asList(0,10,20,30,40,50,60,70,80,90,100));
		// see if 45 os present in list 1
		if(list1.contains(45))
			System.out.println("\nlist 1 contains 45");
		else
			System.out.println("\n45 is not present  in list1");
		
		list1.removeAll(list2);
		
		System.out.println("\nList 1 without  list2 ");

		for(int n:list1)
			System.out.print(n+" ");
		
	}
	
	private static int createArray2(ArrayList<Integer> number) {
		
		int summation=0;
		// create an iterator
		Iterator<Integer> arr = number.iterator();
		while(arr.hasNext())
		{
			summation+=arr.next();
		}
		return summation/number.size();
	}

}
