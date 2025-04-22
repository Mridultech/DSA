public class EditDistance { // O(n*m)


    /*
     * Problem statement : Given two strings word1 and word2, return the minimum number of perations required to convert word1 to word2
     * You have the following three operations permitted on a word.
     * Insert a character : after modification : str1(n)str2(m-1) + 1
     * Delete a character : after modification :  str1(n-1)str2(m) + 1
     * Replace a character : after modification : str1(n-1)str2(m-1) + 1
     * 
     * yaha 2d array banega because of 2 vars. i and j 
     * isme (i,j)th index pe ye store hoga ki str1 ki length i hai and str2 ki j hai to dono mein common lcs kya hoga.
     * 
     * 
     */

    public static int editDistance(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        //Initialize 
        for(int i = 0 ; i < n+1; i++){
            for(int j = 0 ; j < m+1; j++){
                if(i==0){
                    dp[i][j] = j;
                }
                if(j == 0){
                    dp[i][j] = i;
                }
            }
        }

        for(int i = 1 ; i < n+1; i++){
            for(int j = 1 ; j < m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    int add = dp[i][j-1] + 1;
                    int del = dp[i-1][j] + 1;
                    int rep = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(add, Math.min(del,rep)) ;
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args){
        String word1 = "intention";
        String word2= "execution";
        System.out.println(editDistance(word1, word2));
    }
    
}
