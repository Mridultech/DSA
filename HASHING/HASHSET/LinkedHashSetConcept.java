import java.util.*;
public class LinkedHashSetConcept {

    /*
     * LinkedHashSet is a hash table and linked list implementation of the Set interface, with predictable iteration order.
     * isme order maintain hota hai.
     */
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Amit");
        lhs.add("Vijay");
        lhs.add("Ajay");
        lhs.add("Amit"); // Duplicate element, will not be added

        System.out.println("LinkedHashSet: " + lhs);

        // baki sare operations bhi possbile hai just like normal HashSet.
    }
}