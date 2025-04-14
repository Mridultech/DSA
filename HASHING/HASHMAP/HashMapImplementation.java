import java.util.*;
public class HashMapImplementation { 

    /*
     * HashMap in java is implemented in form of array of linked list.
     * The array is called as buckets and each bucket contains a linked list of nodes.
     * Each node contains a key-value pair.
     * The hash function is used to calculate the index of the array where the key-value pair will be stored. 
     * hashCode() method is used to calculate the hash code of the key.
     * 
     * hash function ka kaam hai key lena or uska bucket index calculate karna.
     * Note : Same key ke liye har bar same bucket index milega.
     * 
     * approach : 
     * 1. put(key, value) :
     *   - hash function se bucket index nikaal lo.
     * bucket pe jo linked list hai usme jao or loop lagao.
     * - agar key mil gayi to value update kar do.
     * - agar key nahi mili to naya node bana do or linked list me add kar do.
     * 
     * if N is number of buckets in the map and M is the number of nodes,
     * 
     * then lambda = N/M
     * 
     * time complexity : O(lambda) for put and get operations but always < k(threshold) .
     * 
     * ab jaise jaise N ki value increase hogi to lambda ki value bhi increase hogi.
     * to if lambda > k(threshold) to rehashing karna padega.
     * 
     * rehashing ka matlab hai ki naya array banao or purane array ke saare elements ko naye array me daal do.
     * 
     * Note : rehashing mein zaruri nahi hai ki jo pehle wale old hashmaps mein particular nodes ko bucket mili hui thi wohi bucket naye hashmap mein milegi.
     * 
     * rehashing ka time complexity O(N) hai. lekin ye bahut kam hota hai. isiliye time complexity O(1) hi maanenge.
     * 
     * important question for placement interviews:
     * hashmap implementation from scratch .
     * 
     * special Note : 
     * in worst case scenarios : hash map ki time complexity O(N) ho jaati hai.
     * kyuki ya to implementation kam optimized hai yaha dataset hi aisa hai ki hash function har datapoint ke liye same bucket index de raha hai.
     * to sabhi nodes ek hi bucket mein aa jaate hain.
     * jisse sabhi opeartions ki time complexity O(N) ho jaati hai.
     * 
     */

    static class HashMap <k,v> { // ye generics hote hai or ye use hote hai ki key or value ka koi particular type nahi hai or jo constructor mein type aa rha hai wo hi type hoga.
        private class Node {
            k key;
            v value;

            public Node(k key, v value){
                this.key = key;
                this.value = value;
            }
        }
            private int n ; // n = size of linked list
            private int N; // N = size of hashmap
            private LinkedList<Node> buckets[]; // N = buckets.length

            @SuppressWarnings("unchecked") // used to supress warnings of unchecked due to undefined type of linked list

            public HashMap(){
                this.N = 4;
                this.buckets = new LinkedList[4];
                for(int i = 0 ; i < buckets.length ; i++){
                    this.buckets[i] = new LinkedList<>();
                }
            }
            private int SearchInLL (k key, int bucketIndex){
                LinkedList<Node> linkedList = buckets[bucketIndex]; // linked list of bucket index
                int dataIndex = 0; // invalid index
                for(int i = 0 ; i < linkedList.size() ; i++){
                    Node node = linkedList.get(i); // get the node at index i
                    if(node.key.equals(key)){ // check if key is equal to the key of node
                        return i; // return the index of the node
                    }
                    dataIndex++; // increment the index
                }
                return -1; // return -1 if key is not found in the linked list 
            }
            private int hashFunction(k key){
                int hashCode = key.hashCode();
                return Math.abs(hashCode) % N; // bucket index nikaal lo , yaha abs(bi) to kuch bhi return krdega or ise agar 4 se mod karenge to 0 se 3 ke bich mein aayega.
            }
            @SuppressWarnings("unchecked") // used to supress warnings of unchecked due to n*2 in rehash method.
            private void rehash(){
                LinkedList<Node> oldBuckets[] = buckets; // old buckets
                buckets = new LinkedList[2 * N]; // create new buckets of size 2 * N
                N = 2 * N; // update the size of hashmap
                for(int i = 0 ; i < buckets.length ; i++){
                    buckets[i] = new LinkedList<>(); // create new linked list for each bucket
                }

                //purani buckets se nodes nikalke nayi buckets mein daal denge.
                for(int i = 0 ; i < oldBuckets.length ; i++){
                    LinkedList<Node> oldLinkedList = oldBuckets[i]; // get the linked list of old buckets
                    for(int j = 0 ; j < oldLinkedList.size() ; j++){
                        Node node = oldLinkedList.get(j); // get the node at index j
                        put(node.key, node.value); // put the key and value in the new buckets
                    }
                }
            }
            public void put(k key , v value){ // O(lambda) time complexity -> O(1) time complexity
                int bucketIndex = hashFunction(key); // ye 0 to 3 ke bich mein aana chaiye 
                int dataIndex = SearchInLL(key , bucketIndex); // valid  or invalid index of linked list are possible

                if(dataIndex != -1){
                    Node node = buckets[bucketIndex].get(dataIndex); // get the node at index dataIndex
                    node.value = value; // update the value of the node
                }
                else{
                    Node node = new Node(key, value); // create a new node with key and value
                    buckets[bucketIndex].add(node); // add the node to the linked list of the bucket index
                    n++; // increment the size of the hashmap
                }

                double lambda = (double)n/N;
                if(lambda > 2.0){
                    rehash(); // rehash the hashmap if lambda is greater than 2.0
                }
            }

