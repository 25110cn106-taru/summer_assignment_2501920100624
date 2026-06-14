import java.util.Scanner;
public class frequency_of_element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the element to find its frequency: ");
        int key = sc.nextInt();
        int f = countFreq(arr, key);
        System.out.println("The frequency of " + key + " is: " + f);
        sc.close();
    }

    public static int countFreq(int[] arr, int key) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                count++;
            }
        }
        return count;
    }
}
