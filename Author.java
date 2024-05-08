public class Author {
    private String name;
    private ArrayList<Book> books;

    public Author() {
        this.name = "Unknown";
        this.books = new ArrayList<Book>();
    }

    public Author(String name, ArrayList<Book> books) {
        this.name = name;
        this.books = books;
    }

    // accessor methods
    public String getName() {
        return this.name;
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    // mutator methods
    public void setName(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }
}