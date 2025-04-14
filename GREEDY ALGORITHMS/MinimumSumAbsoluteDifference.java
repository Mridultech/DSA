import java.util.*;
public class MinimumSumAbsoluteDifference{ // Time Complexity: O(nlogn)[for sorting] + O(n)[for loop] = O(nlogn) , Space Complexity: O(1)

    /*problem statement : Given two arrays A and B of equal length n . Pair each element of array A to an elemnent in array B , such that the sum of the absolute differences of the pairs is minimized. Return the minimum sum of absolute difference.
    * Absolute difference of two integers x and y is defined as |x - y|.
    * Example 1:
    * Input: A = [1,2,3], B = [10,20,30]
    * 
    * Approach:
    * Dono numbers ka absolute difference utna hi kam hoga jitna wo dono aaspaas honge 
    * So sort both the arrays and then take the absolute difference of ith element of A and B.
    *
    */
    
    public static int minSumAbsDiff(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += Math.abs(A[i] - B[i]);
        }
        return sum;
    }

    public static void main(String[] args){

        int[] A = {1, 2, 3};
        int[] B = {2, 1, 3};
        System.out.println(minSumAbsDiff(A, B)); // Output: 0
    }
}