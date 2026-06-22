import java.util.Scanner;
public class character_frequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        int[] frequency = new int[256]; // Assuming ASCII character set
        for (char c : str.toCharArray()) {
            frequency[c]++;
        }
        System.out.println("Character Frequency:");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println((char) i + ": " + frequency[i]);
            }
        }
        sc.close();
    }
    
}
