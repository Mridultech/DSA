import java.util.*;

public class PriorityQueueConcept {
    /*
     * Priority Queue ka concept: 
     * Priority Queue ek special type ki queue hoti hai jisme elements ko unki priority ke according arrange kiya jata hai.
     * - Default: Min-Heap (smallest value has highest priority)
     * - Custom: Max-Heap (Collections.reverseOrder() se create kiya jata hai) : here largest value has highest priority
     * 
     * 
     * The poll() method in a queue is used to retrieve and remove the head (front) of the queue. If the queue is empty, it returns null instead of throwing an exception. This makes it a safe way to remove elements from a queue without needing to check if the queue is empty beforehand.
     */

    //Implementing priority queue for objects :

    public static class Student implements Comparable<Student> { //overriding compareTo method for custom sorting based on marks
        String name;
        int marks;

        public Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }       
        @Override
        public int compareTo(Student s2) {
            return this.marks - s2.marks; // ascending order based on marks
        }
    }

    
    public static void main(String[] args){
        System.out.println("== Java Priority Queue Demo ==");

        // 🔼 Max-Heap using reverse order comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(15);

        while(!maxHeap.isEmpty()){
            System.out.println("Max-Heap: " + maxHeap.poll());  // Expected: 20, 15, 10
        }
        
        System.out.println("Max-Heap (Highest priority): " + maxHeap.poll());  // Expected: 20

        // 🔽 Min-Heap (Default behavior)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(15);

        System.out.println("Min-Heap (Lowest priority): " + minHeap.poll());  // Expected: 10

        PriorityQueue<Student> studentQueue = new PriorityQueue<>();
        studentQueue.add(new Student("Alice", 85));
        studentQueue.add(new Student("Bob", 90));
        studentQueue.add(new Student("Charlie", 80));

        while(!studentQueue.isEmpty()){
            Student s = studentQueue.poll(); // Retrieves and removes the head of the queue
            System.out.println("Student: " + s.name + ", Marks: " + s.marks);  // Expected: Charlie, Alice, Bob (based on marks)
        }

        // for reverse order of student marks :
        PriorityQueue<Student> studentQueue2 = new PriorityQueue<>(Comparator.reverseOrder()); // we can also use Collections.reverseOrder() here
        studentQueue2.add(new Student("Alice", 85));
        studentQueue2.add(new Student("Bob", 90));
        studentQueue2.add(new Student("Charlie", 80));

        while(!studentQueue2.isEmpty()){
            Student s = studentQueue2.poll(); // Retrieves and removes the head of the queue
            System.out.println("Student: " + s.name + ", Marks: " + s.marks);  // Expected: Bob, Alice, Charlie (based on marks)
        }
    }
}
