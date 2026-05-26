import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian(1, "Admin Librarian", "LIB001");
        Scanner scanner = new Scanner(System.in);

        // Pre-load some sample data
        library.addBook(new Book(101, "Data Structures", "Mark Allen Weiss", 2020));
        library.addBook(new Book(102, "Operating Systems", "Abraham Silberschatz", 2018));
        library.addBook(new Book(103, "Database Management", "Ramez Elmasri", 2019));
        library.addBook(new Book(104, "Computer Networks", "Andrew Tanenbaum", 2021));
        library.addBook(new Book(105, "Algorithms", "Thomas Cormen", 2017));

        library.addStudent(new Student(1001, "Rahul Sharma", "Computer Science"));
        library.addStudent(new Student(1002, "Priya Singh", "Information Technology"));
        library.addStudent(new Student(1003, "Amit Kumar", "Electronics"));

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║     COLLEGE LIBRARY MANAGEMENT SYSTEM    ║");
        System.out.println("╚══════════════════════════════════════════╝");

        boolean running = true;
        while (running) {
            System.out.println("\n╔══════════════════════╗");
            System.out.println("║       MAIN MENU      ║");
            System.out.println("╠══════════════════════╣");
            System.out.println("║  1. Add Book         ║");
            System.out.println("║  2. View All Books   ║");
            System.out.println("║  3. Add Student      ║");
            System.out.println("║  4. Issue Book       ║");
            System.out.println("║  5. Return Book      ║");
            System.out.println("║  6. View Student     ║");
            System.out.println("║  7. Search by Author ║");
            System.out.println("║  8. Exit             ║");
            System.out.println("╚══════════════════════╝");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Book ID: ");
                        int bookId = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter Book Name: ");
                        String bookName = scanner.nextLine().trim();
                        System.out.print("Enter Author Name: ");
                        String author = scanner.nextLine().trim();
                        System.out.print("Enter Publication Year: ");
                        int year = Integer.parseInt(scanner.nextLine().trim());
                        librarian.addBook(library, new Book(bookId, bookName, author, year));
                    }
                    case 2 -> librarian.viewAllBooks(library);
                    case 3 -> {
                        System.out.print("Enter Student ID: ");
                        int stuId = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter Student Name: ");
                        String stuName = scanner.nextLine().trim();
                        System.out.print("Enter Department: ");
                        String dept = scanner.nextLine().trim();
                        library.addStudent(new Student(stuId, stuName, dept));
                        System.out.println("✔ Student added successfully.");
                    }
                    case 4 -> {
                        System.out.print("Enter Student ID: ");
                        int stuId = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter Book ID: ");
                        int bookId = Integer.parseInt(scanner.nextLine().trim());
                        librarian.issueBook(library, stuId, bookId);
                    }
                    case 5 -> {
                        System.out.print("Enter Student ID: ");
                        int stuId = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter Book ID: ");
                        int bookId = Integer.parseInt(scanner.nextLine().trim());
                        librarian.returnBook(library, stuId, bookId);
                    }
                    case 6 -> {
                        System.out.print("Enter Student ID: ");
                        int stuId = Integer.parseInt(scanner.nextLine().trim());
                        library.getStudentDetails(stuId);
                    }
                    case 7 -> {
                        System.out.print("Enter Author Name: ");
                        String author = scanner.nextLine().trim();
                        library.searchByAuthor(author);
                    }
                    case 8 -> {
                        System.out.println("\n╔══════════════════════════════╗");
                        System.out.println("║  Thank you! Goodbye!         ║");
                        System.out.println("╚══════════════════════════════╝");
                        running = false;
                    }
                    default -> System.out.println("✘ Invalid choice. Please enter 1-8.");
                }
            } catch (NumberFormatException e) {
                System.out.println("✘ Invalid input. Please enter a valid number.");
            } catch (LibraryException e) {
                System.out.println("✘ Library Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
