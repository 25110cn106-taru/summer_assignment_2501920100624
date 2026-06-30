import java.util.ArrayList;
import java.util.Scanner;

public class TicketBookingSystem {

    static final int TOTAL_SEATS = 20;
    static boolean[] seats = new boolean[TOTAL_SEATS + 1]; // index 1-20

    static class Ticket {
        int ticketId;
        String passengerName;
        int seatNumber;
        String destination;
        double fare;

        Ticket(int ticketId, String passengerName, int seatNumber, String destination, double fare) {
            this.ticketId = ticketId;
            this.passengerName = passengerName;
            this.seatNumber = seatNumber;
            this.destination = destination;
            this.fare = fare;
        }

        void display() {
            System.out.printf("| %-6d | %-18s | %-4d | %-15s | %-8.2f |%n",
                    ticketId, passengerName, seatNumber, destination, fare);
        }
    }

    static ArrayList<Ticket> tickets = new ArrayList<>();
    static int nextTicketId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Ticket Booking System ===");
        System.out.println("Total Seats Available: " + TOTAL_SEATS + "\n");

        while (running) {
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View All Bookings");
            System.out.println("4. View Available Seats");
            System.out.println("5. Search Ticket by ID");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Passenger Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Destination: ");
                    String destination = scanner.nextLine();
                    System.out.print("Enter Fare: Rs. ");
                    double fare = scanner.nextDouble();

                    int seatNum = getAvailableSeat();
                    if (seatNum == -1) {
                        System.out.println("Sorry, no seats available!\n");
                    } else {
                        seats[seatNum] = true;
                        Ticket t = new Ticket(nextTicketId++, name, seatNum, destination, fare);
                        tickets.add(t);
                        System.out.println("Ticket booked successfully!");
                        System.out.println("Ticket ID: " + t.ticketId + " | Seat No: " + seatNum + "\n");
                    }
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    int cancelId = scanner.nextInt();
                    scanner.nextLine();
                    Ticket toCancel = findTicket(cancelId);
                    if (toCancel != null) {
                        seats[toCancel.seatNumber] = false;
                        tickets.remove(toCancel);
                        System.out.println("Ticket cancelled successfully! Seat " + toCancel.seatNumber + " is now free.\n");
                    } else {
                        System.out.println("Ticket not found.\n");
                    }
                    break;

                case 3:
                    if (tickets.isEmpty()) {
                        System.out.println("No bookings found.\n");
                    } else {
                        printHeader();
                        for (Ticket t : tickets) t.display();
                        printFooter();
                    }
                    break;

                case 4:
                    System.out.print("Available Seats: ");
                    boolean any = false;
                    for (int i = 1; i <= TOTAL_SEATS; i++) {
                        if (!seats[i]) {
                            System.out.print(i + " ");
                            any = true;
                        }
                    }
                    if (!any) System.out.print("None");
                    System.out.println("\n");
                    break;

                case 5:
                    System.out.print("Enter Ticket ID: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();
                    Ticket found = findTicket(searchId);
                    if (found != null) {
                        printHeader();
                        found.display();
                        printFooter();
                    } else {
                        System.out.println("Ticket not found.\n");
                    }
                    break;

                case 6:
                    System.out.println("Exiting Ticket Booking System. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.\n");
            }
        }
        scanner.close();
    }

    static int getAvailableSeat() {
        for (int i = 1; i <= TOTAL_SEATS; i++) {
            if (!seats[i]) return i;
        }
        return -1;
    }

    static void printHeader() {
        System.out.println("+--------+--------------------+------+-----------------+----------+");
        System.out.println("| ID     | Passenger          | Seat | Destination     | Fare     |");
        System.out.println("+--------+--------------------+------+-----------------+----------+");
    }

    static void printFooter() {
        System.out.println("+--------+--------------------+------+-----------------+----------+\n");
    }

    static Ticket findTicket(int id) {
        for (Ticket t : tickets) {
            if (t.ticketId == id) return t;
        }
        return null;
    }
}