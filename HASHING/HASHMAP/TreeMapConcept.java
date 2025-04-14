import java.util.*;
public class TreeMapConcept {

    /*
     * Treemap data structure mein jo key hoti hai wo sorted order mein hoti hai.
     * Iska matlab hai ki jab aap keys ko iterate karte hain, to wo sorted order mein milti hain.
     * tree map mein put , get , remove operations O(log n) time mein hoti hain kyuki keys sorted hai to time complexity bhad jati hai.
     * tree map ki implementation red-black tree par hoti hai.
     * TreeMap mein null key nahi hoti hai, lekin null values ho sakti hain.
     */
    public static void main(String[] args) {
        System.out.println("TreeMap Example");

        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("d", 2);
        tm.put("c", 4);
        tm.put("n", 6);
        tm.put("a", 1);
        
        System.out.println(tm);
    }
}