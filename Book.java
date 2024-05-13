public abstract class Book {
    private String title;
    private int numPages;
    private int year;
    private String authorName;

    public Book() {
        this.title = "Unknown";
        this.numPages = 0;
        this.year = 0;
        this.authorName = "Unknown";
    }

    public Book (String title, int numPages, int year, String authorName) {
        this.title = title;
        this.numPages = numPages;
        this.year = year;
        this.authorName = authorName;
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

    // mutator methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    // toString()
    public String toString() {
        return "\nTitle: " + this.title + "\nNumber of Pages: " + this.numPages + "\nYear: " + this.year + "\nAuthor: " + this.authorName;
    }
}