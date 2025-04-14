public class PalindromeLinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public Node findMid(Node head) {
        Node slow = head; // Corrected initialization
        Node fast = head; // Corrected initialization

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Slow pointer is at the middle
    }

    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true; // Empty or single-node linked list is a palindrome
        }

        // Step 1: Find the middle of the linked list
        Node mid = findMid(head);

        // Step 2: Reverse the second half of the linked list
        Node prev = null;
        Node curr = mid;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // Right pointer points to the reversed second half
        Node left = head; // Left pointer points to the first half

        // Step 3: Compare the first half and the reversed second half
        while (right != null) {
            if (left.data != right.data) {
                return false; // Not a palindrome
            }
            left = left.next;
            right = right.next;
        }

        // Step 4: Restore the second half of the linked list (optional)
        prev = null;
        curr = mid;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return true; // Linked list is a palindrome
    }

    public static void main(String[] args) {
        PalindromeLinkedList list = new PalindromeLinkedList();

        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);

        list.printList();
        System.out.println("Is palindrome: " + list.isPalindrome());
    }
}