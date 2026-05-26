import java.util.ArrayList;
import java.util.List;

// Student extends Person - demonstrates INHERITANCE
public class Student extends Person {

    private static final int MAX_BORROW_LIMIT = 3;

    // Private data members (Encapsulation)
    private String department;
    private List<Book> borrowedBooks;

    // Constructor - calls super() for parent class initialization
    public Student(int id, String name, String department) {
        super(id, name); // Calls Person constructor
        this.department = department;
        this.borrowedBooks = new ArrayList<>();
    }

    // ─── Getters ──────────────────────────────────────────────────────────────

    public String getDepartment() {
        return department;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public int getBorrowedCount() {
        return borrowedBooks.size();
    }

    // ─── Setters ──────────────────────────────────────────────────────────────

    public void setDepartment(String department) {
        this.department = department;
    }

    // ─── Borrow / Return Logic ─────────────────────────────────────────────────

    public void borrowBook(Book book) throws LibraryException {
        if (borrowedBooks.size() >= MAX_BORROW_LIMIT) {
            throw new LibraryException(
                "Student '" + getName() + "' has reached the maximum borrow limit of " + MAX_BORROW_LIMIT + " books."
            );
        }
        if (!book.isAvailable()) {
            throw new LibraryException(
                "Book '" + book.getBookName() + "' is already issued to someone else."
            );
        }
        borrowedBooks.add(book);
        book.setAvailability(false);
        System.out.println("✔ Book '" + book.getBookName() + "' successfully issued to " + getName() + ".");
    }

    public void returnBook(Book book) throws LibraryException {
        boolean found = borrowedBooks.removeIf(b -> b.getBookId() == book.getBookId());
        if (!found) {
            throw new LibraryException(
                "Student '" + getName() + "' has not borrowed book '" + book.getBookName() + "'."
            );
        }
        book.setAvailability(true);
        System.out.println("✔ Book '" + book.getBookName() + "' returned successfully by " + getName() + ".");
    }

    // Method Overriding - demonstrates POLYMORPHISM
    @Override
    public void displayDetails() {
        System.out.println("┌─────────────────────────────────────────┐");
        System.out.println("│           STUDENT DETAILS               │");
        System.out.println("├─────────────────────────────────────────┤");
        System.out.printf("│ Student ID  : %-27s│%n", getId());
        System.out.printf("│ Name        : %-27s│%n", getName());
        System.out.printf("│ Department  : %-27s│%n", department);
        System.out.printf("│ Books Held  : %-27s│%n", borrowedBooks.size() + " / " + MAX_BORROW_LIMIT);
        System.out.println("├─────────────────────────────────────────┤");

        if (borrowedBooks.isEmpty()) {
            System.out.println("│ Borrowed Books: None                    │");
        } else {
            System.out.println("│ Borrowed Books:                         │");
            for (Book b : borrowedBooks) {
                System.out.printf("│   [%d] %-35s│%n", b.getBookId(), b.getBookName());
            }
        }
        System.out.println("└─────────────────────────────────────────┘");
    }
}
