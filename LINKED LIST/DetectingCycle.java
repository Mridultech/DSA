public class DetectingCycle {

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

    public static boolean detectCycle(Node head) {
        if (head == null || head.next == null) { // If the linked list is empty or has only one node, no cycle is possible
            return false;
        }

        /*
         * Here we'll use the fast and slow pointer approach.
         * 
         * Concept: If there is a cycle in the linked list, the fast and slow pointers will eventually meet at the same node.
         * If there is no cycle, the fast pointer will reach the end of the list (null).
         */
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) { // Fixed condition : yaha dekhna hai ki || kyu nahi end kyu aata hai
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true; // Cycle exists
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectingCycle list = new DetectingCycle();

        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Create a cycle in the linked list (e.g., connect the last node to the second node)
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; // Connect the last node to the second node

        // Check for a cycle in the linked list
        System.out.println("Does a cycle exist? " + detectCycle(head));
    }
}