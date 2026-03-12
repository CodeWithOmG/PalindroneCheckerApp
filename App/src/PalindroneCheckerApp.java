import java.util.Scanner;

class PalindromeService {

    public boolean check(String input) {
        if (input == null) return false;
        String normalized = normalize(input);
        return validate(normalized);
    }

    private String normalize(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    private boolean validate(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

public class PalindroneCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PalindromeService service = new PalindromeService();

        System.out.println("Enter text to check:");
        String userInput = sc.nextLine();

        if (service.check(userInput)) {
            System.out.println("Result: It is a palindrome.");
        } else {
            System.out.println("Result: Not a palindrome.");
        }

        sc.close();
    }
}