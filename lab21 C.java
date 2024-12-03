// Macarthur Camael Diby
// Lab21C
//Method to verify if the groceries made can do the recipe asked.



import java.util.*;
import java.io.*;

public class Main{

    public static void main(String [] args) throws Exception{

        // read the given file
        File filereader = new File("Lab21C.txt");
        Scanner sc = new Scanner(filereader);


        // create the required map 
        TreeMap<String,Integer> triveateamname = new TreeMap<String, Integer>();

         
        while(sc.hasNextLine()){
            //get the key and the value
            String key = sc.nextLine();
            int value = Integer.parseInt(sc.nextLine().trim());
            triveateamname.put(key,value);
        }

        // print the required map
        System.out.println("Map: " + triveateamname+"\n");

        // create an input
        Scanner input = new Scanner(System.in);
        //	Ask the user to enter a name 
        System.out.print("Enter a  team's name: ");
        String teamname = input.nextLine();

        // if statement to see if the team name is in the map
        if (triveateamname.containsKey(teamname)){
            System.out.println("The following team "+teamname+" is in the Map\n");
        }else{
            System.out.println("The following team "+teamname+" is not in the Map\n");
        }

        //Ask the user for a team score
        System.out.print("Enter a team score: ");
        int teamscore = input.nextInt();

        // set counter to 0
        int count = 0;

        Set<Map.Entry<String, Integer>> name_score = triveateamname.entrySet();

        // for loop to iterate through the map
        for (Map.Entry<String, Integer> x : name_score) {
            // if statement to verify our condition 
            if (x.getValue() >= teamscore)
                count++;
        }

        // print the numbers of teams that made the following score or more
        System.out.println("Number of teams that made the following score "+teamscore+" or higher : "+count+"\n");

    }
}