import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class QueueStackPalindromeChecker {

    public static void main(String[] args) {

        String word = "madam";

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Push to stack and enqueue to queue
        for (char c : word.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        boolean isPalindrome = true;

        // Compare stack pop (LIFO) with queue dequeue (FIFO)
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.remove()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}