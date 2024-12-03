// Macarthur Camael Diby
// Lab 24B
// create a queue structure to use it to get datas from cars




// create a class named Cars


public class Cars {
        
        private String car_make; // string for the car make
        private String car_model;// string for the model of the car
        private int car_year; // string for the year of the Car
        
        
        public Cars(String car_make, String car_model, int car_year) {
                this.car_make = car_make;
                this.car_model = car_model;
                this.car_year = car_year;
        }


        //get the car make
        public String get_the_car_make() {
                return car_make;
        }


        //get the car model
        public String get_the_car_model() {
                return car_model;
        }
        // get the car year
        public int get_the_car_year() {
                return car_year;
        }


        @Override
        public String toString() {
                return "\nCAR INFORMATIONS : \nMAKE : " + car_make + ", MODEL :" + car_model + ", YEAR = " + car_year + "";
        }
        
        
        
        
        

}


// Create a class named MyQueueNode

public class MyQueueNode<A>
{
	
	public A values;
	public MyQueueNode<A> next;
	
	
	public MyQueueNode(A datas) {
		values = datas;
		next = null;
	}
	
	
	public A getValues() {
		return values;
	}
}


// Create a class named Myqueue 

public class MyQueue<E>
{
	
	private MyQueueNode<E> head; //decalre private node queue head
	private MyQueueNode<E> tail; // declare private node queue TAIL
	private int number; //declare the total number
	
	
	public MyQueue() {
		head = null;
		tail = null;
		number = 0;
	}
	
	// method to return number of nodes in the queue
	public int getnumber() {
		return number;
	}
	
	// method that returns true 
	public boolean isEmpty() {
		return number == 0;
	}
	
	// method to insert value at the end of queue
	public void enqueue(E value) {
		
		
		MyQueueNode<E> node = new MyQueueNode<E>(value);
		if(isEmpty()) 
			head = node;
		else 
			tail.next = node; 
		
		tail = node; // set the tail to node
		number++; 
	}
	

	public E dequeue() {
		if(isEmpty()) 
			return null;
		
		E value = head.values; 
		head = head.next; 
		number--;  
		if(isEmpty()) 
			tail = null;
		return value; 
	} 
	
	
	public String toString() {
		
		String string = ""; // put the string to empty 
		
		MyQueueNode<E> current = head; // set current to head node
		
		
		while(current != null)
		{
			string += current.values.toString() + "\n"; 
			current = current.next; 
		}
		
		return string;
	}
}


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) throws FileNotFoundException {

                Scanner required_file= new Scanner(new File("Lab24B.txt"));
                MyQueue<Cars> cars_informations= new MyQueue<>();
                while(required_file.hasNext())
                {
                        cars_informations.enqueue(new Cars(required_file.next(),required_file.next(),required_file.nextInt()));
                }
                System.out.println("Queue with toString method : ");
                System.out.println(cars_informations.toString());
                System.out.println("\n\nREMOVE THE FIRST 3 OBJECTS: ");
                System.out.println(cars_informations.dequeue());
                System.out.println(cars_informations.dequeue());
                System.out.println(cars_informations.dequeue());
                
                
                
        }

}
