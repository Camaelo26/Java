//Macarthur Diby
//Lab21B
//program  that will read words from an input file and create a map of the first letters in the words and how many words start with that letter.


import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main
{
  public static void main (String[]listedwords) throws Exception
  {
    LinkedHashMap < Character, Integer > word = new LinkedHashMap <> ();	// create a linked hashmap
    Scanner readthefile = new Scanner (new File ("Lab21B.txt"));	// read the given file
    //while loop to iterate through the file
    while (readthefile.hasNextLine ())
      {
	//split the elements in the file
	String news[] = readthefile.nextLine ().split (" ");
	//for loop to iterate through the words
	for (String newfile:news)
	  {
	   
	    word.put (newfile.charAt (0), word.getOrDefault (newfile.charAt (0), 0) + 1);
	  }
      }
    System.out.println (word);
  }
}
