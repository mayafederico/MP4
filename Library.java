import java.util.ArrayList;
import java.lang.String;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<Book>();
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    // gets book at given index
    public Book getBook(int index) {
        return this.books.get(index);
    }

    public void checkOut(int index) {
        this.books.get(index).makeUnavailable();
        System.out.println("Book checked out!");
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public String formatBookInfo(Book book) {
        String title = book.getTitle();
        String pages = String.valueOf(book.getNumPages());
        String year = String.valueOf(book.getYear());
        String author = book.getAuthorName();
        String availability = String.valueOf(book.getAvailability());

        String str = title + ";" + pages + ";" + year + ";" + author + ";" + availability + ";";

        if (book instanceof FictionBook) {
            FictionBook fiction = (FictionBook) book;
            String genre = fiction.getGenre();
            str += "Fiction-" + genre;
        }

        else if (book instanceof ChildrensBook) {
            ChildrensBook childrens = (ChildrensBook) book;
            int tempAge = childrens.getRecommendedAge();
            String age = String.valueOf(tempAge);
            str += "Children's-" + age;
        }

        else if (book instanceof AudioBook) {
            AudioBook audio = (AudioBook) book;
            int tempMinutes = audio.getMinutes();
            String minutes = String.valueOf(tempMinutes);
            str += "Audio-" + minutes;
        }

        return str;
    }

    public int searchByTitle(String title) {
        int index = 0;
        for (index = 0; index < this.books.size(); index++) {
            Book current = this.books.get(index);
            if (current.getTitle().equals(title)) {
                return index;
            }
        }

        return -1;
    }

    // sorts books alphabetically by title
    public ArrayList<Book> sortByTitle(ArrayList<Book> bookList) {
        ArrayList<Book> sortedList = new ArrayList<Book>();
        for (Book book : bookList) {
            sortedList.add(book);
        }

        for (int i = 0; i < sortedList.size() - 1; i++) {
            Book currentBook = sortedList.get(i);
            Book nextBook = sortedList.get(i+1);
            int compare = currentBook.compareTo(nextBook);

            if (compare > 0) {
                sortedList.remove(currentBook); // removes book
                sortedList.add(currentBook); // adds book to end
                i--;
            }
        }

        return sortedList;
    }

    public String toString() {
        String str = "";
        for (Book book : this.books) {
            str += "--------------------";
            str += book.toString();
            str += "\n";
        }
        return str;
    }
}