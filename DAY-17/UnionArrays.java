import java.util.Scanner;

public class UnionArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter elements of first array:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter elements of second array:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        // Temporary array to hold union (max possible size)
        int[] union = new int[n1 + n2];
        int unionSize = 0;

        // Add all elements from first array (avoiding duplicates within it)
        for (int i = 0; i < n1; i++) {
            boolean found = false;
            for (int j = 0; j < unionSize; j++) {
                if (union[j] == arr1[i]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                union[unionSize] = arr1[i];
                unionSize++;
            }
        }

        // Add elements from second array if not already present
        for (int i = 0; i < n2; i++) {
            boolean found = false;
            for (int j = 0; j < unionSize; j++) {
                if (union[j] == arr2[i]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                union[unionSize] = arr2[i];
                unionSize++;
            }
        }

        System.out.println("Union of the two arrays:");
        for (int i = 0; i < unionSize; i++) {
            System.out.print(union[i] + " ");
        }

        sc.close();
    }
} 
