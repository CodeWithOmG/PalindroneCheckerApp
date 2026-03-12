class Node {
    char data;
    Node next;
    Node(char data) { this.data = data; }
}

public class PalindroneCheckerApp {
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node current = slow;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        Node firstHalf = head;
        Node secondHalf = prev;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Node head = new Node('r');
        head.next = new Node('a');
        head.next.next = new Node('d');
        head.next.next.next = new Node('a');
        head.next.next.next.next = new Node('r');

        System.out.println(isPalindrome(head));
    }
}