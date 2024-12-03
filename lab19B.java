//progam name : lab 19.b
// name : Macarthur Diby
// program find the details of a group of box




import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Main
{
  public static void main (String[]args)
  {
    try
    {
//array list to store boxs
      ArrayList < Box > box = new ArrayList < Box > ();
//opening file Lab19B.txt as input
      Scanner input = new Scanner (new File ("Lab19B.txt"));
//loop until last line of input
      while (input.hasNext ())
	{
//read items
	  String items = input.nextLine ();

//read number of items
	  int numberofitems = Integer.parseInt (input.nextLine ());
//create new box object 
	    box.add (new Box (items , numberofitems));
	}

      double sumitems = 0, averageitems;
//finding the sum of items
      for (int i = 0; i < box.size (); i++)
	{
//add ith box's total items to the sumitems
	  sumitems += box.get (i).getNumberOfitems ();
	}

//finding the average number of items in a box
      averageitems = sumitems / (double) box.size ();
//printing average number of items
      System.out.println ("Average number of items " + averageitems);

//printing the informaion of all box
      System.out.println ("\ninformation of all box:");
      for (int i = 0; i < box.size (); i++)
	{
//printing the details of a box
//this will automatically call the toString() method of box
	  System.out.println (box.get (i));
	}
    }
    catch (Exception e)
    {
      e.printStackTrace ();
    }
  }
}

class Box
{
//data members
  private String items;
  private int numberofitems;

//constructor
  public Box(String items,int numberofitems)
  {
    this.items = items;
    
    this.numberofitems = numberofitems;
  }

//function to return number of items
  public int getNumberOfitems ()
  {
    return numberofitems;
  }

//function to get items
  public String getitems ()
  {
    return items;
  }

//function to return string representation of a box object
  public String toString ()
  {
    return "item " + items + ", " +
      " number of items" + numberofitems;
  }
}