import java.util.Scanner;
public class remove_duplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] uniqueArr = removeDuplicates(arr);
        System.out.println("Array after removing duplicates:");
        for (int num : uniqueArr) {
            System.out.print(num + " ");
        }
    }
    public static int[] removeDuplicates(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return new int[0];
        }
        int[] temp = new int[n];
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n - 1];
        int[] uniqueArr = new int[j];
        System.arraycopy(temp, 0, uniqueArr, 0, j);
        return uniqueArr;
    }
    
}
