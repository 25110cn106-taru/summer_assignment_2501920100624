import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperationsSystem {

    static int[] arr = new int[100];
    static int size = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Menu-Driven Array Operations System ===\n");

        while (running) {
            System.out.println("1. Insert Elements");
            System.out.println("2. Display Array");
            System.out.println("3. Find Maximum");
            System.out.println("4. Find Minimum");
            System.out.println("5. Calculate Sum & Average");
            System.out.println("6. Sort Array (Ascending)");
            System.out.println("7. Sort Array (Descending)");
            System.out.println("8. Search Element");
            System.out.println("9. Reverse Array");
            System.out.println("10. Count Even & Odd Numbers");
            System.out.println("11. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of elements: ");
                    size = scanner.nextInt();
                    System.out.println("Enter " + size + " elements:");
                    for (int i = 0; i < size; i++) {
                        arr[i] = scanner.nextInt();
                    }
                    System.out.println("Elements inserted successfully!\n");
                    break;

                case 2:
                    if (!checkArray()) break;
                    System.out.print("Array: ");
                    for (int i = 0; i < size; i++) System.out.print(arr[i] + " ");
                    System.out.println("\n");
                    break;

                case 3:
                    if (!checkArray()) break;
                    int max = arr[0];
                    for (int i = 1; i < size; i++) if (arr[i] > max) max = arr[i];
                    System.out.println("Maximum Element: " + max + "\n");
                    break;

                case 4:
                    if (!checkArray()) break;
                    int min = arr[0];
                    for (int i = 1; i < size; i++) if (arr[i] < min) min = arr[i];
                    System.out.println("Minimum Element: " + min + "\n");
                    break;

                case 5:
                    if (!checkArray()) break;
                    int sum = 0;
                    for (int i = 0; i < size; i++) sum += arr[i];
                    double avg = (double) sum / size;
                    System.out.println("Sum: " + sum);
                    System.out.printf("Average: %.2f%n%n", avg);
                    break;

                case 6:
                    if (!checkArray()) break;
                    int[] ascArr = Arrays.copyOf(arr, size);
                    Arrays.sort(ascArr);
                    System.out.print("Sorted (Ascending): ");
                    for (int v : ascArr) System.out.print(v + " ");
                    System.out.println("\n");
                    break;

                case 7:
                    if (!checkArray()) break;
                    int[] descArr = Arrays.copyOf(arr, size);
                    Arrays.sort(descArr);
                    System.out.print("Sorted (Descending): ");
                    for (int i = descArr.length - 1; i >= 0; i--) System.out.print(descArr[i] + " ");
                    System.out.println("\n");
                    break;

                case 8:
                    if (!checkArray()) break;
                    System.out.print("Enter element to search: ");
                    int key = scanner.nextInt();
                    boolean foundFlag = false;
                    for (int i = 0; i < size; i++) {
                        if (arr[i] == key) {
                            System.out.println("Element " + key + " found at index " + i + "\n");
                            foundFlag = true;
                            break;
                        }
                    }
                    if (!foundFlag) System.out.println("Element not found.\n");
                    break;

                case 9:
                    if (!checkArray()) break;
                    System.out.print("Reversed Array: ");
                    for (int i = size - 1; i >= 0; i--) System.out.print(arr[i] + " ");
                    System.out.println("\n");
                    break;

                case 10:
                    if (!checkArray()) break;
                    int evenCount = 0, oddCount = 0;
                    for (int i = 0; i < size; i++) {
                        if (arr[i] % 2 == 0) evenCount++;
                        else oddCount++;
                    }
                    System.out.println("Even Numbers: " + evenCount);
                    System.out.println("Odd Numbers: " + oddCount + "\n");
                    break;

                case 11:
                    System.out.println("Exiting. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.\n");
            }
        }
        scanner.close();
    }

    static boolean checkArray() {
        if (size == 0) {
            System.out.println("Array is empty! Please insert elements first.\n");
            return false;
        }
        return true;
    }
}
