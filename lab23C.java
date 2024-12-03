//Macarthur Diby
//Lab23C
// Program that sort Software games by their given datas 


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	// Void method that receives an array of Software objects as a parameter and uses the Bubble Sort algorithm to sort the array by the prices 
	public static void Software_Price_sorting(Software[] datas)
	{
		
		for(int i=0;i<datas.length-1;i++)
		{
			
			for(int j=0;j<datas.length-1-i;j++)
			{
				
				if(datas[j].get_software_price() > datas[j+1].get_software_price())
				{
					Software temp = datas[j];
					datas[j] = datas[j+1];
					datas[j+1] = temp;
				}
			}
		}
	}
	
	// Void method that receives the array and (bubble) sorts them by number of players
	public static void numbers_of_players_sorting(Software[] datas)
	{
		
		for(int i=0;i<datas.length-1;i++)
		{
		
			for(int j=0;j<datas.length-1-i;j++)
			{
				
				if(datas[j].get_numbers_of_players() < datas[j+1].get_numbers_of_players())
				{
					Software temp = datas[j];
					datas[j] = datas[j+1];
					datas[j+1] = temp;
				}
			}
		}
	}
	
	
	//  Main method
	public static void main(String[] args) {
	    // Open the file 
        Scanner in = new Scanner(System.in);
        File requiredfile = new File("Lab23C.txt");
        
        try {
            Scanner readthefile = new Scanner(requiredfile);
            String software_title;
            double software_price;
            int numberofplayers;
            Software[] datas = new Software[5];
            int size = 0;
            while (readthefile.hasNextLine() && size < datas.length) {
                software_title = readthefile.nextLine();
                software_price = Double.parseDouble(readthefile.nextLine());
                numberofplayers = Integer.parseInt(readthefile.nextLine());
                datas[size++] = new Software(software_title, software_price, numberofplayers);
            }
            readthefile.close();

            Software_Price_sorting(datas);
            System.out.println("DATAS SORTED BY PRICE.\n");
            for (int i = 0; i < size; i++) {
                System.out.println(datas[i]);
            }
            System.out.println();

            numbers_of_players_sorting(datas);
            System.out.println("DATAS SORTED BY NUMBER OF PLAYERS.\n");
            for (int i = 0; i < size; i++) {
                System.out.println(datas[i]);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("files" + requiredfile.getAbsolutePath() + "not found");
        }
    }
}

//class named Software with the components 

class Software
{
	
	private String software_title; 
	private double software_price; 
	private int numberofplayers; 
	

	public Software(String software_title, double software_price, int numberofplayers) {
		this.software_title = software_title;
		this.software_price = software_price;
		this.numberofplayers = numberofplayers;
	}
	
	
	public double get_software_price() {
		return software_price;
	}
	
	
	public int get_numbers_of_players() {
		return numberofplayers;
	}
	
	// toString (no parameters) that returns a String containing the instance variables with labels.
	public String toString() {
		return String.format("TITLE: %s\nPRICE:$%.2f\nNUMBER OF PLAYERS: %d\n\n", software_title, software_price, numberofplayers);
	}
}


