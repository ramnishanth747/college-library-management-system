public class Library {
    // Array of Book objects to store library collection
    private Book[] books;
    private int bookCount; // Tracks currently stored count of books
    private int capacity;  // Maximum capacity of the library array

    // Constructor to set custom capacity
    public Library(int capacity) {
        this.capacity = capacity;
        this.books = new Book[capacity];
        this.bookCount = 0;
    }

    // Default constructor with standard capacity 50
    public Library() {
        this(50);
    }

    // Check if a book ID already exists
    public boolean isIdDuplicate(int bookId) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookId() == bookId) {
                return true;
            }
        }
        return false;
    }

    // Feature 1: Add a book
    public boolean addBook(int bookId, String title, String author, int totalCopies) {
        // Validation 1: Capacity check
        if (bookCount >= capacity) {
            System.out.println("[Error] Library storage is full! Cannot add more books.");
            return false;
        }

        // Validation 2: Duplicate ID check
        if (isIdDuplicate(bookId)) {
            System.out.println("[Error] A book with ID " + bookId + " already exists!");
            return false;
        }

        // Validation 3: Positive copy count check
        if (totalCopies <= 0) {
            System.out.println("[Error] Total copies must be greater than zero.");
            return false;
        }

        // Instantiate and store new Book object
        books[bookCount] = new Book(bookId, title, author, totalCopies);
        bookCount++;
        System.out.println("[Success] Book added successfully!");
        return true;
    }

    // Feature 2: Display all registered books
    public void displayAllBooks() {
        if (bookCount == 0) {
            System.out.println("[Info] No books registered in the library yet.");
            return;
        }

        System.out.println("\n======================================= REGISTERED BOOKS =======================================");
        System.out.printf("| %-8s | %-28s | %-20s | %-12s | %-16s |\n",
                "Book ID", "Title", "Author", "Total Copies", "Available Copies");
        System.out.println("------------------------------------------------------------------------------------------------");
        for (int i = 0; i < bookCount; i++) {
            books[i].displayBookDetails();
        }
        System.out.println("================================================================================================");
    }

    // Helper method: Find book index by ID
    private int findBookIndexById(int bookId) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookId() == bookId) {
                return i;
            }
        }
        return -1; // Not found
    }

    // Feature 3: Search for a book by title (case-insensitive substring/match)
    public void searchByTitle(String searchTitle) {
        if (bookCount == 0) {
            System.out.println("[Info] Library is currently empty.");
            return;
        }

        boolean found = false;
        String query = searchTitle.trim().toLowerCase();

        for (int i = 0; i < bookCount; i++) {
            // Case-insensitive title search
            if (books[i].getTitle().toLowerCase().contains(query)) {
                if (!found) {
                    System.out.println("\n---------------------------------- SEARCH RESULTS ----------------------------------");
                    System.out.printf("| %-8s | %-28s | %-20s | %-12s | %-16s |\n",
                            "Book ID", "Title", "Author", "Total Copies", "Available Copies");
                    System.out.println("------------------------------------------------------------------------------------");
                    found = true;
                }
                books[i].displayBookDetails();
            }
        }

        if (found) {
            System.out.println("------------------------------------------------------------------------------------");
        } else {
            System.out.println("[Info] No book found matching title: \"" + searchTitle + "\"");
        }
    }

    // Feature 4: Issue a book by ID
    public boolean issueBook(int bookId) {
        int index = findBookIndexById(bookId);

        if (index == -1) {
            System.out.println("[Error] Book with ID " + bookId + " does not exist in the catalog.");
            return false;
        }

        Book book = books[index];
        if (book.issueCopy()) {
            System.out.println("[Success] Book \"" + book.getTitle() + "\" issued successfully!");
            System.out.println("[Status] Remaining Available Copies: " + book.getAvailableCopies() + " / " + book.getTotalCopies());
            return true;
        } else {
            System.out.println("[Error] Cannot issue. All copies of \"" + book.getTitle() + "\" are currently issued out!");
            return false;
        }
    }

    // Feature 5: Return a book by ID
    public boolean returnBook(int bookId) {
        int index = findBookIndexById(bookId);

        if (index == -1) {
            System.out.println("[Error] Book with ID " + bookId + " does not exist in the catalog.");
            return false;
        }

        Book book = books[index];
        if (book.returnCopy()) {
            System.out.println("[Success] Book \"" + book.getTitle() + "\" returned successfully!");
            System.out.println("[Status] Updated Available Copies: " + book.getAvailableCopies() + " / " + book.getTotalCopies());
            return true;
        } else {
            System.out.println("[Error] Cannot return. All " + book.getTotalCopies() + " copies are already present in the library!");
            return false;
        }
    }

    // Getter for current book count
    public int getBookCount() {
        return bookCount;
    }
}
