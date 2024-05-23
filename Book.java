import java.lang.String;
import java.lang.Comparable;

public abstract class Book implements Comparable<Book> {
    private String title;
    private int numPages;
    private int year;
    private String authorName;
    private boolean isAvailable;

    public Book (String title, int numPages, int year, String authorName, boolean isAvailable) {
        this.title = title;
        this.numPages = numPages;
        this.year = year;
        this.authorName = authorName;
        this.isAvailable = isAvailable;
    }

    // accessor methods
    public String getTitle() {
        return this.title;
    }

    public int getNumPages() {
        return this.numPages;
    }

    public int getYear() {
        return this.year;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public boolean getAvailability() {
        return this.isAvailable;
    }

    public void switchAvailability() {
        if (this.isAvailable = true) {
            this.isAvailable = false;
        }

        else {
            this.isAvailable = true;
        }
    }

    public void makeUnavailable() {
        this.isAvailable = false;
    }

    public void makeAvailable() {
        this.isAvailable = true;
    }

    // abstract method
    public abstract String bookTypeDescription();


    // override compareTo method
    public int compareTo(Book other) {
        String otherTitle = other.getTitle();
        return this.title.compareTo(otherTitle);
    }

    // toString()
    public String toString() {
        String available = "";
        if (this.isAvailable == true) {
            available = "Available";
        }
        else {
            available = "Not Available";
        }

        return "\nTitle: " + this.title + "\nNumber of Pages: " + this.numPages + "\nYear: " + this.year + "\nAuthor: " + this.authorName + "\nStatus: " + available;
    }
}