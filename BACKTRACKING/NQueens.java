public class NQueens { //Time Complexity : O(n!) , Space Complexity : O(n^2)

     /*
         * Problem Statement: The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
         * isme teen tarike ke question ban sakta hai:
         * 1. Print all possible solutions
         * 2. Print one possible solution if it exists
         * 3. Count all possible solutions
         * 
         * we will solve the first question here
         * To print all possible solutions 
         */
        
        static int count = 0;

    public static boolean isSafe(char board[][] , int row , int col){ 
        /*
         * terminology : 
         * let imagine that ham centre of matrix pe hai 5x5 ke to hame dekhna hai ki hamari queen ko koi aur queen to cancel nahi kr rhi hai
         * to hame keval present position ke upar , upar wale portion ke primary and secondary diagonals pe check krna hoga kyuki in teen jagah ko chodke kahi or koi elements hai hi nahi .
         * or yehi terminology har situation ke liye kaam kregi .
         */

         // upar ke liye check karte hai
         for(int i = row-1 ; i >= 0 ; i--){
            if(board[i][col] == 'Q'){ // board[i][j].equals('Q') ye possible nahi hai kyuki equals keval objects ko compare kr skta hai primitive datatypes like char ko nahi
                return false;
            }
         }

         //upar ke primary diagonal ke liye 
         for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
         }

         //upar ke secondary diagonal ke liye 
         for(int i = row-1, j = col+1; i >= 0 && j < board.length ; i-- , j++){
            if(board[i][j] == 'Q'){
                return false;
            }
         }

         return true;
    }

    public static void printBoard(char board[][]){
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void nQueens(char board[][],int row){
        //base case
        if(row == board.length){
            printBoard(board);
            System.out.println("------------/chess-board/------------");
            count++;
            return;
        }

        //kaam
        for(int j = 0 ; j < board.length ; j++){
            if(isSafe(board,row,j)){
            board[row][j] = 'Q';
            nQueens(board,row+1); // recursive step
            board[row][j] = 'x'; // backtracking step
            }
        }

        }
    

    public static void main(String[] args) {

        // board ke dimension leke khali board bana liya : min[4]

        int n = 5 ; // kyuki 2 se niche dimension ke liye koi board hi nahi hoga & for n = 3 there is no combination possible .
        char board[][] = new char[n][n];

        // board ko initialize kar diya

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = 'x';
            }
        }

        // ab hum is board pe queen place karenge

        nQueens(board,0);
        
        System.out.println("Total number of possible solutions are : " + count);
    }
}