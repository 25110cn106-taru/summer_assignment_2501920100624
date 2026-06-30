import java.util.ArrayList;
import java.util.Scanner;

public class ContactManagement {

    static class Contact {
        int id;
        String name;
        String phone;
        String email;

        Contact(int id, String name, String phone, String email) {
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        void display() {
            System.out.printf("| %-4d | %-18s | %-14s | %-22s |%n", id, name, phone, email);
        }
    }

    static ArrayList<Contact> contacts = new ArrayList<>();
    static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Contact Management System ===\n");

        while (running) {
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact by Name");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    contacts.add(new Contact(nextId++, name, phone, email));
                    System.out.println("Contact added successfully!\n");
                    break;

                case 2:
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts found.\n");
                    } else {
                        printHeader();
                        for (Contact c : contacts) c.display();
                        printFooter();
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine().toLowerCase();
                    boolean found = false;
                    printHeader();
                    for (Contact c : contacts) {
                        if (c.name.toLowerCase().contains(searchName)) {
                            c.display();
                            found = true;
                        }
                    }
                    printFooter();
                    if (!found) System.out.println("No matching contacts found.\n");
                    break;

                case 4:
                    System.out.print("Enter Contact ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    Contact toUpdate = findById(updateId);
                    if (toUpdate != null) {
                        System.out.print("New Name (" + toUpdate.name + "): ");
                        toUpdate.name = scanner.nextLine();
                        System.out.print("New Phone (" + toUpdate.phone + "): ");
                        toUpdate.phone = scanner.nextLine();
                        System.out.print("New Email (" + toUpdate.email + "): ");
                        toUpdate.email = scanner.nextLine();
                        System.out.println("Contact updated successfully!\n");
                    } else {
                        System.out.println("Contact not found.\n");
                    }
                    break;

                case 5:
                    System.out.print("Enter Contact ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    Contact toDelete = findById(deleteId);
                    if (toDelete != null) {
                        contacts.remove(toDelete);
                        System.out.println("Contact deleted successfully!\n");
                    } else {
                        System.out.println("Contact not found.\n");
                    }
                    break;

                case 6:
                    System.out.println("Exiting Contact Manager. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.\n");
            }
        }
        scanner.close();
    }

    static void printHeader() {
        System.out.println("+------+--------------------+----------------+------------------------+");
        System.out.println("| ID   | Name               | Phone          | Email                  |");
        System.out.println("+------+--------------------+----------------+------------------------+");
    }

    static void printFooter() {
        System.out.println("+------+--------------------+----------------+------------------------+\n");
    }

    static Contact findById(int id) {
        for (Contact c : contacts) {
            if (c.id == id) return c;
        }
        return null;
    }
} 