            // time complexity : O(lambda) -> O(1)
            public boolean containsKey(k key){ // approach : hashfucntion particular key ke liye uska bucket index batayega or us bucket index ke linked list mein jaake key ko search karenge.
                int bucketIndex = hashFunction(key); // ye 0 to 3 ke bich mein aana chaiye
                int dataIndex = SearchInLL(key , bucketIndex); // valid  or invalid index of linked list are possible

                if(dataIndex != -1){
                    return true; // return true if key is found in the linked list
                }
                else{
                    return false; // return false if key is not found in the linked list
                }
            }

            // time complexity : O(lambda) -> O(1)
            public v remove(k key){
                int bucketIndex = hashFunction(key); // ye 0 to 3 ke bich mein aana chaiye
                int dataIndex = SearchInLL(key , bucketIndex); // valid  or invalid index of linked list are possible

                if(dataIndex != -1){
                    Node node = buckets[bucketIndex].remove(dataIndex); // get the node at index dataIndex
                    n--; // decrement the size of the hashmap
                    return node.value; // return the value of the node
                }
                else{
                    return null; // return null if key is not found in the linked list
                }

            }

            // time complexity : O(lambda) -> O(1)
            public v get(k key){
                int bucketIndex = hashFunction(key); // ye 0 to 3 ke bich mein aana chaiye
                int dataIndex = SearchInLL(key , bucketIndex); // valid  or invalid index of linked list are possible

                if(dataIndex != -1){
                    Node node = buckets[bucketIndex].get(dataIndex); // get the node at index dataIndex
                    return node.value; // return the value of the node
                }
                else{
                    return null; // return null if key is not found in the linked list
                }
            }

            public ArrayList<k> keySet(){
                ArrayList<k> keys = new ArrayList<>(); // create a new array list to store the keys

                for(int i = 0 ; i < buckets.length; i++){ // for each bucket
                    if(buckets[i] == null){ // check if the bucket is empty
                        continue; // skip the empty bucket
                    }
                    LinkedList<Node> linkedList = buckets[i]; // get the linked list of the bucket index
                    for (Node node : linkedList) { // for each node in the linked list
                        keys.add(node.key); // add the key of the node to the array list
                        
                    }
                }
                return keys; // return the array list of keys   
            }

            public boolean isEmpty(){
                return n == 0; // return true if the size of the hashmap is 0
            }
        }
    
    public static void main(String[] args) {
        System.out.println("HashMap Implementation!");

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("USA", 200);
        hm.put("China", 300);
        hm.put("Japan", 400);
        hm.put("Germany", 500);

        ArrayList<String> keys = hm.keySet();
        for(String key : keys) {
            System.out.println(key + " : " + hm.get(key));
        }

        System.out.println(hm.get("India")); // 100
        System.out.println(hm.remove("USA")); // 200

    }
}   