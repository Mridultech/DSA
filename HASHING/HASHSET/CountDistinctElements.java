import java.util.*;
public class CountDistinctElements {

    /*
     * Problem statement : In a given array, count the number of distinct elements.
     * Input : [4,3,2,5,6,7,3,4,2,1]
     * Output : 7
     * 
     * Approach :
     * 1. brute force approach : O(n^2) time complexity
     * 2. using hashset : O(n) time complexity and O(n) space complexity
     */
    public static void main(String[] args) {
        int num[] = {4,3,2,5,6,7,3,4,2,1};

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ; i < num.length ; i++){
            set.add(num[i]);
        }

        System.out.print("size is : " + set.size());
    }
}