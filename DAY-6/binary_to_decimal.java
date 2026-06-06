import java.util.Scanner;
public class BINARY_TO_DECIMAL {
    public static void main(String[] args){
    
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        int binary = sc.nextInt();
        int decimal = 0;
         int c=0;
            while (binary > 0) {
                int digit = binary % 10;
                if (digit == 1 || digit == 0) {
                    decimal += digit * Math.pow(2, c);
                } else {
                    System.out.println("Invalid binary number.");
                    return;
                }
                binary /= 10;
                c++;
            }
        System.out.println("Decimal equivalent: " + decimal);
        sc.close();
        }
    }                                                       

