import java.util.Scanner;

public class RecursiveReverseNumber {

    static int rev = 0;

    public static int reverse(int n) {
        if (n == 0)
            return rev;

        rev = rev * 10 + n % 10;

        return reverse(n / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Reversed number = " + reverse(n));

        sc.close();
    }
}
