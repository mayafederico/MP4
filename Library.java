import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<Book>();
    }

    public Book checkOut(Book bookCheckedOut) {
        this.books.remove(bookCheckedOut);
        return bookCheckedOut;
    }

    public void addBook(Book book) {
        this.books.add(book);
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