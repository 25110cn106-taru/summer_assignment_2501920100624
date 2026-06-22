import java.util.Scanner;
public class remove_spaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        String stringWithoutSpaces = str.replaceAll("\\s+", "");
        System.out.println("String without spaces: " + stringWithoutSpaces);
        sc.close();
    }
    
}
