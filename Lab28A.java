//Macarhut Diby
//Lab28A.java
//Create a file a file and sort it

// import the required libraries


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab28A
{
	public static void main(String[] args)throws FileNotFoundException {
	    // code to read the files
		Scanner requiredfile = new Scanner(new File("Lab28A.txt")); //
		MyQueue queue = new MyQueue();// create a queue of  objects
		Rankings datas[] = new Rankings[10]; //data for 10 objects of the class
		int data = 0; // set data to 0
		while (requiredfile.hasNextLine()) {
			String line = requiredfile.nextLine();// create a string line  to read  from the line of data
			String[] datas1 = line.split("\\s+"); // split the line while we have space in between
			Rankings i = new Rankings(Integer.parseInt(datas1[0]),datas1[1],datas1[2], Integer.parseInt(datas1[3]));
			datas[data++] = i;
		}
        
        
        //print before sorting
		System.out.println("BEFORE: ");
		for (Rankings it : datas) {
			System.out.println(it);
		}

		MyQueue.sort(datas);
		
		
        //print after sorting
		System.out.println("\nAFTER: ");
		for (Rankings it : datas) {
			queue.enqueue(it);
		}
		
		System.out.println(queue);// print the queue

	}

}


//Rankings.java



public class Rankings implements Comparable<Rankings> {// create a secondary class for objects of rankings and compare the datas between them

    private int clubid; // declare a private integer named clubid
	private String clubname; // declare a private string named clubname to store the name of the club
	private String leaguename; // declare a private string named leaguename to store the  name of the league  where the club plays
	private int numberoftitles; // declare a private integer named numberoftitles to store the numbers of winniing titles
	
    //constructor that receives all the int and String parameters and fills in both instance variables.
	public Rankings(int id,String clubname, String leaguename, int numberoftitles) {
		super();
		this.clubid = clubid;
		this.clubname = clubname;
		this.leaguename = leaguename;
		this.numberoftitles = numberoftitles;
	}
	// set the instance variables from the data
	public int getClubid() {
		return clubid;
	}

	public String getclubName() {
		return clubname;
	}

	public String getLeagueName() {
		return leaguename;
	}

	public int getNumberoftitles() {
		return numberoftitles;
	}
    // tostring method to print all the declared variables for the differents club datas
	@Override
	public String toString() {
		return("N: "+this.getClubid()+"\nCLUB: "+this.getclubName()+"\nLEAGUE: "+this.getLeagueName()+"\nTITLES: "+this.getNumberoftitles());
	}

    @Override
	public int compareTo(Rankings theclubs) {// compare the datas regardless the club name
		return clubname.compareTo(theclubs.clubname);
	}

}

//MyQueueNode.java


public class MyQueueNode { 

	private Rankings data;
	private MyQueueNode next;

	public MyQueueNode(Rankings datas) {
		this.data = datas;
		next = null;
	}

	public Rankings getData() {
		return data;
	}

	public MyQueueNode getNext() {
		return next;
	}

	@Override
	public String toString() {
		return data.toString();
	}

}

//MyQueue.java


// import the required linrary
import java.util.NoSuchElementException;

public class MyQueue {

	private Rankings[] queue;// declare the rankings queue
	private int size; // declare an integer for its size

	public MyQueue() {
		queue = new Rankings[10];//set queue to an array
		size = 0;// set size to 0
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}


    // create a void method to enqueue the datas and verify the capacity of the given space
	public void enqueue(Rankings x) {

		if (size == queue.length)
			ensureCapacity();
		queue[size++] = x;

	}

	private void ensureCapacity() {
		Rankings[] newQueue = new Rankings[2 * queue.length]; // set up the newQueue size
		int i = 0;

		for (Rankings val : queue) {
			newQueue[i++] = val;
		}

		queue = newQueue; // set queue to newqueue
		size++;
	}

	public Rankings peek() {
		if (isEmpty())
			throw new NoSuchElementException();
		return queue[0];
	}

	public Rankings dequeue() {
		if (isEmpty())
			throw new NoSuchElementException();
		Rankings datas = queue[0];
		for (int i = 1; i < size; i++) {
			queue[i - 1] = queue[i];
		}
		size--;
		return datas;
	}


    //void method to sort the datas
	public static void sort(Rankings[] datas) {
		int n = datas.length;// set n integer to the data's lenf\ght
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {// compare our datas
				if (datas[j].compareTo(datas[j + 1]) > 0) {
					Rankings t = datas[j];
					datas[j] = datas[j + 1];
					datas[j + 1] = t;
				}
			}
		}
	}
    
    //tostring method to print the queue
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < size; i++) {
			s += queue[i].toString() + "\n";
		}
		return s;// return the queue
	}
}




//Lab28A.txt

1 RealMadrid LigaEspanyol 15
2 ChelseaFc PremierLeague 2
3 BarcelonaFc Liga 5
4 BayernMunchen Bundesliga 7
5 ACMilan SerieA 10
6 Liverpool PremierLeague 8
7 Arsenal PremierLeague 0
8 ParisSaintGermain Ligue1 1
9 PortoCF PrimeraLigaPortugal 1
10 Benfica PrimeraLiga 4