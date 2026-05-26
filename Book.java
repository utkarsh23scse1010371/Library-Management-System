// Book class - demonstrates ENCAPSULATION using private fields + getters/setters
public class Book {

    // Private data members (Encapsulation)
    private int bookId;
    private String bookName;
    private String authorName;
    private int publicationYear;
    private boolean isAvailable; // true = Available, false = Issued

    // Constructor - initializes Book object
    public Book(int bookId, String bookName, String authorName, int publicationYear) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publicationYear = publicationYear;
        this.isAvailable = true; // New books are available by default
    }

    // ─── Getters ──────────────────────────────────────────────────────────────

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // ─── Setters ──────────────────────────────────────────────────────────────

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    // Changes availability status (Available / Issued)
    public void setAvailability(boolean available) {
        this.isAvailable = available;
    }

    // Displays book details
    public void displayBookDetails() {
        String status = isAvailable ? "✔ Available" : "✘ Issued";
        System.out.println("┌─────────────────────────────────────────┐");
        System.out.printf("│ Book ID    : %-28s│%n", bookId);
        System.out.printf("│ Book Name  : %-28s│%n", bookName);
        System.out.printf("│ Author     : %-28s│%n", authorName);
        System.out.printf("│ Year       : %-28s│%n", publicationYear);
        System.out.printf("│ Status     : %-28s│%n", status);
        System.out.println("└─────────────────────────────────────────┘");
    }
}
