import java.util.Scanner;
public class lowercase_to_uppercase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        String upperCaseStr = convertToUpperCase(str);
        System.out.println("Uppercase string: " + upperCaseStr);
    }

    public static String convertToUpperCase(String str) {
        return str.toUpperCase();
    }
}
