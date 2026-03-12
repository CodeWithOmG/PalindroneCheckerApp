import java.util.*;

interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String text) {
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) stack.push(c);
        for (char c : clean.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

class TwoPointerStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String text) {
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left++) != clean.charAt(right--)) return false;
        }
        return true;
    }
}

public class PalindroneCheckerApp {
    public static void main(String[] args) {
        String largeInput = "a".repeat(1000000); // 1 million characters

        compare(new StackStrategy(), "Stack Strategy", largeInput);
        compare(new TwoPointerStrategy(), "Two-Pointer Strategy", largeInput);
    }

    private static void compare(PalindromeStrategy strategy, String name, String input) {
        long startTime = System.nanoTime();
        strategy.isPalindrome(input);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime) / 1000000; // Convert to milliseconds
        System.out.println(name + " execution time: " + duration + " ms");
    }
}