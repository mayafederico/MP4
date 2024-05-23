# MP4
MP4 project
Course: CPSC 231
Group Members: Maya Federico, Zach Colby, Margo Burbank

Sources: Stack Overflow for syntax
Includes: Book.java, AudioBook.java, ChildrensBook.java, FictionBook.java, Library.java, Interface.java, Catalog.txt, UserBooks.txt

Class Overviews:

Book.java: Represents a book object
- abstract method
- member variables:
  - title (String)
  - numPages (int)
  - year (int)
  - authorName (String)
  - isAvailable (boolean)
- includes accessor methods for all member variables
- has methods to toggle availability of book
- has an abstract method bookTypeDescription() that is implemented in subclasses
- implements the Comparable interface to compare another book object by title (alphabetically)
- includes toString() method

AudioBook.java: Extends the Book class to an Audiobook
- subclass of Book class
- new member variable: minutes (int)
- new accessor method getMinutes()
- implements bookTypeDescription()
- overrides toString() method

ChildrensBook.java: Extends the Book class to a ChildrensBook
- subclass of Book class
- new member variable: recommendedAge (int)
- new accessor method: getRecommendedAge()
- implements bookTypeDescription()
- overrides toString() method

FictionBook.java: Extends the Book class to a FictionBook
- subclass of Book class
- new member variable: genre (String)
- new accessor method: getGenre()
- implements bookTypeDescription()
- overrides toString() method

Library.java: Manages a collection of books
- only member variable is an ArrayList of Book objects called books
- methods:
  - getBooks(): gets the ArrayList of Book objects
  - getBook(int index): takes an int as an argument and returns the book at the given index in the Library's books ArrayList
  - checkOut(int index): uses the index argument to make the book being checked out unavailable and prints the corresponding confirmation message
  - addBook(Book book): Allows the user to add a book to the library
  - formatBookInfo(Book book): takes a Book object as the argument and returns a string with the information of the book. Used for writing to the UserBooks.txt file
  - searchByTitle(String title): returns the index of the Book in the Library's book ArrayList, given a title (as a string)
  - sortByTitle(ArrayList<Book> booklist): takes an ArrayList of Books as an argument and returns an ArrayList with the same books, but sorted alphabetically by title
  - overrides toString() method
 
Interface.java: Presents a menu to the user with different options.
- sets up by using FileReader and Scanner to read book information from Catalog.txt and UserBooks.txt, and creates book objects with that information to add to the ArrayList in myLibrary and the ArrayList userBooks, respectively.
- After setup, gives user options to search for books, print the catalog, check-out or return books, and view their books
  - while the program is still reading user input, changes are only made through the book list in myLibrary and the userBooks list; changes are not made to the file until the user decides to exit the program
- Once the user decides to exit the program, their list of books userBooks is sorted by title. The only changes made to the ArrayList in myLibrary are whether or not each book is available
  - with these changes, two FileWriter objects are created to write the new information to Catalog.txt and UserBooks.txt files

Final Notes:
- try/catch methods are needed when creating FileReader, FileWriter, and Scanner objects, as well as when they are closed
- Logic errors in user input are accounted for as well, such as if a user tries to return a book they do not have or check out a book that is unavailable (statements are printed to the console to imform the user of the issue)
- In the intial state (as of submission), there are 3 books in the library catalog, one of which is checked out and present in the user's books. This means that there should be one line of text in the UserBooks.txt file
