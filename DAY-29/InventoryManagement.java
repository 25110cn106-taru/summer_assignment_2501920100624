import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagement {

    static class Item {
        int id;
        String name;
        int quantity;
        double price;

        Item(int id, String name, int quantity, double price) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        double totalValue() {
            return quantity * price;
        }

        void display() {
            System.out.printf("| %-4d | %-18s | %-8d | %-10.2f | %-12.2f |%n",
                    id, name, quantity, price, totalValue());
        }
    }

    static ArrayList<Item> items = new ArrayList<>();
    static int nextId = 1;
    static final int LOW_STOCK_THRESHOLD = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Inventory Management System ===\n");

        while (running) {
            System.out.println("1. Add Item");
            System.out.println("2. View All Items");
            System.out.println("3. Update Stock (Add/Remove)");
            System.out.println("4. Search Item by Name");
            System.out.println("5. Delete Item");
            System.out.println("6. View Low Stock Items");
            System.out.println("7. View Total Inventory Value");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Item Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter Price per Unit: Rs. ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    items.add(new Item(nextId++, name, qty, price));
                    System.out.println("Item added successfully!\n");
                    break;

                case 2:
                    if (items.isEmpty()) {
                        System.out.println("No items in inventory.\n");
                    } else {
                        printHeader();
                        for (Item i : items) i.display();
                        printFooter();
                    }
                    break;

                case 3:
                    System.out.print("Enter Item ID: ");
                    int updateId = scanner.nextInt();
                    Item toUpdate = findById(updateId);
                    if (toUpdate != null) {
                        System.out.println("1. Add Stock   2. Remove Stock");
                        System.out.print("Choose: ");
                        int stockChoice = scanner.nextInt();
                        System.out.print("Enter quantity: ");
                        int amount = scanner.nextInt();
                        if (stockChoice == 1) {
                            toUpdate.quantity += amount;
                            System.out.println("Stock added. New quantity: " + toUpdate.quantity + "\n");
                        } else if (stockChoice == 2) {
                            if (amount > toUpdate.quantity) {
                                System.out.println("Cannot remove more than available stock.\n");
                            } else {
                                toUpdate.quantity -= amount;
                                System.out.println("Stock removed. New quantity: " + toUpdate.quantity + "\n");
                            }
                        } else {
                            System.out.println("Invalid choice.\n");
                        }
                    } else {
                        System.out.println("Item not found.\n");
                    }
                    break;

                case 4:
                    System.out.print("Enter item name to search: ");
                    String searchName = scanner.nextLine().toLowerCase();
                    boolean found = false;
                    printHeader();
                    for (Item i : items) {
                        if (i.name.toLowerCase().contains(searchName)) {
                            i.display();
                            found = true;
                        }
                    }
                    printFooter();
                    if (!found) System.out.println("No matching items found.\n");
                    break;

                case 5:
                    System.out.print("Enter Item ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    Item toDelete = findById(deleteId);
                    if (toDelete != null) {
                        items.remove(toDelete);
                        System.out.println("Item deleted successfully!\n");
                    } else {
                        System.out.println("Item not found.\n");
                    }
                    break;

                case 6:
                    System.out.println("--- Low Stock Items (< " + LOW_STOCK_THRESHOLD + ") ---");
                    boolean anyLow = false;
                    printHeader();
                    for (Item i : items) {
                        if (i.quantity < LOW_STOCK_THRESHOLD) {
                            i.display();
                            anyLow = true;
                        }
                    }
                    printFooter();
                    if (!anyLow) System.out.println("No low stock items.\n");
                    break;

                case 7:
                    double totalValue = 0;
                    for (Item i : items) totalValue += i.totalValue();
                    System.out.printf("Total Inventory Value: Rs. %.2f%n%n", totalValue);
                    break;

                case 8:
                    System.out.println("Exiting Inventory System. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.\n");
            }
        }
        scanner.close();
    }

    static void printHeader() {
        System.out.println("+------+--------------------+----------+------------+--------------+");
        System.out.println("| ID   | Item Name          | Quantity | Price/Unit | Total Value  |");
        System.out.println("+------+--------------------+----------+------------+--------------+");
    }

    static void printFooter() {
        System.out.println("+------+--------------------+----------+------------+--------------+\n");
    }

    static Item findById(int id) {
        for (Item i : items) {
            if (i.id == id) return i;
        }
        return null;
    }
}-+