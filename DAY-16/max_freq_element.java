import java.util.Scanner;
public class max_freq_element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int maxFreqElement = findMaxFreqElement(arr);
        System.out.println("The element with the maximum frequency is: " + maxFreqElement);
    }

    public static int findMaxFreqElement(int[] arr) {
        int maxCount = 0;
        int maxFreqElement = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxFreqElement = arr[i];
            }
        }
        return maxFreqElement;
    }
    
}
