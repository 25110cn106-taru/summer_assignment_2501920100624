import java.util.Scanner;

public class IntersectionArrays {
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

        System.out.println("Intersection of the two arrays:");
        // To avoid printing duplicates, track which elements of arr1 are already printed
        boolean[] alreadyPrinted = new boolean[n1];

        for (int i = 0; i < n1; i++) {
            if (alreadyPrinted[i]) continue;
            for (int j = 0; j < n2; j++) {
                if (arr1[i] == arr2[j]) {
                    System.out.print(arr1[i] + " ");
                    alreadyPrinted[i] = true;
                    break;
                }
            }
        }

        sc.close();
    }
}
