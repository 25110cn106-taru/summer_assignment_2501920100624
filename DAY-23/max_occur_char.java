import java.util.Scanner;
public class max_occur_char {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        char result = findMaxOccurChar(input);
        if (result != '\0') {
            System.out.println("The character that occurs the most is: " + result);
        } else {
            System.out.println("No characters found.");
        }
    }

    public static char findMaxOccurChar(String str) {
        int[] charCount = new int[256]; // Assuming ASCII characters
        char maxChar = '\0';
        int maxCount = 0;

        // Count occurrences of each character
        for (char c : str.toCharArray()) {
            charCount[c]++;
            if (charCount[c] > maxCount) {
                maxCount = charCount[c];
                maxChar = c;
            }
        }

        return maxChar;
    }
}
