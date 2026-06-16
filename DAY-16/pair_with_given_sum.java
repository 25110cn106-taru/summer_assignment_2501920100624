import java.util.Scanner;
public class pair_with_given_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the target sum:");
        int targetSum = sc.nextInt();
        findPairsWithGivenSum(arr, targetSum);
    }

    public static void findPairsWithGivenSum(int[] arr, int targetSum) {
        boolean foundPair = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == targetSum) {
                    System.out.println("Pair found: (" + arr[i] + ", " + arr[j] + ")");
                    foundPair = true;
                }
            }
        }
        if (!foundPair) {
            System.out.println("No pairs found with the given sum.");
        }
    }
    
}
