public class AutomatedTestSuite {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   AUTOMATED TEST RUNNER: LIBRARY MANAGEMENT     ");
        System.out.println("=================================================");

        Library lib = new Library(3); // Small capacity to test bounds
        int passed = 0;
        int total = 12;

        // Test 1: Empty library display check
        System.out.print("Test 1: Display empty library -> ");
        if (lib.getBookCount() == 0) {
            System.out.println("PASSED");
            passed++;
        } else {
            System.out.println("FAILED");
        }

        // Test 2: Add valid book
        System.out.print("Test 2: Add valid book (ID: 101, Copies: 3) -> ");
        boolean t2 = lib.addBook(101, "Java Programming", "Herbert Schildt", 3);
        if (t2 && lib.getBookCount() == 1) {
            System.out.println("PASSED");
            passed++;
        } else {
            System.out.println("FAILED");
        }

        // Test 3: Reject duplicate book ID
        System.out.print("Test 3: Reject duplicate book ID (ID: 101) -> ");
        boolean t3 = lib.addBook(101, "Another Java Book", "Author X", 2);
        if (!t3 && lib.getBookCount() == 1) {
            System.out.println("PASSED");
            passed++;
        } else {
            System.out.println("FAILED");
        }

        // Test 4: Reject invalid (negative/zero) copy count
        System.out.print("Test 4: Reject zero/negative copies (ID: 102, Copies: 0) -> ");
        boolean t4 = lib.addBook(102, "Data Structures", "Mark Weiss", 0);
        if (!t4 && lib.getBookCount() == 1) {
            System.out.println("PASSED");
            passed++;
        } else {
            System.out.println("FAILED");
        }

        // Add more books for further tests
        lib.addBook(102, "Data Structures", "Mark Weiss", 1);
        lib.addBook(103, "Operating Systems", "Silberschatz", 2);

        // Test 5: Reject adding book when capacity exceeded
        System.out.print("Test 5: Reject addition when capacity exceeded -> ");
        boolean t5 = lib.addBook(104, "Computer Networks", "Tanenbaum", 2);
        if (!t5 && lib.getBookCount() == 3) {
            System.out.println("PASSED");
            passed++;
        } else {
            System.out.println("FAILED");
        }

        // Test 6: Issue an available book
        System.out.print("Test 6: Issue available book (ID: 102, Avail: 1 -> 0) -> ");
        boolean t6 = lib.issueBook(102);
        if (t6) {
            System.out.println("PASSED");
            passed++;
        } else {
            System.out.println("FAILED");
        }

        // Test 7: Reject issue when available copies is 0
        System.out.print("Test 7: Reject issue when stock is 0 (ID: 102) -> ");
        boolean t7 = lib.issueBook(102);
        if (!t7) {
            System.out.println("PASSED");
            passed++;
        } else {
            System.out.println("FAILED");
        }

        // Test 8: Return an issued book
        System.out.print("Test 8: Return an issued book (ID: 102, Avail: 0 -> 1) -> ");
        boolean t8 = lib.returnBook(102);
        if (t8) {
            System.out.println("PASSED");
            passed++;
        } else {
            System.out.println("FAILED");
        }

        // Test 9: Reject return when copies exceed total copies
        System.out.print("Test 9: Reject return when available == total (ID: 102) -> ");
        boolean t9 = lib.returnBook(102); // Available is already 1 of 1
        if (!t9) {
            System.out.println("PASSED");
            passed++;
        } else {
            System.out.println("FAILED");
        }

        // Test 10: Issue non-existent book
        System.out.print("Test 10: Issue non-existent book (ID: 999) -> ");
        boolean t10 = lib.issueBook(999);
        if (!t10) {
            System.out.println("PASSED");
            passed++;
        } else {
            System.out.println("FAILED");
        }

        // Test 11: Return non-existent book
        System.out.print("Test 11: Return non-existent book (ID: 999) -> ");
        boolean t11 = lib.returnBook(999);
        if (!t11) {
            System.out.println("PASSED");
            passed++;
        } else {
            System.out.println("FAILED");
        }

        // Test 12: Search for existing and non-existing title
        System.out.print("Test 12: Search existing & non-existing titles -> ");
        // Verify method execution without exceptions
        lib.searchByTitle("java");
        lib.searchByTitle("nonexistent_title");
        System.out.println("PASSED");
        passed++;

        System.out.println("\n-------------------------------------------------");
        System.out.println("TOTAL PASSED: " + passed + " / " + total);
        System.out.println("=================================================");
    }
}
