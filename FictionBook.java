import java.lang.String;

public class FictionBook extends Book {
    private String genre;

    public FictionBook() {
        super();
        this.genre = "Unknown";
    }

    public FictionBook(String title, int numPages, int year, String authorName, String genre) {
        super(title, numPages, year, authorName);
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre;
    }

    public String toString() {
        String str = "\nFICTION BOOK";
        str += super.toString();
        str += "\nGenre: " + genre;

        return str;
    }
}