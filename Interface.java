import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Integer;
import java.io.FileReader;
import java.io.FileWriter;

public class Interface {
    public static void main(String args[]) {
        
        // creates a Library object
        Library myLibrary = new Library();

        ArrayList<Book> userBooks = new ArrayList<Book>();


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
            boolean availability = Boolean.parseBoolean(tempInfo[4]); // finds book availability


            // determines the type of book (Fiction, Children's, or Audiobook)
            // and creates the corresponding object
            // then adds the book object to the library
            if (bookInfo.indexOf("Children's") > 0) {
                int index = tempInfo[5].indexOf("-");
                int len = tempInfo[5].length();
                int age = Integer.valueOf(tempInfo[5].substring(index + 1, len));
                bookType = "Children's Book";
                myLibrary.addBook((new ChildrensBook(title, pages, year, author, availability, age)));
            }

            else if (bookInfo.indexOf("Audio") > 0) {
                int index = tempInfo[5].indexOf("-");
                int len = tempInfo[5].length();
                int minutes = Integer.valueOf(tempInfo[5].substring(index + 1, len));
                myLibrary.addBook((new AudioBook(title, pages, year, author, availability, minutes)));
            }

            else if (bookInfo.indexOf("Fiction") > 0) {
                int index = tempInfo[5].indexOf("-");
                int len = tempInfo[5].length();
                String genre = tempInfo[5].substring(index + 1, len);
                myLibrary.addBook((new FictionBook(title, pages, year, author, availability, genre)));
            }
        }   // end of while loop, all books added


        // repeats process for UserBooks.txt file
        // to put the user's books into an array
        try {
            fileStream = new FileReader("UserBooks.txt");
            scnr = new Scanner(fileStream);
        }

        catch (FileNotFoundException fe) {
            System.out.println("File not found");
        }

        while (scnr.hasNextLine()) {
            String bookInfo = scnr.nextLine();
            String bookType = "";

            String[] tempInfo = bookInfo.split(";");
            String title = tempInfo[0];
            int pages = Integer.valueOf(tempInfo[1]);
            int year = Integer.valueOf(tempInfo[2]);
            String author = tempInfo[3];
            boolean availability = Boolean.parseBoolean(tempInfo[4]);

            if (bookInfo.indexOf("Children's") > 0) {
                int index = tempInfo[5].indexOf("-");
                int len = tempInfo[5].length();
                int age = Integer.valueOf(tempInfo[5].substring(index + 1, len));
                bookType = "Children's Book";
                userBooks.add((new ChildrensBook(title, pages, year, author, availability, age)));
            }

            else if (bookInfo.indexOf("Audio") > 0) {
                int index = tempInfo[5].indexOf("-");
                int len = tempInfo[5].length();
                int minutes = Integer.valueOf(tempInfo[5].substring(index + 1, len));
                userBooks.add((new AudioBook(title, pages, year, author, availability, minutes)));
            }

            else if (bookInfo.indexOf("Fiction") > 0) {
                int index = tempInfo[5].indexOf("-");
                int len = tempInfo[5].length();
                String genre = tempInfo[5].substring(index + 1, len);
                userBooks.add((new FictionBook(title, pages, year, author, availability, genre)));
            }

        }

        // closes FileReader
        try {
            fileStream.close();
            scnr.close();
        }

        catch (IOException fe) {
            System.out.println("An error occured.");
        }


        Scanner reader = new Scanner(System.in); // creates Scanner to read user input
        String input = "";
        System.out.println("\n***Digital Library***");
 
