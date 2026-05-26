import java.util.ArrayList;
import java.util.List;

// Library class - central hub for all data
public class Library {

    // Private collections (Encapsulation)
    private List<Book> books;
    private List<Student> students;
    private String libraryName;

    // Constructor
    public Library() {
        this.libraryName = "College Library";
        this.books = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    // ─── Getters ──────────────────────────────────────────────────────────────

    public String getLibraryName() {
        return libraryName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Student> getStudents() {
        return students;
    }

    // ─── Book Operations ──────────────────────────────────────────────────────

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        System.out.println("\n╔══════════════════════════════════════════════════════════════════════╗");
        System.out.printf( "║  %-68s║%n", libraryName.toUpperCase() + " - ALL BOOKS");
        System.out.println("╠══════╦══════════════════════════╦═══════════════════════╦════════════╣");
        System.out.println("║  ID  ║ Book Name                ║ Author                ║ Status     ║");
        System.out.println("╠══════╬══════════════════════════╬═══════════════════════╬════════════╣");
        for (Book b : books) {
            String status = b.isAvailable() ? "Available" : "Issued";
            System.out.printf("║ %-4d ║ %-24s ║ %-21s ║ %-10s ║%n",
                b.getBookId(),
                truncate(b.getBookName(), 24),
                truncate(b.getAuthorName(), 21),
                status
            );
        }
        System.out.println("╚══════╩══════════════════════════╩═══════════════════════╩════════════╝");
        System.out.println("  Total Books: " + books.size());
    }

    // Find book by ID - throws exception if not found (Exception Handling)
    public Book findBookById(int bookId) throws LibraryException {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                return b;
            }
        }
        throw new LibraryException("Book with ID " + bookId + " not found in the library.");
    }

    // ─── Student Operations ───────────────────────────────────────────────────

    public void addStudent(Student student) {
        students.add(student);
    }

    // Find student by ID - throws exception if not found (Exception Handling)
    public Student findStudentById(int studentId) throws LibraryException {
        for (Student s : students) {
            if (s.getId() == studentId) {
                return s;
            }
        }
        throw new LibraryException("Student with ID " + studentId + " not found.");
    }

    public void getStudentDetails(int studentId) throws LibraryException {
        Student student = findStudentById(studentId);
        student.displayDetails();
    }

    // ─── Search Operations (Optional Feature) ─────────────────────────────────

    public void searchByAuthor(String authorName) {
        System.out.println("\nSearch results for author: \"" + authorName + "\"");
        boolean found = false;
        for (Book b : books) {
            if (b.getAuthorName().toLowerCase().contains(authorName.toLowerCase())) {
                b.displayBookDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by author '" + authorName + "'.");
        }
    }

    // ─── Utility ──────────────────────────────────────────────────────────────

    private String truncate(String text, int maxLen) {
        if (text.length() <= maxLen) return text;
        return text.substring(0, maxLen - 1) + "…";
    }
}
