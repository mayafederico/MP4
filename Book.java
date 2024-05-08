public class Book {
    private String title;
    private int numPages;
    private int year;
    private String authorName;
    private double cost;

    public Book() {
        this.title = "Unknown";
        this.numPages = 0;
        this.year = 0;
        this.author = "Unknown";
        this.cost = 0.00;
    }

    public Book (String title, int numPages, int year, String authorName, double cost) {
        this.title = title;
        this.numPages = numPages;
        this.year = year;
        this.author = author;
        this.cost = cost;
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
        return this.author;
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

    public void setCost(double cost) {
        this.cost = cost;
    }

    // toString()
    public String toString() {
        return "Title: " + this.title + "\nNumber of Pages: " + this.numPages + "\nYear: " + this.year + "\nAuthor: " + this.authorName + "\nCost: " + this.cost;
    }
}