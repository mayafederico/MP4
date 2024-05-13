import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.Integer;
import java.io.FileReader;

public class Interface {
    public static void main(String args[]) {
        
        // creates a Library object
        Library myLibrary = new Library();


        // creates a FileReader and Scanner
        FileReader fileStream = null;
        Scanner scnr = null;

        try {
            fileStream = new FileReader("Catalog.txt");
            scnr = new Scanner(fileStream);
        }

        catch (FileNotFoundException fe) {
            System.out.println("File not found");
        }
        
        // reads each line of the text file "Catalog.txt"
        while(scnr.hasNextLine()) {
            String bookInfo = scnr.nextLine();
            String bookType = "";

            String[] tempInfo = bookInfo.split(";"); // separates each piece of information into an array
            String title = tempInfo[0];   // finds the book title
            int pages = Integer.valueOf(tempInfo[1]);   // finds the number of pages
            int year = Integer.valueOf(tempInfo[2]);   // finds the book's year
            String author = tempInfo[3];   // finds the book's author


            // determines the type of book (Fiction, Children's, or Audiobook)
            // and creates the corresponding object
            // then adds the book object to the library
            if (bookInfo.indexOf("Children's") > 0) {
                int index = tempInfo[4].indexOf("-");
                int len = tempInfo[4].length();
                int age = Integer.valueOf(tempInfo[4].substring(index + 1, len));
                bookType = "Children's Book";
                myLibrary.addBook((new ChildrensBook(title, pages, year, author, age)));
            }

            else if (bookInfo.indexOf("Audio") > 0) {
                int index = tempInfo[4].indexOf("-");
                int len = tempInfo[4].length();
                int minutes = Integer.valueOf(tempInfo[4].substring(index + 1, len));
                myLibrary.addBook((new AudioBook(title, pages, year, author, minutes)));
            }

            else if (bookInfo.indexOf("Fiction") > 0) {
                int index = tempInfo[4].indexOf("-");
                int len = tempInfo[4].length();
                String genre = tempInfo[4].substring(index + 1, len);
                myLibrary.addBook((new FictionBook(title, pages, year, author, genre)));
            }
        }   // end of while loop, all books added

        try {
            fileStream.close();
            scnr.close();
        }

        catch (IOException fe) {
            System.out.println("An error occured.");
        }


        System.out.println("Library Catalog:");
        System.out.println(myLibrary.toString());

        System.out.println();
        ArrayList<Book> libraryCatalog = myLibrary.getBooks();
        FictionBook theLorax = (FictionBook) libraryCatalog.get(0);
        System.out.println("Book 1:" + theLorax.toString());
        System.out.println("Formatting: " + myLibrary.formatBookInfo(theLorax));
        
    }
}