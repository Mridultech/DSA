import java.util.*;
public class LinkedHashMapConcept {

    /*Linked hash map ek aisa data structure hai jo insertion order ko maintain karta hai
    * jis order mein key-value pairs enter hui hai usi order mein unhe store karta hai.
    * Ye hash map ki tarah hi kaam karta hai lekin isme ek linked list bhi hoti hai jo
    * insertion order ko maintain karti hai.
    * ek difference or hai ki Linked hashmap is implemented as doubly linked list in array .
    * but hashmap is implemented as array of singly linked list.
    */
    
    public static void main(String[] args){
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("A", 1);
        lhm.put("B", 2);
        lhm.put("C", 3);
        lhm.put("D", 4);
        
        System.out.println(lhm);
    }
}
