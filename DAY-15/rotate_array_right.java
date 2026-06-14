import java.util.Scanner;
public class rotate_array_right {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the number of positions to rotate right: ");
        int d = sc.nextInt();
        System.out.println("Original array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[i] = arr[(i - d + n) % n];
        }
        System.out.println("Array after right rotation:");
        for (int i = 0; i < n; i++) {
            System.out.print(rotated[i] + " ");
        }
    }
}
