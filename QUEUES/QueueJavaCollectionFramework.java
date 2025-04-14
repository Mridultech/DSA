import java.util.*;
public class QueueJavaCollectionFramework { // yaha pe bhi sare operations ki time complexity O(1) hi rhegi.
    public static void main(String[] args){
        Queue<Integer> q = new LinkedList<>(); // Create a queue using LinkedList , queue is an interface and LinkedList is a class that implements the queue interface 
        // Note: we can't make objects of interface .
        // Queue<Integer> queue = new ArrayDeque<>(); // You can also use ArrayDeque for a queue

        // Add elements to the queue
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek()); // poll() removes the head of the queue and returns it. If the queue is empty, it returns null.
            q.remove();
        }
        
}
}