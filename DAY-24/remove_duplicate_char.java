import java.util.Scanner;
public class remove_duplicate_char {    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.nextLine();
        String result = removeDuplicateCharacters(input);
        System.out.println("String after removing duplicate characters: " + result);
    }

    public static String removeDuplicateCharacters(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (result.indexOf(String.valueOf(c)) == -1) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
