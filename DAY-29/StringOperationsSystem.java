import java.util.Scanner;

public class StringOperationsSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Menu-Driven String Operations System ===\n");

        while (running) {
            System.out.println("1. Find String Length");
            System.out.println("2. Reverse a String");
            System.out.println("3. Check Palindrome");
            System.out.println("4. Convert to Uppercase");
            System.out.println("5. Convert to Lowercase");
            System.out.println("6. Count Vowels & Consonants");
            System.out.println("7. Count Words");
            System.out.println("8. Remove Spaces");
            System.out.println("9. Check Anagram (two strings)");
            System.out.println("10. Find & Replace Character");
            System.out.println("11. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 11) {
                System.out.println("Exiting. Goodbye!");
                running = false;
                continue;
            }

            if (choice < 1 || choice > 10) {
                System.out.println("Invalid option.\n");
                continue;
            }

            if (choice == 9) {
                System.out.print("Enter first string: ");
                String s1 = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
                System.out.print("Enter second string: ");
                String s2 = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
                char[] arr1 = s1.toCharArray();
                char[] arr2 = s2.toCharArray();
                java.util.Arrays.sort(arr1);
                java.util.Arrays.sort(arr2);
                boolean isAnagram = java.util.Arrays.equals(arr1, arr2);
                System.out.println(isAnagram ? "The strings ARE anagrams.\n" : "The strings are NOT anagrams.\n");
                continue;
            }

            System.out.print("Enter a string: ");
            String str = scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Length: " + str.length() + "\n");
                    break;

                case 2:
                    StringBuilder reversed = new StringBuilder(str).reverse();
                    System.out.println("Reversed: " + reversed + "\n");
                    break;

                case 3:
                    String clean = str.toLowerCase().replaceAll("\\s", "");
                    String rev = new StringBuilder(clean).reverse().toString();
                    System.out.println(clean.equals(rev) ? "The string IS a palindrome.\n" : "The string is NOT a palindrome.\n");
                    break;

                case 4:
                    System.out.println("Uppercase: " + str.toUpperCase() + "\n");
                    break;

                case 5:
                    System.out.println("Lowercase: " + str.toLowerCase() + "\n");
                    break;

                case 6:
                    int vowels = 0, consonants = 0;
                    String lower = str.toLowerCase();
                    for (char c : lower.toCharArray()) {
                        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                            vowels++;
                        } else if (c >= 'a' && c <= 'z') {
                            consonants++;
                        }
                    }
                    System.out.println("Vowels: " + vowels);
                    System.out.println("Consonants: " + consonants + "\n");
                    break;

                case 7:
                    String[] words = str.trim().split("\\s+");
                    int wordCount = str.trim().isEmpty() ? 0 : words.length;
                    System.out.println("Word Count: " + wordCount + "\n");
                    break;

                case 8:
                    String noSpaces = str.replaceAll("\\s", "");
                    System.out.println("Without Spaces: " + noSpaces + "\n");
                    break;

                case 10:
                    System.out.print("Enter character to find: ");
                    char findChar = scanner.nextLine().charAt(0);
                    System.out.print("Enter character to replace with: ");
                    char replaceChar = scanner.nextLine().charAt(0);
                    String replaced = str.replace(findChar, replaceChar);
                    System.out.println("Result: " + replaced + "\n");
                    break;
            }
        }
        scanner.close();
    }
}