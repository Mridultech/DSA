public class GridWays { // Time complexity : O(2^(n+m)) , n = number of rows to be traversed to final , m number of column to be traversed to reach final , 2 because every cell has 2 choice.

    /*
     * terminology : 
     * i : current row
     * j : current column
     * n : total number of rows
     * m : total number of columns
     * 
     * Problem statement : find the number of ways to reach from top left to bottom right in a grid of size m*n
     * you can only move right or down
     * 
     */
    public static int gridWays(int i , int j , int n , int m){

        //base-case 
        if(i == n-1 && j == m-1){ // condition for last cell
            return 1;
        }
        else if(i >= n || j >= m){ // boundary cross condition
            return 0;
        }
        
        //recursive case
        return gridWays(i+1,j,n,m) + gridWays(i,j+1,n,m);
    }
    public static void main(String[] args){

        int n = 3 , m = 3;
        System.out.println(gridWays(0,0,n,m));

    }
}
