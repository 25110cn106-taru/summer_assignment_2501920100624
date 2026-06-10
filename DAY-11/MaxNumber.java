import java.util.Scanner;

public class MaxNumber {

    static int findMax(int n, Scanner sc) {
        int max = sc.nextInt();

        for (int i = 2; i <= n; i++) {
            int num = sc.nextInt();

            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many numbers: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " numbers:");
        int max = findMax(n, sc);

        System.out.println("Maximum number = " + max);

        sc.close();
    }
}
