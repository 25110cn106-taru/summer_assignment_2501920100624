import java.util.Scanner;
public class first_repeating_character {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        char result = findFirstRepeatingChar(input);
        if (result != '\0') {
            System.out.println("The first repeating character is: " + result);
        } else {
            System.out.println("No repeating character found.");
        }
    }

    public static char findFirstRepeatingChar(String str) {
        boolean[] charSeen = new boolean[256]; // Assuming ASCII characters

        // Iterate through the string and check for repeating characters
        for (char c : str.toCharArray()) {
            if (charSeen[c]) {
                return c; // Return the first repeating character
            }
            charSeen[c] = true;
        }

        return '\0'; // Return null character if no repeating character is found
    }
}
