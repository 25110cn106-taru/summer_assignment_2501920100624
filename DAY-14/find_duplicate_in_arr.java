import java.util.Scanner;
public class find_duplicate_in_arr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        findDuplicates(arr);
        sc.close();
    }

    public static void findDuplicates(int[] arr) {
        boolean hasDuplicates = false;
        System.out.println("Duplicate elements in the array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[i]);
                    hasDuplicates = true;
                    break; // Break to avoid printing the same duplicate multiple times
                }
            }
        }
        if (!hasDuplicates) {
            System.out.println("No duplicate elements found in the array.");
        }
    }
}