import java.lang.String;

public class ChildrensBook extends Book {
    private int recommendedAge;

    public ChildrensBook(String title, int numPages, int year, String authorName, boolean isAvailable, int recommendedAge) {
        super(title, numPages, year, authorName, isAvailable);
        this.recommendedAge = recommendedAge;
    }

    public int getRecommendedAge() {
        return this.recommendedAge;
    }

    public String bookTypeDescription() {
        String str = "A children's book. Good for early readers or parents to read to their kids.\nRecommended for ages ";
        str += this.recommendedAge;
        str += " and up.";
        return str;
    }

    public String toString() {
        String str = "\nCHILDREN'S BOOK";
        str += super.toString();
        str += "\nRecommended Age: " + String.valueOf(this.recommendedAge);
        
        return str;
    }
}