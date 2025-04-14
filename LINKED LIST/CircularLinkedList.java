/**
 * Circular Linked List in Java
 * 
 * Yeh Circular Linked List ka pura implementation hai.
 * Ek circular linked list me last node first node se connected hota hai,
 * isliye koi NULL pointer nahi hota.
 * Yeh code singly circular linked list ke saath saare operations implement karta hai.
 * 
 * Operations:
 * 1. Insert at Beginning
 * 2. Insert at End
 * 3. Insert After a Node
 * 4. Delete a Node
 * 5. Traverse (Print List)
 * 
 * Easy language explanation WhatsApp style me docstrings ke andar diya gaya hai.
 */

class CircularLinkedList {
    // Node class to define the structure of a node
    static class Node {
        int data;  // Node's data
        Node next; // Reference to the next node

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node last; // Reference to the last node

    // Constructor to initialize last as null
    public CircularLinkedList() {
        this.last = null;
    }

    /**
     * Insert element in an empty list
     */
    public void addToEmpty(int data) {
        if (last != null) return;
        Node newNode = new Node(data);
        last = newNode;
        last.next = last; // Self-loop
    }

    /**
     * Insert element at the beginning
     */
    public void insertAtBeginning(int data) {
        if (last == null) {
            addToEmpty(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
    }

    /**
     * Insert element at the end
     */
    public void insertAtEnd(int data) {
        if (last == null) {
            addToEmpty(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
    }

    /**
     * Insert element after a specific node
     */
    public void insertAfter(int data, int key) {
        if (last == null) return;
        Node temp = last.next;
        do {
            if (temp.data == key) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                if (temp == last) last = newNode;
                return;
            }
            temp = temp.next;
        } while (temp != last.next);
        System.out.println("Node with value " + key + " not found!");
    }

    /**
     * Delete a node from the list
     */
    public void deleteNode(int key) {
        if (last == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = last.next, prev = last;

        // Case 1: Single node in the list
        if (temp == last && temp.data == key) {
            last = null;
            return;
        }

        // Case 2: Deleting the first node
        if (temp.data == key) {
            prev.next = temp.next;
            last.next = temp.next; // Update the last node's next pointer
            return;
        }

        // Case 3: Deleting any other node
        do {
            if (temp.data == key) {
                prev.next = temp.next;
                if (temp == last) { // If the node to be deleted is the last node
                    last = prev;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != last.next);

        // If the key is not found
        System.out.println("Node with value " + key + " not found!");
    }

    /**
     * Traverse and print the circular linked list
     */
    public void traverse() {
        if (last == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = last.next;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != last.next);
        System.out.println("(back to start)");
    }

    /**
     * Main method to test the circular linked list
     */
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.addToEmpty(6);
        cll.insertAtEnd(8);
        cll.insertAtBeginning(2);
        cll.insertAfter(10, 2);
        System.out.println("Circular Linked List after insertions:");
        cll.traverse();
        cll.deleteNode(8);
        System.out.println("Circular Linked List after deletion:");
        cll.traverse();
        cll.deleteNode(6);
        System.out.println("Circular Linked List after deleting 6:");
        cll.traverse();
        cll.deleteNode(2);
        System.out.println("Circular Linked List after deleting 2:");
        cll.traverse();
        cll.deleteNode(10);
        System.out.println("Circular Linked List after deleting 10:");
        cll.traverse();
    }
}
