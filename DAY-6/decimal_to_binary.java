import java.util.Scanner;
public class decimal_to_binary {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimal = sc.nextInt();
        String binary = "";
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary = remainder + binary;
            decimal /= 2;
        }
        System.out.println("Binary equivalent: " + binary);
        sc.close();
    }
}
