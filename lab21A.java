// Macarthur Camael Diby
// Lab21A
//Method to verify if the groceries made can do the recipe asked.




import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

class Main
{

// method to check items in groceryitems TreeSet
  public static void verifytherecipe (TreeSet < String > groceryitems,
				TreeSet < String > recipeitems)
  {
      
// verify if groceries from the files contains the recipes items

    if (groceryitems.containsAll (recipeitems))
      {
	System.out.println ("RECIPE MADE.");
	System.out.println ("Items used in recipeitems are : " + recipeitems+"\n");
	
// Remove items from the groceries  set that were used in the recipes to make the food

	groceryitems.removeAll (recipeitems);
      }
    else
      {
	System.out.println ("\nRECIPE MADE.");
	
   // remove  the grocery items from the list
   
	recipeitems.removeAll (groceryitems);
	System.out.println ("The recipe ingredients that are missing from the grocery set: " + recipeitems+"\n");
      }
  }
     //void method that will accept the grocery TreeSet and a recipe TreeSet as parameters.

  public static void main (String[]args)
  {
      
    // Set a TreeSet for the groceries and the recipes

    TreeSet < String > groceryitems = new TreeSet <> ();
    TreeSet < String > first_recipeitems = new TreeSet <> ();
    TreeSet < String > second_recipeitems = new TreeSet <> ();

// Read all the files 
    try
    {

      File food = new File ("Lab21A1.txt");
      Scanner filereader = new Scanner (food);
      while (filereader.hasNextLine ())
	{
	  String items = filereader.nextLine ();
	  groceryitems.add (items);
	}


      food = new File ("Lab21A2.txt");
      filereader = new Scanner (food);
      while (filereader.hasNextLine ())
	{
	  String items = filereader.nextLine ();
	  first_recipeitems.add (items);
	}


      food = new File ("Lab21A3.txt");
      filereader = new Scanner (food);
      while (filereader.hasNextLine ())
	{
	  String items = filereader.nextLine ();
	  second_recipeitems.add (items);
	}
      filereader.close ();
    }
    catch (FileNotFoundException e)
    {
        //if the files does not exist says there is an error.
      System.out.println ("An error occurred.");
      e.printStackTrace ();
    }


    verifytherecipe (groceryitems, first_recipeitems);
    verifytherecipe (groceryitems, second_recipeitems);

  }
}