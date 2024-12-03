//Macarthur Diby
//Lab 27A
// program that wuill create an hash table uof customers informations




// customer.java
class Customer {
    private int IDCustomer; //declare a variable integer for the customer Id
    private String customerName; //declare a variable string for the customer name
    
    
    //constructor that receives the different parameters
    public Customer(int IDCustomer, String customerName) {
        this.IDCustomer = IDCustomer;
        this.customerName = customerName;
    }
    
    public int findIDCustomer() {
        return this.IDCustomer;
    }
    
    public String findCustomerName() {
        return this.customerName;
    }
    
    
    // to string method that print the variables
    public String toString() {
        return ""+"\nID: " + this.findIDCustomer() + " " +
                "\nNAME:" + this.findCustomerName();
    }
}


//Main.java



import java.util.*;
import java.io.*;

public class Main {
    // int method  that returns the results of the hash function on the parameter
    public static int findSum(int number) {
        int sum = 0;
         
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
     
        return sum;
    }
    
    // hash result of the customer ID
    public static int hash(int IDcustomer) {
        int hashresult = findSum(IDcustomer);
        
        while(hashresult >= 10) {
            hashresult = findSum(hashresult);
        }
        
        return hashresult;
    }
    
	public static void main(String[] args) {
	    int size = 10;
        Customer[] customersdatas = new Customer[size];
        
        try {
            BufferedReader readthefile = new BufferedReader(new FileReader("Lab27A.txt"));
            
            int hashresult;
            String line;
            
            while((line = readthefile.readLine()) != null) {
            
                String[] line1 = line.split(" ", 2);// split line
                
                hashresult = hash(Integer.parseInt(line1[0]));
                
                System.out.println(line1[1].trim() + " " + hashresult); //print the customer s name and the hash function result
                
                
                int i = hashresult;
                do {
                    if (customersdatas[i] == null) {
                        customersdatas[i] = new Customer(Integer.parseInt(line1[0]), line1[1].trim());
                        break;
                    }
 
                    i = (i + 1) % size;
 
                } while (i != hashresult);
            }
        } catch(IOException e) {
            System.out.println("error no such file name");
        }
        
        System.out.println();
        
        // print the customers datas without the null
        for(int j = 0; j < size; j++) {
            if(customersdatas[j] != null) {
                
                System.out.print(j + " ");
                System.out.println(customersdatas[j]);
            }
        }
	}
}

