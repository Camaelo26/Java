//Lab 18 C
//Macarthur Diby
	//A recursive method that accepts two strings where the first string is longer than the second string.  It should return a string that is equal to the first string with all instances of the second string removed




public class Main {
	    
	    public static String removeinstance(String w1, String w2) 
	    {
	        if (w1.contains(w2)) 
	        {
	            
	            return removeinstance(w1.replace(w2, ""), w2);
	        }
	        
	        return w1;
	    }

	    public static void main(String[] args) {
	        
	        System.out.println(removeinstance("Mississippi", "iss"));

	        System.out.println(removeinstance("disfunctional", "fun"));
	        System.out.println(removeinstance("Lapement", "ment"));
	        System.out.println(removeinstance("lighting", "ing"));
	        System.out.println(removeinstance("champions", "ions"));

	       
	    }
	}

