import java. util.Scanner;
public class missing_element_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int missingElement = findMissingElement(arr, n);
        System.out.println("The missing element is: " + missingElement);
    }

    public static int findMissingElement(int[] arr, int n) {
        int totalSum = (n * (n + 1)) / 2;
        int arraySum = 0;
        for (int num : arr) {
            arraySum += num;
        }
        return totalSum - arraySum;
    }
}