import java.util.Scanner;
public class palindrome_func {
    public static boolean isPalindrome(String str) {
    
        //String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        str = str.toLowerCase();
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        if (isPalindrome(input)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }
        
        scanner.close();
    }
}