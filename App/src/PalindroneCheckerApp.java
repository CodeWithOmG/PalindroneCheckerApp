import java.util.Stack;

public class PalindroneCheckerApp {

    public static void main(String[] args) {

        String word = "madam";
        Stack<Character> stack = new Stack<>();

        for (char c : word.toCharArray()) {
            stack.push(c);
        }
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        if (word.equals(reversed)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}