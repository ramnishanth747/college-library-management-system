import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(100); // Standard capacity for college library microproject

        System.out.println("==========================================================");
        System.out.println("       WELCOME TO COLLEGE LIBRARY MANAGEMENT SYSTEM       ");
        System.out.println("==========================================================");

        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Enter your choice (1-6): ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear newline buffer
            } else {
                System.out.println("[Warning] Invalid input! Please enter a numeric choice between 1 and 6.");
                scanner.nextLine(); // Discard the invalid token
                continue;
            }

            switch (choice) {
                case 1:
                    handleAddBook(library, scanner);
                    break;
                case 2:
                    library.displayAllBooks();
                    break;
                case 3:
                    handleSearchBook(library, scanner);
                    break;
                case 4:
                    handleIssueBook(library, scanner);
                    break;
                case 5:
                    handleReturnBook(library, scanner);
                    break;
                case 6:
                    System.out.println("\nThank you for using College Library Management System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("[Warning] Invalid choice! Please select an option from 1 to 6.");
            }
        }

        scanner.close();
    }

    // Displays the main console menu
    private static void displayMenu() {
        System.out.println("\n----------------- LIBRARY MENU -----------------");
        System.out.println("1. Add New Book");
        System.out.println("2. Display All Books");
        System.out.println("3. Search Book by Title");
        System.out.println("4. Issue Book");
        System.out.println("5. Return Book");
        System.out.println("6. Exit");
        System.out.println("------------------------------------------------");
    }

    // Handles user input and validation for adding a book
    private static void handleAddBook(Library library, Scanner scanner) {
        System.out.println("\n--- Add New Book ---");

        System.out.print("Enter Book ID (positive integer): ");
        if (!scanner.hasNextInt()) {
            System.out.println("[Error] Invalid Book ID! It must be a positive integer.");
            scanner.nextLine(); // Clear invalid input
            return;
        }
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        if (bookId <= 0) {
            System.out.println("[Error] Book ID must be a positive number.");
            return;
        }

        if (library.isIdDuplicate(bookId)) {
            System.out.println("[Error] A book with ID " + bookId + " already exists!");
            return;
        }

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("[Error] Book title cannot be empty.");
            return;
        }

        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine().trim();
        if (author.isEmpty()) {
            System.out.println("[Error] Author name cannot be empty.");
            return;
        }

        System.out.print("Enter Total Copies: ");
        if (!scanner.hasNextInt()) {
            System.out.println("[Error] Invalid input! Total copies must be an integer.");
            scanner.nextLine();
            return;
        }
        int totalCopies = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        library.addBook(bookId, title, author, totalCopies);
    }

    // Handles book search prompt
    private static void handleSearchBook(Library library, Scanner scanner) {
        System.out.println("\n--- Search Book by Title ---");
        System.out.print("Enter title or keywords to search: ");
        String searchTitle = scanner.nextLine().trim();

        if (searchTitle.isEmpty()) {
            System.out.println("[Warning] Search term cannot be blank.");
            return;
        }

        library.searchByTitle(searchTitle);
    }

    // Handles book issuance prompt
    private static void handleIssueBook(Library library, Scanner scanner) {
        System.out.println("\n--- Issue Book ---");
        System.out.print("Enter Book ID to issue: ");

        if (!scanner.hasNextInt()) {
            System.out.println("[Error] Invalid input! Book ID must be an integer.");
            scanner.nextLine();
            return;
        }

        int bookId = scanner.nextInt();
        scanner.nextLine();

        library.issueBook(bookId);
    }

    // Handles book return prompt
    private static void handleReturnBook(Library library, Scanner scanner) {
        System.out.println("\n--- Return Book ---");
        System.out.print("Enter Book ID to return: ");

        if (!scanner.hasNextInt()) {
            System.out.println("[Error] Invalid input! Book ID must be an integer.");
            scanner.nextLine();
            return;
        }

        int bookId = scanner.nextInt();
        scanner.nextLine();

        library.returnBook(bookId);
    }
}
