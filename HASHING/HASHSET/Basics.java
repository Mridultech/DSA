import java.util.*;
public class Basics {

    /*
     * HashSets : hashset is a collection that contains no duplicate elements.
     * wohi sets hai jo maths mein padhe the .
     *  It is part of the Java Collections Framework and implements the Set interface. HashSet is backed by a hash table (actually a HashMap instance).
     *  It allows the null element.
     * hashsets is implemented using hashmap in java.
     * similarly, LinkedHashSet is implemented using LinkedHashMap in java.
     * TreeSet is implemented using TreeMap in java.
     * 
     * Syntax for creating a hashset:
     * HashSet<Type> setName = new HashSet<Type>();
     */
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>(); // creating a hashset of integers

        set.add(1); // adding elements to the hashset
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(1);

        System.out.println(set); // printing the hashset

        if(set.contains(2)){
            System.out.println("2 is present in the set");
        }

        set.remove(2); // removing an element from the hashset

        System.out.print(set.size()); // getting the size of the hashset
        System.out.println(set); // printing the hashset after removing an element

        // set.clear(); // clearing the hashset

        System.out.println(set.isEmpty()); // checking if the hashset is empty

        // Iteration on HashSet : 

        //a. using iterators

        Iterator it = set.iterator(); // creating an iterator for the hashset
        while(it.hasNext()){ // checking if there are more elements in the hashset , here hasNext() returns true if there are more elements in the hashset
            System.out.print(it.next() + " "); // printing the next element in the hashset
        }
        System.out.println(); // printing a new line

        //b. using enhanced for loop

        for(int i : set){
            System.out.print(i + " "); // printing the elements in the hashset using enhanced for loop
        }
        System.out.println(); // printing a new line
    }
}