//Macarthur Diby
//Lab20B
// code that permits us to get more details about some specifics books and use them.





import java.util.Stack; 
import java.io.*;

// set a class  Book with its parameters
class Book {
    
    private String booktitle;
     private String bookauthor;
    private int numberofpagesinbook;

    
    public Book(String booktitle, String bookauthor, int numberofpagesinbook) {
        
        this.booktitle = booktitle;
        this.bookauthor = bookauthor;
        this.numberofpagesinbook = numberofpagesinbook;
    }

    // return the numbers of pages in the books
    public int getnumberofpagesinbook() { return numberofpagesinbook; }

    //  returns the book's title
    public String getbooktitle() { return booktitle; }

    // method named toString that returns a string with each instance variable value and a label in front of each. 
    public String toString() {
        return "title: "+booktitle+", author: "+bookauthor+", Numbers of Pages: "+numberofpagesinbook;
    }
}

public class Main {
    
    static void readIn(Stack<Book> books) {
        int readnumberofpagesinbook = 0;

        // number of books 
        System.out.println("Number of Books: "+books.size());

        
        System.out.println("Books Read in Challenge.");
        // iterate through the  books received
        for(int i=0; i<books.size(); i++) {
            
            Book readBook = books.pop();
            
            System.out.println(readBook);
            
            readnumberofpagesinbook += readBook.getnumberofpagesinbook();

            //a challenge to read 800 pages this month.This method will take one book from the top of the stack at a time and keep track of the total number of pages read.  It should stop when the total is >= 800 pages, and the other books will remain in the stack.  

            if(readnumberofpagesinbook >= 800)
                break;
        }

        // print the  numbers of pages read
        System.out.println("Number of pages read: "+readnumberofpagesinbook);
        System.out.println();
    }
    
    // main method
    public static void main(String[] args) {
        
        Stack<Book> books = new Stack<>();

        try {
            // read the file
            BufferedReader br = new BufferedReader(new FileReader("Lab20B.txt"));
            String line;

            // read by line
            while((line = br.readLine()) != null) {
                
                String[] tokens = line.split(",");
                Book b = new Book(tokens[0], tokens[1], Integer.parseInt(tokens[2]));

                books.push(b);
            }
        }catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        
        System.out.println("The books present in the stack :");
        
        for(Book b : books)
            System.out.println(b);
        
        System.out.println();

        
        readIn(books);

        // print the current stack of books 
         
        System.out.println("The books lefts :")
        // iterate through the current stack of books & print each book
        for(Book b : books)
            System.out.println(b);
    }
}