import java.lang.String;

public class FictionBook extends Book {
    private String genre;

    public FictionBook(String title, int numPages, int year, String authorName, boolean isAvailable, String genre) {
        super(title, numPages, year, authorName, isAvailable);
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre;
    }

    public String bookTypeDescription() {
        String str = "A fiction book. Genre: ";
        str += this.genre;
        return str;
    }

    public String toString() {
        String str = "\nFICTION BOOK";
        str += super.toString();
        str += "\nGenre: " + genre;

        return str;
    }
}