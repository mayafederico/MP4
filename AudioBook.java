public class AudioBook extends Book {
    private int minutes;

    public AudioBook(String title, int numPages, int year, String authorName, boolean isAvailable, int minutes) {
        super(title, numPages, year, authorName, isAvailable);
        this.minutes = minutes;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public String bookTypeDescription() {
        String str = "An audio book. Can be converted to mp3 format. ";
        str += this.minutes;
        str += " minutes.";
        return str;
    }

    public String toString() {
        String str = "\nAUDIOBOOK";
        str += super.toString();
        str += "\nMinutes: " + String.valueOf(this.minutes);

        return str;
    }

}