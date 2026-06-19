import java.util.Scanner;
public class diagonal_sum_matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of the matrix:");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("The original matrix is:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int pSum = 0;
        int sSum = 0;

        // Calculating the sum of primary diagonal
        for (int i = 0; i < Math.min(rows, cols); i++) {
            pSum += matrix[i][i];
        }

        // Calculating the sum of secondary diagonal
        for (int i = 0; i < Math.min(rows, cols); i++) {
            sSum += matrix[i][cols - 1 - i];
        }

        System.out.println("Sum of primary diagonal: " + pSum);
        System.out.println("Sum of secondary diagonal: " + sSum);

        sc.close();
    }
    
}
