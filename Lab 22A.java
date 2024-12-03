//Macarthur Camael Diby
//Lab 22A
// programm that will create an ArrayList and a TreeSet of 1000 items and will compare the time it takes to fill them, search for a number, and remove a number. 



//import the required libraries
import java.util.*;
import java.lang.Math.*;

public class Main
{ static void first (ArrayList <Integer> arrayList, TreeSet <Integer> treeSet){
    
//declare long to record the beginning time

 long beginning = System.nanoTime();
  for (int i=0; i<2000;i++)
    {
      arrayList.add ((int) (Math.random() * 2000));
    }
  long ending = System.nanoTime ();//declare long to record the ending time
  System.out.println ("Time it took to execute the statement:" + (ending - beginning)+" nanoseconds");
  beginning = System.nanoTime ();//declare long to record the beginning time



for(int i=0; i<2000; i++){
treeSet.add ((int) (Math.random()*2000));
}
ending = System.nanoTime();//declare long to record the ending time
System.out.println ("Time it took to execute the statement :" + (ending - beginning)+" nanoseconds");
}
static void second (ArrayList < Integer > arrayList, TreeSet < Integer > treeSet){
System.out.println ("Enter a number between 1 and 2000:");
Scanner a = new Scanner (System.in);
int numberchosen = a.nextInt();
long beginning, ending;
beginning = System.nanoTime();
if (arrayList.contains(numberchosen)) {
System.out.println (numberchosen + " is  a number that  our List contains "); 
}
else{
 System.out.println (numberchosen + " is not a number that  our List contains , try another one");
    
}


ending = System.nanoTime();
System.out.println ("Time took to find the chosen number in our list:" +(ending - beginning)+" nanoseconds");
beginning = System.nanoTime();
if (treeSet.contains (numberchosen))
{ System.out.println (numberchosen + " is present in treeSet"); 
    
}
    else
{

System.out.println (numberchosen + " is not present in treeSet");
}
System.out.println("Our new array List is:" +arrayList.remove(numberchosen));
ending = System.nanoTime();
System.out.println ("Time taken to search numberchosen in treeSet:" + (ending - beginning)+" nanoseconds");
}
public static void main (String[] args) {
    ArrayList < Integer > myarrayList = new ArrayList <Integer>();// create an array list
TreeSet < Integer > mytreeSet = new TreeSet <Integer>();// create a tree set
first (myarrayList, mytreeSet);
System.out.println ("Our array List is:" + myarrayList);
System.out.println ("Our Treeset is :" + mytreeSet);

second (myarrayList, mytreeSet);
}
}