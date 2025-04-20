public class UnboundedKnapsack {

    /*
     * Unbounded Knapsack : 
     * Difference from other knapsack problems : item ko knapsack mein repeatedly kitni bhi baar daal sakte hain.  
     * Iska matlab hai ki hum items ko bina kisi limit ke use kar sakte hain.
     * 
     * similar problems : Coin Change Problem, Rod Cutting Problem, etc.
     */
    
    public static int unboundedKnapsack(int val[], int wt[], int capacity){
        int n = val.length;
        int dp[][] = new int[n+1][capacity+1];

        //Note : java mein intialization aise krne ki need nahi hai kyuki auto. 0 se hi intialize hota hai but for concept karke dikhaya gaya hai.
        // for(int i = 0; i < n+1; i++){
        //     dp[i][0] = 0;
        // }
        // for(int j = 0 ; j < n+1; j++){
        //     dp[0][j] = 0;
        // }

        for(int i = 1 ; i < n+1; i++){
            for(int j = 1; j < capacity + 1; j++){
                if(wt[i-1] <= j){
                    dp[i][j] = Math.max(val[i-1] + dp[i][j - wt[i-1]], dp[i-1][j]); // bas change itna sa hai ki dp[i-1][j - wt[i-1]] ki jagah dp[i][j - wt[i-1]] kyuki ham ith element ko repeatedly bhi add kr skte hai sack mein.
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        // print(dp);
        print(dp);
        return dp[n][capacity];

    }

    public static void print(int dp[][]){
        for(int i = 0 ; i < dp.length; i++){
            for(int j = 0 ; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int capacity = 7;
        System.out.println(unboundedKnapsack(val, wt, capacity));
    }
} 
    

