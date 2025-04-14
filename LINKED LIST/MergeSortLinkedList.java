public class MergeSortLinkedList {

    public class Node {
        int data;
        Node next;

        // Constructor to initialize Node with data
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void printList() { // Time complexity: O(n)
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

    private Node getMid(Node head) { // Finding MidNode by slow-fast approach
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Mid node
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1); // Dummy node
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) { // Fix: Use head2 instead of head1
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next; // Return the merged list, skipping the dummy node
    }

    public Node mergeSort(Node head) { // Time complexity: O(nlogn)
        // Base case
        if (head == null || head.next == null) { // Fix: Use || instead of &&
            return head;
        }

        // Find mid
        Node mid = getMid(head);

        // Split into left and right halves
        Node rightHead = mid.next;
        mid.next = null;

        // Recursively sort the left and right halves
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // Merge the sorted halves
        return merge(newLeft, newRight);
    }

    public static void main(String[] args) {
        MergeSortLinkedList ll = new MergeSortLinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        // 5 -> 4 -> 3 -> 2 -> 1

        ll.printList();
        ll.head = ll.mergeSort(ll.head); // Sort the linked list
        ll.printList();
    }
}
