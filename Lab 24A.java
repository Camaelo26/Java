// Macarthur Camael Diby
// Lab 24A
// create a linked list for name and input somes names to verify their presence


//create a class named  MyLinkedNode.java


public class MyLinkedNode {
    public String name; // declare string namne
    public MyLinkedNode next;

    //create a constructor that receives a string parameter
    public MyLinkedNode(String name) {
        this.name = name;
        next = null;
    }
}


//Create a class named MyLinkedList.java

public class MyLinkedList {
    
    private MyLinkedNode head, tail;
    private int size;

    // set the constructor
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    
    public void addLast(String name){
        
        MyLinkedNode camaelnode = new MyLinkedNode(name); // create a new linked node
        
        if(head == null){
            head = camaelnode;
        }else{
            //put the new node 'camaelnode' at the end of the linked list
            tail.next = camaelnode;
        }
        //put the new node 'camaelnode' as new tail
        tail = camaelnode;
       
        size++;
    }

    //method to get the first name  of the linked  list
    public String getFirst(){
        
        if(head == null){
            return null;
        }
        
        return head.name;
    }

    //method to get  the  last name  of the linked list
    public String getLast(){
        
        if(tail == null){
            return null;
        }
        
        return tail.name;
    }

    //returns a string representation of the list
    public String toString() {
        String string= ""; // create empty string
        
        for(MyLinkedNode node = head; node != null; node = node.next){
            string += node.name ;
            if(node.next!=null){
                string += ", ";
            }
        }
        return string;
    }

    //boolean method the check the presence of the name
    public boolean contains(String name){
        //iterate through the nodes
        for(MyLinkedNode node = head; node != null; node = node.next){
            // if name is there return true
            if(node.name.equals(name)){
            
                return true;
            }
        }
        //if not return false
        return false;
    }


}


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        
        MyLinkedList list = new MyLinkedList();
        Scanner required_file = new Scanner(new File("Lab24A.txt"));
       
        while (required_file.hasNext()) {
            list.addLast(required_file.nextLine());
        }
        
        required_file.close();
        
        System.out.println(list);
        
        required_file = new Scanner(System.in);
        
        System.out.print("ENTER A NAME TO VERIFY ITS PRESENCE IN THE LIST:  \n");
        String name = required_file.nextLine();
        if (list.contains(name)) {
            System.out.println(name + " is in the above list.");
        } else {
            System.out.println(name + " is not in the above list.");
        }
    }
}
