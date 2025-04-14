import java.util.*;
public class Hashmap {

    /*
     * hashmap is a data structure that stores key-value pairs.
     * It is part of the Java Collections Framework and is implemented as a hash table. 
     * Hashmap can be visualized as nodes in a table, where each node contains a key and a value.
     * In hashmap , insertion, deletion and searching of elements is done in O(1) time complexity on average.
     * Note : in hashmaps , key is unique and value can be duplicate.
     * 
     * 
     * General syntax to create a hashmap:
     * HashMap<keyType, valueType> mapName = new HashMap<>();
     * 
     * where keyType is the type of the key and valueType is the type of the value.
     * 
     * Operations in Hashmap:
     * 
     * 1. put(key, value) : O(1) : adds a key-value pair to the hashmap.
     * 
     * 2. get(key) : O(1) : returns the value associated with the key.
     * 
     * 3. remove(key) : O(1) : removes the key-value pair from the hashmap.
     * 
     * 4. containsKey(key) : O(1) : checks if the key is present in the hashmap.
     * 
     * 5. size() : O(1) : returns the number of key-value pairs in the hashmap.
     * 
     * 6. isEmpty() : O(1) : checks if the hashmap is empty.
     * 
     * 7. clear() : O(n) : removes all the key-value pairs from the hashmap.
     * 
     * 8. keySet() : O(n) : returns a set of all the keys in the hashmap.
     * 
     * 9. values() : O(n) : returns a collection of all the values in the hashmap.
     * 
     * 10. entrySet() : O(n) : returns a set of all the key-value pairs in the hashmap.
     * 
     * 
     * 
     */
    public static void main(String[] args) {
        System.out.println("Hashmap in Java");

        HashMap<String, Integer> hm  = new HashMap<>(); // creating a hashmap

        //Insert
        hm.put("usa", 1); // adding key-value pair to the hashmap
        hm.put("china", 2); // adding key-value pair to the hashmap
        hm.put("india", 3); // adding key-value pair to the hashmap

        System.out.print("Hashmap after insertion: " + hm); // printing the hashmap

        //Get - if there availaible a valid key then it will return the value associated with the key otherwise it will return null.
        int id = hm.get("usa"); // getting the value associated with the key "usa"

        System.out.println(id);

        //ContainsKey - if there availaible a valid key then it will return true otherwise it will return false.

        boolean isPresent = hm.containsKey("usa"); // checking if the key "usa" is present in the hashmap

        System.out.println(isPresent); // printing the result

        //Remove - if there availaible a valid key then it will remove the key-value pair from the hashmap and return the value associated with the key otherwise it will return null.
        int removedValue = hm.remove("usa"); // removing the key-value pair from the hashmap

        System.out.println("Removed value: " + removedValue); // printing the removed value

        System.out.println("Hashmap after removal: " + hm); // printing the hashmap after removal

        //size - returns the number of key-value pairs in the hashmap.

        int size = hm.size(); // getting the size of the hashmap

        System.out.println("Size of hashmap: " + size); // printing the size of the hashmap

        //isEmpty - returns true if the hashmap is empty otherwise it will return false.

        boolean isEmpty = hm.isEmpty(); // checking if the hashmap is empty

        System.out.println("Is hashmap empty: " + isEmpty); // printing the result

        //clear - removes all the key-value pairs from the hashmap.

        // hm.clear(); // clearing the hashmap

        // System.out.println("Hashmap after clearing: " + hm); // printing the hashmap after clearing

        //Iteration in hashmaps - we can iterate through the hashmap using for-each loop.

        Set<String> keys = hm.keySet();

        System.out.println(keys);

        for (String k : keys) {
            System.out.println("Key = " +  k + ",value =" + hm.get(k));
        }
        
    }
}