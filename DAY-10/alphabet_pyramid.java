import java.util.Scanner;
public class alphabet_pyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        for (int i = 1; i <= rows; i++) {
            //SPACES
            for (int j = 1; j <= rows - i; j++) {
                System.out.print("  ");
            }
            //FIRST HALF OF THE PYRAMID
            for (int k = 1; k <= i; k++) {
                System.out.print((char)(k + 64) + " ");
            }
            // SECOND HALF OF THE PYRAMID
            for (int m = i-1; m >= 1; m--) {
                System.out.print((char)(m + 64) + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}

  

    