        // Menu options
        while (!(input.equals("EXIT"))) {
            System.out.println("--------------------");
            System.out.println("MENU (input a number): ");
            System.out.println("1. Search for book");
            System.out.println("2. Print Catalog");
            System.out.println("3. Checkout/Return Book");
            System.out.println("4. View your books");
            System.out.println("(Type EXIT to quit)\n");

            System.out.print("Choose an option: ");

            input = reader.nextLine();

            // Search for a book
            if (input.equals("1")) {
                System.out.println("\nSEARCH");
                System.out.println("1. Search by title");
                System.out.println("2. Search by author");
                System.out.print("Choose an option: ");

                input = reader.nextLine();

                if (input.equals("1")) {
                    System.out.print("Enter a title: ");
                    input = reader.nextLine();

                    int index = myLibrary.searchByTitle(input);

                    if (index != -1) {
                        System.out.println("Book found: ");
                        System.out.println(myLibrary.getBook(index).toString());

                        System.out.println();
                        System.out.println("Description: ");
                        System.out.println(myLibrary.getBook(index).bookTypeDescription());
                        System.out.println();
                    }

                    else {
                        System.out.println("Book not found.");
                    }
                }

                else if (input.equals("2")) {
                    System.out.print("Enter author name: ");
                    input = reader.nextLine();

                    ArrayList<Book> authorBooks = new ArrayList<Book>();
                    for (int i = 0; i < myLibrary.getBooks().size(); i++) {
                        String currentAuthor = myLibrary.getBook(i).getAuthorName();
                        if (currentAuthor.equals(input)) {
                            authorBooks.add(myLibrary.getBook(i));
                        }
                    }

                    if (authorBooks.size() == 0) {
                        System.out.println("No books found.");
                    }

                    else {
                        System.out.println("Books found: ");
                        for (int i = 0; i < authorBooks.size(); i++) {
                            System.out.println(authorBooks.get(i).toString());
                            System.out.println("--------------------");
                        }
                        System.out.println();
                    }
                }
            }

            // Prints library catalog
            else if (input.equals("2")) {
                System.out.println("\nCATALOG: ");
                System.out.println(myLibrary.toString());
            }

            // check-out/return a book
            else if (input.equals("3")) {
                System.out.println("\nOPTIONS:");
                System.out.println("1. Check-out book");
                System.out.println("2. Return book");
                System.out.print("Choose an option: ");

                input = reader.nextLine();

                if (input.equals("1")) {
                    System.out.println("Enter title of book to check-out: ");
                    input = reader.nextLine();

                    int index = myLibrary.searchByTitle(input);
                    if (index != -1) {
                        Book myBook = myLibrary.getBook(index);
                        if (myBook.getAvailability() == true) {
                            myLibrary.checkOut(index);
                            userBooks.add(myLibrary.getBook(index));
                        }

                        else {
                            System.out.println("Book unavailable.");
                        }
                    }

                    else {
                        System.out.println("Book not found.");
                    }
                }

                else if (input.equals("2")) {
                    System.out.println("Enter title of book to return: ");
                    input = reader.nextLine();

                    int index = -1;

                    for (int i = 0; i < userBooks.size(); i++) {
                        Book currentBook = userBooks.get(i);
                        String currentTitle = userBooks.get(i).getTitle();
                        if (currentTitle.equals(input)) {
                            index = i;
                        }
                    }

                    if (index != -1) {
                        int j = -1;
                        for (int i = 0; i < myLibrary.getBooks().size(); i++) {
                            String currentTitle = myLibrary.getBook(i).getTitle();
                            if (currentTitle.equals(input)) {
                                j = i;
                            }
                        }

                        myLibrary.getBook(j).makeAvailable(); // makes book available in catalog

                        userBooks.remove(index); // removes book from the user's books
                    }

                    else {
                        System.out.println("You currently do not have this book.");
                    }
                }
            }

            // View user's books
            else if (input.equals("4")) {
                System.out.println("\nYOUR BOOKS: ");
                for (int i = 0; i < userBooks.size(); i++) {
                    System.out.println(userBooks.get(i).toString());
                    System.out.println("--------------------");
                }
                System.out.println();
            }

            else if (input.equals("EXIT")) {
                break;
            }

            else {
                System.out.println("Invalid selection.");
            }
        }
        
        // sorts userBooks by title alphabetically
        userBooks = myLibrary.sortByTitle(userBooks);

        // when program ends, writes to Catalog.txt and UserBooks.txt files
        FileWriter myWriter = null;

        try {
            myWriter = new FileWriter("Catalog.txt");
            for (int i = 0; i < myLibrary.getBooks().size(); i++) {
                Book currentBook = myLibrary.getBook(i);
                String bookInfo = myLibrary.formatBookInfo(currentBook); // formats the book info
                myWriter.write(bookInfo); // writes to Catalog.txt file

                if (i < myLibrary.getBooks().size() - 1) {
                    myWriter.write("\n"); // new line
                }
            }
        }

        catch (IOException e) {
            System.out.println("An error occured - file not found.");
        }

        // FileWriter for UserBooks
        FileWriter secondWriter = null;

        try {
            secondWriter = new FileWriter("UserBooks.txt");

            if (userBooks.size() == 0) {
                secondWriter.write(""); // writes nothing if user has no books
            }

            for (int i = 0; i < userBooks.size(); i++) {
                Book currentBook = userBooks.get(i);
                String bookInfo = myLibrary.formatBookInfo(currentBook); // formats book info

                secondWriter.write(bookInfo); // writes book info to UserBooks.txt file

                if (i < userBooks.size() - 1) {
                    secondWriter.write("\n"); // new line
                }
            }
        }

        catch (IOException e) {
            System.out.println("An error occured - file not found");
        }

        // closes FileWriter objects created
        try {
            myWriter.close();
            secondWriter.close();
        }

        catch (IOException e) {
            System.out.println("An error occured when closing the file writer.");
     
        }
        
    }
}