public class Book {
    // Private data members (Encapsulation: data hiding)
    private int bookId;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;

    // Parameterized constructor to initialize a Book object
    public Book(int bookId, String title, String author, int totalCopies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies; // Initially, all copies are available
    }

    // Getter methods (Accessor methods)
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    // Method to issue a copy with strict stock validation
    public boolean issueCopy() {
        if (availableCopies > 0) {
            availableCopies--; // Decrease available count
            return true;
        }
        return false; // No copies currently available
    }

    // Method to return a copy with strict boundary check
    public boolean returnCopy() {
        if (availableCopies < totalCopies) {
            availableCopies++; // Increase available count
            return true;
        }
        return false; // Cannot return more copies than total stock
    }

    // Method to display book details in a clean, tabular manner
    public void displayBookDetails() {
        System.out.printf("| %-8d | %-28s | %-20s | %-12d | %-16d |\n",
                bookId, title, author, totalCopies, availableCopies);
    }
}
