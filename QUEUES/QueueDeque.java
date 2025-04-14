import java.util.*;

public class QueueDeque {
    /*
     * Implementation of a queue using a deque.
     * A deque is a double-ended queue that allows insertion and deletion from both ends.
     * This implementation uses a doubly linked list to represent the deque.
     *
     * queue is a linear data structure that follows the FIFO (First In First Out) principle.
     * Elements are added to the rear of the queue and removed from the front.
     * ab ham queue mein add krne ke liye deque ka addLast use karenge aur remove karne ke liye deque ka removeFirst use karenge.
     * peek karne ke liye deque ka getFirst use karenge.
     *
     * main use of deque data structure is to implement a queue.
     * Deque is a linear data structure that allows insertion and deletion from both ends.
     * question in which insert or delete from both ends is required can be solved using deque.
     * Deque is a more general data structure than a queue, as it allows for more flexibility in how elements are added and removed.
     */
    static class Queue {
        Deque<Integer> deque = new LinkedList<>();

        // Add an element to the rear of the queue
        public void enqueue(int data) {
            deque.addLast(data);
        }

        // Remove an element from the front of the queue
        public int dequeue() {
            if (deque.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return deque.removeFirst();
        }

        // Peek at the front element of the queue
        public int peek() {
            if (deque.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return deque.getFirst();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println("Peek = " + q.peek());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
