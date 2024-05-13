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

    public Book checkOut(Book bookCheckedOut) {
        this.books.remove(bookCheckedOut);
        return bookCheckedOut;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public String formatBookInfo(Book book) {
        String title = book.getTitle();
        String pages = String.valueOf(book.getNumPages());
        String year = String.valueOf(book.getYear());
        String author = book.getAuthorName();

        String str = title + ";" + pages + ";" + year + ";" + author + ";";

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

    public boolean searchByTitle(String title) {
        for (int i = 0; i < this.books.size(); i++) {
            Book current = this.books.get(i);
            if (current.getTitle().equals(title)) {
                return true;
            }
        }

        return false;
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