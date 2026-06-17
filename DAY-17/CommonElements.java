import java.util.Scanner;

public class CommonElements {
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

        System.out.print("Enter size of third array: ");
        int n3 = sc.nextInt();
        int[] arr3 = new int[n3];
        System.out.println("Enter elements of third array:");
        for (int i = 0; i < n3; i++) {
            arr3[i] = sc.nextInt();
        }

        System.out.println("Common elements in all three arrays:");
        boolean[] alreadyPrinted = new boolean[n1];

        for (int i = 0; i < n1; i++) {
            if (alreadyPrinted[i]) continue;

            boolean presentInArr2 = false;
            for (int j = 0; j < n2; j++) {
                if (arr1[i] == arr2[j]) {
                    presentInArr2 = true;
                    break;
                }
            }

            boolean presentInArr3 = false;
            for (int k = 0; k < n3; k++) {
                if (arr1[i] == arr3[k]) {
                    presentInArr3 = true;
                    break;
                }
            }

            if (presentInArr2 && presentInArr3) {
                System.out.print(arr1[i] + " ");
                alreadyPrinted[i] = true;
            }
        }

        sc.close();
    }
}