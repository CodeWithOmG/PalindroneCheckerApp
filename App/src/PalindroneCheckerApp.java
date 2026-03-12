import java.util.Scanner;

public class PalindroneCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        // Flow: Normalize string (Remove non-alphanumeric and lowercase)
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean isPalindrome = true;
        int left = 0;
        int right = clean.length() - 1;

        // Flow: Apply logic (Compare front and rear)
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("Is Palindrome: " + isPalindrome);
        sc.close();
    }
}