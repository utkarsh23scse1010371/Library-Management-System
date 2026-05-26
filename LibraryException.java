// Custom Exception class - demonstrates EXCEPTION HANDLING
// Handles all library-specific errors
public class LibraryException extends Exception {

    // Constructor with message
    public LibraryException(String message) {
        super(message);
    }

    // Constructor with message and cause
    public LibraryException(String message, Throwable cause) {
        super(message, cause);
    }
}
