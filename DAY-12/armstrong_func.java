import java.util.Scanner;
public class armstrong_func {
    public static boolean isArmstrong(int num) {
        int originalNum = num;
        int sum = 0;
        int digits = String.valueOf(num).length();

        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;
        }

        return sum == originalNum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = scanner.nextInt();
        
        if (isArmstrong(input)) {
            System.out.println(input + " is an Armstrong number.");
        } else {
            System.out.println(input + " is not an Armstrong number.");
        }
        
        scanner.close();
    }
    
}
