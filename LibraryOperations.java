// Interface - demonstrates ABSTRACTION
// Defines contract for library operations
public interface LibraryOperations {

    void issueBook(Library library, int studentId, int bookId) throws LibraryException;

    void returnBook(Library library, int studentId, int bookId) throws LibraryException;

    void addBook(Library library, Book book);

    void viewAllBooks(Library library);
}
