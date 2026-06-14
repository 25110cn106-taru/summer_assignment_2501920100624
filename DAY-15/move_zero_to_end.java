import java.util.Scanner;
public class move_zero_to_end {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Original array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int count = 0; // Count of non-zero elements
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i]; // Move non-zero element to the front
            }
        }
        while (count < arr.length) {
            arr[count++] = 0; // Fill remaining elements with zero
        }
        System.out.println("Array after moving zeros to the end:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
