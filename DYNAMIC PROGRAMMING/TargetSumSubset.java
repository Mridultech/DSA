public class TargetSumSubset {

    /*
     * Problem statement : hame ek array diya gaya hai or ek target sum diya gaya hai ye pata krna hai ki kya aise subsets hai array mein jinka sum target sum ke barabar ho sake.
     *
     * Similar type of question as that of 0-1 knapsack just isme value and weight dono same hai.
     * ab isme ham ek 2d array hi banayenge jisme i i.e rows batayengi number of elements in subset 
     * and j i.e columns batayenge subset sum
     * here i , j represents ki kya i elements ka subset sum target j ke barabar aa skta hai or har cell mein boolean t or f store hoga.
     * Note : jab intialize kr rhe hai to sab starting mein false hi hota hai.
     * 2. yaha ye 0th-column,row isiliye lete hai kyuki isi mein ham initialization ki condition puri krte hai alag se nahi likhte hai.
     * 
     * Tip : is tarike ke jitne bhi variations aayenge unme se jada kaa naam aisa hi hota hai target sum wagera or inme jadatr knapsack ki approach lagti hai jisme jo target diya gaya hota hai use jadatr knapsack ki capacity manke chalte hai.
     */

     public static boolean targetSumSubset(int arr[], int sum){ // Time complexity : O(n * sum), where n = number of items or numbers.
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        //here i = items , j = subset sum
        for(int i = 0 ; i < n+1; i++){
            dp[i][0] = true;
        }

        for(int i = 1 ; i < n+1 ; i++){
            for(int j = 1 ; j < sum + 1 ; j++){
                int v = arr[i-1]; // i-1th item ki wohi value hai jo uske index pe store hai v is for value of item
                //include
                if(v <= j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                }
                //exclude
                else if(dp[i-1][j]){
                    dp[i][j] = true;
                }
            }
        }
        print(dp);
        return dp[n][sum];
     }

     public static void print(boolean dp[][]){
 //printing dp :
 for(int i = 0 ; i < dp.length; i++){
    for(int j = 0 ; j < dp[0].length ; j++){
        System.out.print(dp[i][j] + " ");
    }
    System.out.println();
}
System.out.println();
}
    public static void main(String[] args){
        int arr[] = {4, 2, 7, 1, 3};
        int sum = 10;

        System.out.print("Is Possible ? : " + targetSumSubset(arr,sum));

       
    }
}