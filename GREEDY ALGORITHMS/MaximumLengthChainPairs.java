import java.util.*;
public class MaximumLengthChainPairs { // similar question like activity solution , time complexity O(nlogn) , space complexity O(1)

    /*
     * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
     * A pair (c, d) can follow another pair (a, b) if and only if b < c.
     * Find the longest chain which can be formed in this way.
     * 
     * Note : Greedy ke jadatr problems mein sorting ka istemal hoga.
     * 
     * approach : 
     * 1. Sort the pairs based on the second number of each pair.
     * 2. 1st pair is always included in the chain.
     * 3. for(int i = 1; i < n; i++){
     * pair -> start > lastselected -> end){
     * ans++
     * lastselected = pair;}
     */
    public static void main(String[] args){
        int pairs[][] = {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}};

        Arrays.sort(pairs , Comparator.comparingDouble(o -> o[1]));

        int chainLength = 1;
        int pairEnd = pairs[0][1]; //last selected pair chain end

        for(int i = 1 ; i < pairs.length ; i++){
            if(pairs[i][0] > pairEnd){
                chainLength++;
                pairEnd = pairs[i][1]; //update the last selected pair end
            }
        }

        System.out.println("Maximum length of chain: " + chainLength);

    }
}
