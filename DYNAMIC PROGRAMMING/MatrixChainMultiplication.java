import java.util.*;

public class MatrixChainMultiplication {

    public static int matrixChainMultiplicationMemoization(int arr[], int i , int j, int dp[][]){

        if(i == j){
            return 0; // agar i == j hai toh koi multiplication nahi hoga toh cost 0 hai.
        }

        if(dp[i][j] != -1){ // agar dp mein value hai toh wahi return karenge.
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE; // minimum cost ko store karne ke liye.

        for(int k = i ; k <= j-1; k++){
            int cost1 = matrixChainMultiplicationMemoization(arr, i, k, dp);
            int cost2 = matrixChainMultiplicationMemoization(arr, k+1, j, dp);
            int cost3 = arr[i-1] * arr[k] * arr[j]; // multiplication cost

            ans = Math.min(ans , cost1 + cost2 + cost3); // minimum cost of multiplication of Ai to Ak and Ak+1 to Aj
        }

        return dp[i][j] = ans; // dp array mein store karenge.
    }

    public static int matrixChainMultiplicationTabulation(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];

        //intialization of dp array
        for(int i = 1 ; i < n ; i++){
            dp[i][i] = 0; // diagonal ko 0 se fill karenge kyuki wahi multiplication nahi
        }

        // bottom-up
        for(int len = 2 ; len < n ; len++){ // length of chain
            for(int i = 1 ; i < n - len + 1; i++){
                int j = i + len - 1; // end index of chain

                dp[i][j] = Integer.MAX_VALUE; // minimum cost ko store karne ke liye.

                for(int k = i ; k <= j-1; k++){
                    int cost1 = dp[i][k]; // Ai to Ak ka cost
                    int cost2 = dp[k+1][j]; // Ak+1 to Aj ka cost
                    int cost3 = arr[i-1] * arr[k] * arr[j]; // multiplication cost

                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3); // minimum cost of multiplication of Ai to Ak and Ak+1 to Aj
                }
            }
        }
        return dp[1][n-1]; // 1 se n-1 tak jayenge kyuki 0th index mein matrix nahi hai.    
    }
    public static void main(String[] args){
        int arr[] = {1, 2, 3, 4, 3};
        int n = arr.length;
        int dp[][] = new int[n][n];

        // ✅ dp array ko sirf yahin fill karo -1 se, na ki har recursive call ke andar
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println("Minimum cost of multiplication calculated by memoization is : " + matrixChainMultiplicationMemoization(arr, 1, n-1, dp)); // 1 se n-1 tak jayenge kyuki 0th index mein matrix nahi hai.
        System.out.println("Minimum cost of multiplication calculated by tabulation is : " + matrixChainMultiplicationTabulation(arr)); // 1 se n-1 tak jayenge kyuki 0th index mein matrix nahi hai.
    }
}
