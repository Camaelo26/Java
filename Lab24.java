// Macarthur Camael Diby
// Lab 24C
// create a stack for drinks  and use the pop method



// CREATE A CLASS NAMED DRINKS.JAVA


public class Drinks {
private String drink_name;
private String container_type;
private int size;

public Drinks(String drink_name, String container_type, int size) {
this.drink_name = drink_name;
this.container_type = container_type;
this.size = size;
}

public String getdrink_name() {
return drink_name;
}

public void setdrink_name(String drink_name) {
this.drink_name = drink_name;
}

public String getcontainer_type() {
return container_type;
}

public void setcontainer_type(String container_type) {
this.container_type = container_type;
}

public int getSize() {
return size;
}

public void setSize(int size) {
this.size = size;
}

@Override
public String toString() {
return "\nDRINKS  INFORMATIONS : \n DRINK NAME : "+drink_name + ",  CONTAINER TYPE : " + container_type + ",  NUMBERS OF DRINKS : " + size+"." ;
}
}


//Create a class called MyStackNode

public class MyStackNode <A>{
private A values;
public MyStackNode<A> next;

public MyStackNode(A o) {
this.values = o;
next=null;
}

public A getValue()
{
return values;
}
}

// Create a class named MyStack



public class MyStack <A>{
private MyStackNode<A> top;
private int size;

public MyStack() {
    top=null;
    size=0;
}

public int getSize()
{
return size;
}

public boolean isEmpty()
{
return top==null;
}

public void push(A o)
{
MyStackNode<A> camelonode=new MyStackNode<>(o);

if(top==null)
top=camelonode;
else
{
camelonode.next=top;
top=camelonode;
}
size++;
}
public A peek()
{
if(top==null)
return null;
return top.getValue();
}

public A pop()
{
if(top==null)
return null;
MyStackNode<A>temp=top;
top=top.next;
return temp.getValue();
}

@Override

public String toString() {
    String returnString="";
    MyStackNode<A>temp=top;
        while(temp!=null){
            returnString+=temp.getValue().toString()+"\n";
            temp=temp.next;
        }
    return returnString;
    }
}



// import the required libaries

import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;

 
 
public class Main
{
  
public static void main (String[]args) throws FileNotFoundException
  {
    
    Scanner required_file = new Scanner (new File ("Lab24C.txt")); // create an input to read the file
    
    String name, type;
    
    int size;
     
    MyStack < Drinks > drinks_datas = new MyStack <> ();
     
        while (required_file.hasNext ())
       
             {
	
                name = required_file.next ();
	
                type = required_file.next ();
	
                size = required_file.nextInt ();
	
                drinks_datas.push (new Drinks (name, type, size));
      
            }
     
        System.out.println ("MY STACK:");
    
        System.out.println (drinks_datas);
    
 
        System.out.println ("\n remove first drink:" + drinks_datas.pop ());
    
        System.out.println (" remove second drink : " + drinks_datas.pop ());
    
 
        System.out.println ("\n after removing the first two objects: ");
    
        System.out.println (drinks_datas);
  
}

 
}
