import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagement {

    static class Book {
        int id;
        String title;
        String author;
        boolean isIssued;
        String issuedTo;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.isIssued = false;
            this.issuedTo = "-";
        }

        void display() {
            System.out.printf("| %-4d | %-20s | %-15s | %-8s | %-12s |%n",
                    id, title, author, (isIssued ? "Issued" : "Available"), issuedTo);
        }
    }

    static ArrayList<Book> books = new ArrayList<>();
    static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Library Management System ===\n");

        while (running) {
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    books.add(new Book(nextId++, title, author));
                    System.out.println("Book added successfully!\n");
                    break;

                case 2:
                    if (books.isEmpty()) {
                        System.out.println("No books in library.\n");
                    } else {
                        printHeader();
                        for (Book b : books) b.display();
                        printFooter();
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = scanner.nextInt();
                    scanner.nextLine();
                    Book toIssue = findById(issueId);
                    if (toIssue == null) {
                        System.out.println("Book not found.\n");
                    } else if (toIssue.isIssued) {
                        System.out.println("Book is already issued.\n");
                    } else {
                        System.out.print("Enter Borrower Name: ");
                        String borrower = scanner.nextLine();
                        toIssue.isIssued = true;
                        toIssue.issuedTo = borrower;
                        System.out.println("Book issued successfully!\n");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = scanner.nextInt();
                    scanner.nextLine();
                    Book toReturn = findById(returnId);
                    if (toReturn == null) {
                        System.out.println("Book not found.\n");
                    } else if (!toReturn.isIssued) {
                        System.out.println("Book was not issued.\n");
                    } else {
                        toReturn.isIssued = false;
                        toReturn.issuedTo = "-";
                        System.out.println("Book returned successfully!\n");
                    }
                    break;

                case 5:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine().toLowerCase();
                    boolean found = false;
                    printHeader();
                    for (Book b : books) {
                        if (b.title.toLowerCase().contains(searchTitle)) {
                            b.display();
                            found = true;
                        }
                    }
                    printFooter();
                    if (!found) System.out.println("No matching books found.\n");
                    break;

                case 6:
                    System.out.print("Enter Book ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    Book toDelete = findById(deleteId);
                    if (toDelete != null) {
                        books.remove(toDelete);
                        System.out.println("Book deleted successfully!\n");
                    } else {
                        System.out.println("Book not found.\n");
                    }
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

    static void printHeader() {
        System.out.println("+------+----------------------+-----------------+----------+--------------+");
        System.out.println("| ID   | Title                | Author          | Status   | Issued To    |");
        System.out.println("+------+----------------------+-----------------+----------+--------------+");
    }

    static void printFooter() {
        System.out.println("+------+----------------------+-----------------+----------+--------------+\n");
    }

    static Book findById(int id) {
        for (Book b : books) {
            if (b.id == id) return b;
        }
        return null;
    }
}