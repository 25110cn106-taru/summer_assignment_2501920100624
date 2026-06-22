import java.util.Scanner;
public class string_length_without_sterlen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        int length = calculateLength(str);
        System.out.println("Length of the string: " + length);
    }

    public static int calculateLength(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            count++;
        }
        return count;
    }
}
