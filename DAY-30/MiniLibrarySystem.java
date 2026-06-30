import java.util.Scanner;

public class MiniLibrarySystem {

    static final int MAX_BOOKS = 50;
    static String[] titles = new String[MAX_BOOKS];
    static String[] authors = new String[MAX_BOOKS];
    static boolean[] issued = new boolean[MAX_BOOKS];
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Mini Library System ===\n");

        while (running) {
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Count Available/Issued Books");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (count >= MAX_BOOKS) {
                        System.out.println("Library is full!\n");
                        break;
                    }
                    System.out.print("Enter Book Title: ");
                    titles[count] = scanner.nextLine();
                    System.out.print("Enter Author Name: ");
                    authors[count] = scanner.nextLine();
                    issued[count] = false;
                    count++;
                    System.out.println("Book added successfully!\n");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No books in library.\n");
                    } else {
                        printHeader();
                        for (int i = 0; i < count; i++) printRow(i);
                        printFooter();
                    }
                    break;

                case 3:
                    System.out.print("Enter Book Title to issue: ");
                    String issueTitle = scanner.nextLine();
                    int issueIndex = findByTitle(issueTitle);
                    if (issueIndex == -1) {
                        System.out.println("Book not found.\n");
                    } else if (issued[issueIndex]) {
                        System.out.println("Book is already issued.\n");
                    } else {
                        issued[issueIndex] = true;
                        System.out.println("Book issued successfully!\n");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book Title to return: ");
                    String returnTitle = scanner.nextLine();
                    int returnIndex = findByTitle(returnTitle);
                    if (returnIndex == -1) {
                        System.out.println("Book not found.\n");
                    } else if (!issued[returnIndex]) {
                        System.out.println("Book was not issued.\n");
                    } else {
                        issued[returnIndex] = false;
                        System.out.println("Book returned successfully!\n");
                    }
                    break;

                case 5:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine().toLowerCase();
                    boolean found = false;
                    printHeader();
                    for (int i = 0; i < count; i++) {
                        if (titles[i].toLowerCase().contains(searchTitle)) {
                            printRow(i);
                            found = true;
                        }
                    }
                    printFooter();
                    if (!found) System.out.println("No matching books found.\n");
                    break;

                case 6:
                    int issuedCount = 0, availableCount = 0;
                    for (int i = 0; i < count; i++) {
                        if (issued[i]) issuedCount++;
                        else availableCount++;
                    }
                    System.out.println("Available Books: " + availableCount);
                    System.out.println("Issued Books: " + issuedCount + "\n");
                    break;

                case 7:
                    System.out.println("Exiting Library System. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.\n");
            }
        }
        scanner.close();
    }

    static int findByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (titles[i].equalsIgnoreCase(title)) return i;
        }
        return -1;
    }

    static void printHeader() {
        System.out.println("+----+--------------------------+--------------------+----------+");
        System.out.println("| No | Title                    | Author             | Status   |");
        System.out.println("+----+--------------------------+--------------------+----------+");
    }

    static void printRow(int i) {
        System.out.printf("| %-2d | %-24s | %-18s | %-8s |%n",
                (i + 1), titles[i], authors[i], (issued[i] ? "Issued" : "Available"));
    }

    static void printFooter() {
        System.out.println("+----+--------------------------+--------------------+----------+\n");
    }
}