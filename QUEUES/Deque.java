import java.util.*;
public class Deque {

    /*
     * Deque is a double-ended queue that allows every operation over elements from both ends.
     * It is a linear data structure that can be implemented using arrays or linked lists.
     * Deque and Dequeue is different. Deque is a data structure, while Dequeue is an operation.
     * 
     * isme main 8 methods hai iske : 
     * 1. addFirst() - adds an element at the front of the deque.
     * 2. addLast() - adds an element at the end of the deque.
     * 3. removeFirst() - removes an element from the front of the deque.
     * 4. removeLast() - removes an element from the end of the deque.
     * 5. peekFirst() - returns the first element of the deque without removing it.
     * 6. peekLast() - returns the last element of the deque without removing it.
     * 7. getFirst() - returns the first element of deque without removing it but if deque is empty throws exception error unlike peek method.
     * 8. getLast() - returns the last element of deque without remvoing it but if deque is empty throws exceptio error unlike peek method.
     * 
     * Note : Deque bhi interface hai hence iska bhi apna object nahi ban skta hai 
     */
    public static void main(String[] args){
        java.util.Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4); 
        
        System.out.println(deque);
        deque.addLast(3);
        System.out.println(deque);
        deque.removeFirst();
        System.out.println(deque);
        deque.removeLast();
        System.out.println(deque);
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.size());
        System.out.println(deque.isEmpty());
        System.out.println(deque.contains(2));
     
    }
}
