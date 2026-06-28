import java.util.Scanner;
public class CommonCharactersInStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        String commonChars = findCommonCharacters(str1, str2);
        System.out.println("Common characters: " + commonChars);
    }

    public static String findCommonCharacters(String str1, String str2) {
        StringBuilder common = new StringBuilder();
        for (char c : str1.toCharArray()) {
            if (str2.indexOf(c) != -1 && common.indexOf(String.valueOf(c)) == -1) {
                common.append(" ").append(c);
            }
        }
        return common.toString();
    }
}