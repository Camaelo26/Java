//Macarthur Diby
//lab27C
//Program that will use an array of ArrayLists to simulate separate chaining in a hashing process for a specific file





import java.util.*;
import java.io.*;




public class Main {
    
    
        //an int method that receives a string parameter that  use the following hash function to calculate and return a hash value for the string
        public static int hash(String myfile){

        // use the following hash function to calculate and return a hash value for the string:

       

        int hashValue = 0;

         if (Character.isLetter(myfile.charAt(0))) {
        hashValue = Character.toLowerCase(myfile.charAt(0)) - 'a' + 1;
        }

         // add the length of the string to the hash value

        hashValue += myfile.length();

        return hashValue;
    }

public static void main(String[] args) {

         // create an array of 36  ArrayLists
         ArrayList<String>[] arr = new ArrayList[36];

        // Read strings from the required  text file  and call hash method for every string
         try {
             Scanner requiredfile = new Scanner(new File("lab27C.txt"));// read the file 
            while (requiredfile.hasNext()) {
            String myfile = requiredfile.next();
            int index = hash(myfile);

     // use the returned hash value as the index in the array and add the string to that array position's ArrayList
            if (arr[index] == null) {
             arr[index] = new ArrayList<>();
            }
            arr[index].add(myfile);
         }

   // print the array of ArrayLists
   for (int i=0; i<arr.length; i++) {
     System.out.print(i + ":" );
     if (arr[i] == null) {
       System.out.println("index is empty");
     } else {
       for (String myfile : arr[i]) {
         System.out.print(myfile + "");
       }
       System.out.println();
     }
   }

 } catch (Exception e) {
   System.out.println("could not find the required file"  + e);
 }
}


}