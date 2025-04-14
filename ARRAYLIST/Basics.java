import java.util.ArrayList;

public class Basics{
    /*
     * what is array list ? 
     * What is difference between Array and Arraylist?
     * 
     * -----------------------------------------------
     * |     Array           |      Arraylist        |
     * |---------------------|-----------------------|
     * | 1. Fixed Size       | 1. Dynamic Size       |
     * |---------------------|-----------------------|
     * | 2. Primitives only  | 2. Objects only       |
     * |---------------------|-----------------------|
     * 
     * 
     * 
     * 
     * How arraylist can be used ?
     * by importing ArrayList class from java.util package.
     * 
     * ArrayList is a part of Java's collection framework and is used to store dynamically sized collections of elements.
     */
    public static void main(String[] args) {
        
    // Syntax to create ArrayList         
        ArrayList<String> names = new ArrayList<>(); // yaha angular brackets bata rhe hai ki kistype ka object ya data use ho rha hai or new keyword to allocate memory in heap for our arraylist.

    //Operations on ArrayList

        // 1. Add elements to ArrayList : Time complexity is O(1) for adding at the end.
        names.add("John");
        names.add("Jane");
        names.add("Jack");

        names.add(1,"mridul"); // This will add "mridul" at index 1 and shift subsequent elements to the right. : time complexity : O(n)

        System.out.println("ArrayList: " + names); // Output: [John, Jane, Jack]

        // 2. Access elements from ArrayList : Time complexity is O(1) for accessing an element by index.
        // Note: ArrayList uses zero-based indexing.
        System.out.println("First name: " + names.get(0)); // Output: John

        // 3. Remove elements from ArrayList : Time complexity is O(n) for removing an element.
        // Note: Removing an element shifts subsequent elements to the left.
        names.remove("Jane");

        // 4. Get size of ArrayList
        System.out.println("Size of ArrayList: " + names.size()); // Output: 2

        // 5. Iterate through ArrayList
        for (String name : names) {
            System.out.println(name);
        }
        // 6. Check if ArrayList contains an element : Time complexity is O(n).
        if (names.contains("Jack")) {
            System.out.println("Jack is in the list.");
        } else {
            System.out.println("Jack is not in the list.");
        }
        // 7. Clear the ArrayList
        names.clear();
        System.out.println("Size after clear: " + names.size()); // Output: 0

        // 8. Set an element at a specific index : Time complexity is O(n).
        names.add("mridul");
        names.add("mridul");
        names.add("mridul");
        names.add("mridul");
        names.set(2,"john"); // This will replace the element at index 2 with "John"

        System.out.println(names); // Output: [mridul, mridul, mridul]

        // 9. To find size of arraylist : Time complexity is O(1).
        System.out.println("Size of ArrayList: " + names.size()); // Output: 3

    }
}