public class Knapsack01 {
    /*
     * aise objects milenge jinka fractional use nahi hai yeha to bag mein daal skte hai ya nahi . 
     * ex : fridge, laptop, phone, tablet, pencil, book etc. 
     * isme keval ek single type ka item ek hi piece allowed hai.
     * 
     * Tip : agar choice ho to tabulation ka code likhna chaiye kyuki kabhi kabhar memoization fail kr jata hai due to stack overflow but tabulation kabhi fail nahi krta hai.
     * 
     * condition for including item in sack : 
     * weight of item <= space or weight bearing capacity remaining in sack.
     * agar item include kra to : 
     * Remaining capacity = current capacity of sack - weight of item.
     */

    // Now by memoization 
    /*
     * yaha 2 variables hai capacity and number of item so ham 2d array banayenge .
     * Note : array  ka size n+1 kyu lete hai kyuki ek extra n = 0 bhi lete hai for intialization purposes.
     */

    public static int knapsack(int val[], int wt[], int capacity, int n, int dp[][]){ // time complexity : By recursion : O(2^n) || By memoization : O(n*capacity)
        if(capacity == 0 || n == 0){
            return 0;
        }

        if(dp[n][capacity] != -1){
            return dp[n][capacity];
        }

        if(wt[n-1] <= capacity){ // valid
            //include
            int ans1 = val[n-1] + knapsack(val, wt, capacity - wt[n-1], n-1, dp);
            //exclude
            int ans2 = knapsack(val,wt,capacity,n-1, dp);
            dp[n][capacity] = Math.max(ans1,ans2); // calculating maximum ans out of both
            return dp[n][capacity];
        }
        else {// not valid
            dp[n][capacity] = knapsack(val,wt,capacity,n-1, dp);
            return dp[n][capacity];
        }
    }

    // Now by tabulation : 
    public static int knapsackTab(int val[], int wt[], int cap){
        int n = val.length;
        int dp[][] = new int[n+1][cap+1];
        for(int i = 0 ; i < dp.length; i++){ // intializing 0th column
            dp[i][0] = 0;
        }
        for(int j = 0 ; j < dp[0].length; j++){ // intializing 0th row
            dp[0][j] = 0;
        }

        for(int i = 1 ; i < n+1; i++){
            for(int j = 1 ; j < cap+1; j++){
                int v = val[i-1];
                int w = wt[i-1]; // ✅ YAHI LINE FIX KI GAYI HAI
                if(w <= j){ // valid
                    int includeProfit = v + dp[i-1][j-w];
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = Math.max(includeProfit, excludeProfit);
                    dp[i][j] = Math.max(includeProfit,excludeProfit);
                }
                else { //invalid
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = excludeProfit;
                }
            }
        }
        return dp[n][cap];
    }

    
    public static void main(String[] args){
        int values[] = {15,14,10,45,30};
        int weight[] = {2,4,1,3,4};
        int capacity = 7;

        // System.out.println("Maximum profit earned can be : " + knapsack(values,weight,capacity,values.length)); nowrmal by recursion

        //memoization 
        int dp[][] = new int[values.length+1][capacity+1]; // is array mein for each cell value it means that for first 0 to i items and given capacity j what will be the max. profit possible.

        for(int j = 0 ; j < dp.length; j++){
            for(int k = 0 ; k < dp[0].length; k++){
                dp[j][k] = -1;
            }
        }

        System.out.println("Maximum profit earned can be : " + knapsack(values,weight,capacity,values.length,dp));

        System.out.println("Maximum profit earned can be : " + knapsackTab(values, weight, capacity));
    }

}
