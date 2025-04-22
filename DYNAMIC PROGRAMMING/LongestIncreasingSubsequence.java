import java.util.*;
public class LongestIncreasingSubsequence {

    /*
     * 1. Hashset -> unique elements nikal lenge from orignal array
     * 2. nayi modified array se or orignal array se lcs(longest common subsequence nikal lenge).
     * 3. final longest increasing subsequence is longest common subsequence of both arrays.
     * 
     * 
     */

     public static int longestCommonSubsequence(int arr1[], int arr2[]){
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];

        //intialize - zarurat nahi hai in java but just kara hai for better understanding.
        for(int i = 0; i < n+1; i++){
            dp[i][0] = 0;
        }

        for(int j = 0; j < m+1; j++){
            dp[0][j] = 0;
        }

        for(int i = 1 ; i < n+1; i++){
            for(int j = 1 ; j < m+1; j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
     }
    public static int longestIncreasingSubsequence (int arr1[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr1.length; i++){
            set.add(arr1[i]);
        }
        int arr2[]= new int[set.size()]; //sorted unique elements
        int i = 0;
        for(int num : set){
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2);
        return longestCommonSubsequence(arr1,arr2);
    }
    public static void main(String[] args){
        int arr[] = {50,3,10,7,40,80};
        System.out.println("Longest increasing subsequence is : " + longestIncreasingSubsequence(arr));
    }
}
