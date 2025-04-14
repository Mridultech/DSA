import java.util.*;
public class MajorityElement { // time complexity : O(n)

    /*
     * Hashmaps ka kafi use hota hai aise frequency and count wale problems mein.
     * Problem statement : Given an array of size n, find the majority element.
     * The majority element is the element that appears more than n/3 times in the array.
     * getOrDefault(arr[i],default value) function ka yehi kaam hai ki agar value mili to arr[i] dega nahi to jo hamne second default value define ki hai wo dedega null ki jagah null nahi dega.
     */
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,4,2,4,24,2,1,2,4,2,2,2}; // size of arr = 15 , so size of arr /3 = 5
        HashMap<Integer,Integer> map = new HashMap<>();

        // for(int i = 0 ; i< arr.length ; i++){
        //     if(map.containsKey(arr[i])){
        //         map.put(arr[i], map.get(arr[i]) + 1);
        //     }
        //     else {
        //         map.put(arr[i], 1);
        //     }
        // }

        //itna sab jo upar if else conditions lagayi hai uske bajaye ham single line of code mein aise likh skte hai
        for(int i = 0 ; i < arr.length ; i++){
        map.put(arr[i], map.getOrDefault(arr[i],0) + 1);    
        }

        // Set<Integer> keyset = map.keySet();  ise likhne ke bajaye aise bhi kr skte hai
        for (Integer k : map.keySet()) {
            if(map.get(k) > arr.length/3){
                System.out.println(k);
            }   
        }
    }
}