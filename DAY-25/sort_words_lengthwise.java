import java.util.Arrays;
import java.util.Scanner;               
public class sort_words_lengthwise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of words: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String[] words = new String[n];
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }

        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        System.out.println("Words sorted by length:");
        for (String word : words) {
            System.out.println(word);
        }
    }
    
}
