public class Sudoku{ 

    /*
     * methodology :
     * 1. find an empty cell in the sudoku board
     * 2. try to fill the cell with numbers from 1 to 9
     * 3. check if the number is valid (not already in the row, column or 3x3 box)
     * 4. if the number is valid, fill the cell and call the function recursively to fill the next cell
     * 6. if the function returns false, backtrack and try the next number
     * 7. if all numbers have been tried and none are valid, return false
     * 8. if the board is completely filled, return true
     * 
     */

     public static boolean isSafe(int sudoku[][] , int row , int col , int digit){
        //check in the row
        for(int i = 0 ; i < 9 ; i++){
            if(sudoku[row][i] == digit){
                return false; // if the digit is already in the row, return false
            }
        }
        //check in the column
        for(int i = 0 ; i < 9 ; i++){
            if(sudoku[i][col] == digit){
                return false; // if the digit is already in the column, return false
            }
        }
        //check in the 3x3 box
        /*
         * logic kya hai iske piche : 
         * 1. 3x3 box ka starting row aur column nikal lo
         * 2. fir us box ke andar ke cells ko check karo ki kya digit already hai ya nahi
         * 3. agar hai to return false, nahi to return true
         * 4. starting row aur column nikalne ka formula hai (row/3)*3 aur (col/3)*3
         * 
         * ex : for rows agar rows 0,1,2 hai to formula (0/3)*3 = 0, (1/3)*3 = 0, (2/3)*3 = 0
         * for rows 3,4,5 hai to formula (3/3)*3 = 3, (4/3)*3 = 3, (5/3)*3 = 3
         * for rows 6,7,8 hai to formula (6/3)*3 = 6, (7/3)*3 = 6, (8/3)*3 = 6
         * 
         * similarly for columns agar columns 0,1,2 hai to formula (0/3)*3 = 0, (1/3)*3 = 0, (2/3)*3 = 0
         * for columns 3,4,5 hai to formula (3/3)*3 = 3, (4/3)*3 = 3, (5/3)*3 = 3
         * for columns 6,7,8 hai to formula (6/3)*3 = 6, (7/3)*3 = 6, (8/3)*3 = 6
         * 
         */
        int startRow = (row / 3) * 3; // starting row of the box 
        int startCol = (col / 3) * 3; // starting column of the box
        for(int i = startRow ; i < startRow + 3 ; i++){
            for(int j = startCol ; j < startCol + 3 ; j++){
                if(sudoku[i][j] == digit){
                    return false; // if the digit is already in the box, return false
                }
            }
        }
        return true; // if the digit is not in the row, column or box, return true
     }

     public static boolean sudokuSolver(int sudoku[][], int row, int col){
        //base case
        if(row == 9){ // if we have reached the last row, return true
            return true; // sudoku is solved
        }

        //recursion
        int nextRow = row , nextCol = col + 1;
        if(nextCol == 8){ // if we are at the last column, move to the next row
            nextRow = row + 1;
            nextCol = 0;
        }
        
        if(sudoku[row][col] != 0){ // if the cell is already filled, move to the next cell
            if(row == 8 && col == 8){ // if we are at the last cell, return true
                return true;
            }
            return sudokuSolver(sudoku , nextRow , nextCol); // call the function recursively to fill the next cell
        }
        for(int digit = 1 ; digit <= 9 ; digit++){
            if(isSafe(sudoku , row , col , digit)){ // yaha check kr rhe hai ki valid hai ya nahi digit ko enter krna
                sudoku[row][col] = digit; // fill the cell with the digit
                if(sudokuSolver(sudoku , nextRow , nextCol)){ // call the function recursively to fill the next cell
                    return true; // if the function returns true, return true
                }
                sudoku[row][col] = 0; // if the function returns false, backtrack and try the next number
            }
        }
        return false; // if all numbers have been tried and none are valid, return false
    }
     

        // function to print the sudoku board
        public static void printSudoku(int sudoku[][]){
            for(int i = 0 ; i < 9 ; i++){
                for(int j = 0; j < 9 ; j++){
                    System.out.print(sudoku[i][j] + " "); // print the cell value
                }
                System.out.println(); // print a new line after each row
            }
        } 


    public static void main(String[] args){
        int sudoku[][] = { {0, 0, 8, 0, 0, 0, 0, 0, 0,},
        {4, 9, 0, 1, 5, 7, 0, 0, 2},
        {0, 0, 3, 0, 0, 4, 1, 9, 0},
        {1, 8, 5, 0, 6, 0, 0, 2, 0},
        {0, 0, 0, 0, 2, 0, 0, 6, 0},
        {9, 6, 0, 4, 0, 5, 3, 0, 0},
        {0, 3, 0, 0, 7, 2, 0, 0, 4},
        {0, 4, 9, 0, 3, 0, 0, 5, 7},
        {8, 2, 7, 0, 0, 9, 0, 1, 3}
    };
    if(sudokuSolver(sudoku, 0, 0)){
        System.out.println("Sudoku solved successfully!");
        printSudoku(sudoku); // print the solved sudoku board
    }
    else{
        System.out.println("Sudoku cannot be solved!");
    }
}
}
