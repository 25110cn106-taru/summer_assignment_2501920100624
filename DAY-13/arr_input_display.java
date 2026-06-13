import java.util.Scanner;
public class arr_input_display {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int[] arr = new int[100]; 
        System.out.println("Enter no. of integers:");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " integers:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("You entered:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        sc.close();
    }
}