//Macarthur Camael Diby
//Lab28B
// Java project that use the stack method on a created file

//Ranking.java
public class Ranking {	// create a secondary class for objects of rankings
	
	
	private int clubid; // declare a private integer named clubid
	private String clubname; // declare a private string named clubname to store the name of the club
	private String leaguename; // declare a private string named leaguename to store the  name of the league  where the club plays
	private int numberoftitles; // declare a private integer named numberoftitles to store the numbers of winniing titles
	
    //constructor that receives all the int and String parameters and fills in both instance variables.
	public Ranking(int id,String clubname, String leaguename, int numberoftitles) {
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
}
  

//MyStackNode.Java
public class MyStackNode {

	private Ranking datas;
	private MyStackNode next;

	public MyStackNode(Ranking data) {
		datas = data;
		next = null;
	}

	public Ranking getdatas() {
		return datas;
	}

	public MyStackNode getNext() {
		return next;
	}

	public void setdatas(Ranking datas) {
		this.datas = datas;
	}

	public void setNext(MyStackNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return datas.toString();
	}

}


//MyStack.java

public class MyStack {

	private MyStackNode top; // declare the top of the stacknide

	public void push(Ranking data) {
	    // create a new node
		MyStackNode node = new MyStackNode(data);
		if (top == null) {// if the stack is empty
			top = node; // set the node as the top of the stack
		} else {
			node.setNext(top); // set the current top node as the next node
			top = node; // set the node as the new top of the stack
		}
	}

	public Ranking peek() {
		if (top == null) {
			return null;
		} else {
			return top.getdatas();
		}
	}

	public Ranking pop() {
		if (top == null) {
			return null;
		} else {
			Ranking data = top.getdatas();// get the data from the top node
			top = top.getNext();// set the top node to the next node
			return data;
		}
	}

	public boolean isEmpty() {
		return top == null;
	}
}

//Lab28B.java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab28B {

	public static void main(String[] args) throws FileNotFoundException {
		MyStack stack = new MyStack(); // create a stack of MyClass objects
		Scanner requiredfile = new Scanner(new File("Lab28B.txt"));// create a scanner to read my file 
		while (requiredfile.hasNextLine()) {
			String line = requiredfile.nextLine();// create a string line  to read  from the line of data
			String[] clubs = line.split("\\s+");
			Ranking data = new Ranking (Integer.parseInt(clubs[0]),clubs[1],clubs[2], Integer.parseInt(clubs[3]));
			stack.push(data);// add the object to the stack
		}
		
		while(!stack.isEmpty()){// while the stack is not empty
		// remove an object from the stack
			System.out.println(stack.pop()); // print the object
		}
	}



//Lab28B.txt

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