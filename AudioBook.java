public class AudioBook extends Book {
    private int minutes;

    public AudioBook() {
        super();
        this.minutes = 0;
    }

    public AudioBook(String title, int numPages, int year, String authorName, int minutes) {
        super(title, numPages, year, authorName);
        this.minutes = minutes;
    }

    public String toString() {
        String str = "\nAUDIOBOOK";
        str += super.toString();
        str += "\nMinutes: " + String.valueOf(this.minutes);

        return str;
    }

}