// Librarian extends Person - demonstrates INHERITANCE
// Implements LibraryOperations - demonstrates ABSTRACTION (interface implementation)
public class Librarian extends Person implements LibraryOperations {

    // Private data member (Encapsulation)
    private String employeeCode;

    // Constructor
    public Librarian(int id, String name, String employeeCode) {
        super(id, name); // Calls Person constructor
        this.employeeCode = employeeCode;
    }

    // ─── Getter / Setter ──────────────────────────────────────────────────────

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    // ─── LibraryOperations Interface Methods ───────────────────────────────────

    @Override
    public void addBook(Library library, Book book) {
        library.addBook(book);
        System.out.println("✔ Book '" + book.getBookName() + "' added to library.");
    }

    @Override
    public void viewAllBooks(Library library) {
        library.displayAllBooks();
    }

    @Override
    public void issueBook(Library library, int studentId, int bookId) throws LibraryException {
        Student student = library.findStudentById(studentId);
        Book book = library.findBookById(bookId);
        student.borrowBook(book);
    }

    @Override
    public void returnBook(Library library, int studentId, int bookId) throws LibraryException {
        Student student = library.findStudentById(studentId);
        Book book = library.findBookById(bookId);
        student.returnBook(book);
    }

    // Method Overriding - demonstrates POLYMORPHISM
    @Override
    public void displayDetails() {
        System.out.println("┌─────────────────────────────────────────┐");
        System.out.println("│          LIBRARIAN DETAILS              │");
        System.out.println("├─────────────────────────────────────────┤");
        System.out.printf("│ Librarian ID  : %-25s│%n", getId());
        System.out.printf("│ Name          : %-25s│%n", getName());
        System.out.printf("│ Employee Code : %-25s│%n", employeeCode);
        System.out.println("└─────────────────────────────────────────┘");
    }
}
