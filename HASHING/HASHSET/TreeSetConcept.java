import java.util.*;
public class TreeSetConcept {

    /*
     * TreeSet is a part of the Java Collections Framework and implements the Set interface.
     * Sorted in accending order.
     * Null values are not allowed : because isme sorting ke liye comparison karna padega jisme ki hame null se compare karke koi significant result nahi milega isiliye null nahi hote.
     * treeset is implemented using Red-Black Tree.
     * yaha pe operations ki complexity O(log n) hoti hai.
     * 
     */

    public static void main(String[] args) {
       TreeSet<String> ts = new TreeSet<>();
        ts.add("Amit");
        ts.add("Rahul");
        ts.add("Amit"); // duplicate value will not be added
        ts.add("Zebra");
        ts.add("Amit"); // duplicate value will not be added
        ts.add("Amit"); // duplicate value will not be added

        System.out.println(ts); // [Amit, Rahul, Zebra]
        System.out.println(ts.size()); // 3
        System.out.println(ts.isEmpty()); // false
        System.out.println(ts.contains("Amit")); // true
        System.out.println(ts.contains("Amit1")); // false
        System.out.println(ts.first()); // Amit
        System.out.println(ts.last()); // Zebra

        //rest all functions are same as HashSet
        ts.remove("Amit"); // remove Amit from the set
        System.out.println(ts); // [Rahul, Zebra]
        ts.clear(); // clear the set
        System.out.println(ts); // []
        System.out.println(ts.isEmpty()); // true
        System.out.println(ts.size()); // 0
        ts.add("Amit");


    }
}