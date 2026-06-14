import java.util.Scanner;
public class rev_array {
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
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int[] rev= new int[n];
        for (int i = 0; i < n; i++) {
            rev[i] = arr[n - 1 - i];
        }
        System.out.println("Reversed array:");
        for (int i = 0; i < n; i++) {
            System.out.print(rev[i] + " ");
        }
    }
}