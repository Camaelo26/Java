//Macarthur Diby
//Lab 27B
// program that wuill create an hash table using different hash functions and quadratic probing.




//Gadget.java
public class Gadget {

    private int GadgetID; // declare an integer for the gadget's Id 
    private String gadgetName;// declare a string for gadget name 
    
    // constructor  for the variables
    public Gadget(int GadgetID, String gadgetName) {
        this.GadgetID = GadgetID;
        this.gadgetName = gadgetName;
    }

    public int findGadgetID() {
        return GadgetID;
    }
    
    
    // to string method to print the variables
    @Override
    public String toString() {
        return "GADGET FOUND \nID: " + GadgetID + ".\nGADGET NAME: " + gadgetName+".\n" ;
    }
}


//Main.java


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



class Main {
    // create an hash function
    public static int hash(int key, Gadget[] gadgetdatas) {
        int index = key % gadgetdatas.length;
        int quadraticprobing = 1;
        while (gadgetdatas[index] != null) {
            index = (index + quadraticprobing * quadraticprobing) % gadgetdatas.length;
            quadraticprobing += 1;
        }
        return index;
    }

    public static void main(String[] args) {
        
        Gadget[] gadgetdatas = new Gadget[20]; //declare a  hash table array with length 20

        //Code to read the required file
        String requiredfile = "Lab27B.txt";
        try {
            Scanner readmyfile = new Scanner(new File(requiredfile));
            while (readmyfile.hasNextLine()) {
                String line = readmyfile.nextLine();
                int spc = line.indexOf(' ');
                int id = Integer.parseInt(line.substring(0, spc));
                String name = line.substring(spc + 1);
                Gadget gadget = new Gadget(id, name);
                int index = hash(gadget.findGadgetID(), gadgetdatas);
                gadgetdatas[index] = gadget;
            }
            readmyfile.close();// close the file
            
            
            // print the hash table
            System.out.println("HASH TABLE ARRAY:");
            for(int i=0; i< gadgetdatas.length;i++){
                System.out.printf("INDEX: %d = %s\n", i, gadgetdatas[i]);
            }




        } catch (FileNotFoundException e) {
            System.out.println("Error no such file name " + requiredfile);// if file not found
        }


    }
}
