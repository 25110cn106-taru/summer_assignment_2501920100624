import java.util.Scanner;
public class fibonacci_func {
    
    public static int fibonacci(int n) {
       if (n <= 1) {
        return n;
    }

    int a = 0, b = 1;

    for (int i = 2; i <= n; i++) {
        int c = a + b;
        a = b;
        b = c;
    }

    return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the position in the Fibonacci sequence: ");
        int input = scanner.nextInt();
        
        int result = fibonacci(input);
        System.out.println("The " + input + "th Fibonacci number is: " + result);
        
        scanner.close();
    }
}
