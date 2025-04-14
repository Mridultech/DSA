public class RatInAMaze{

    /*  Rat in a Maze
 You are given a starting position for a rat which is stuck in a maze at an initial point (0, 0) (the
 maze can be thought of as a 2-dimensional plane). The maze would be given in the form of a
 square matrix of order N * N where the cells with value 0 represent the maze’s blocked
 locations while value 1 is the open/available path that the rat can take to reach its destination.
 The rat's destination is at (N - 1, N - 1).
 Your task is to find all the possible paths that the rat can take to reach from source to
 destination in the maze.
 The possible directions that it can take to move in the maze are 'U'(up) i.e. (x, y- 1) , 'D'(down)
 i.e. (x, y + 1) , 'L' (left) i.e. (x - 1, y), 'R' (right) i.e. (x + 1, y).
 (This problem is similar to Grid ways.)
 */


    public static boolean isSafe(int maze[][] , int i , int j){
        // yaha condition check kar rhe hai ki jana safe hai ya nahi agar 0 encounter hota hai to nahi hai warna hai

        //up
        if((i > 0 && maze[i-1][j] == 0) || (i < maze.length - 1 && maze[i+1][j] == 0) || 
           (j > 0 && maze[i][j-1] == 0) || (j < maze[0].length - 1 && maze[i][j+1] == 0)) {
            return false;
        } else {
            return true;
        }
        
      

    }
    public static int mazePaths(int maze[][] , int i , int j , int n , int m){
        //base case 
        if(i == n-1 && j == m-1){ // last cell condition
            return 1;
        }
        else if(i >= maze.length || j >= maze.length){
            return 0;
        }

           //kaam
        if(isSafe(maze , i , j)){
            return mazePaths(maze, i+1, j, n, m) + mazePaths(maze, i, j+1, n, m);
        }
        else{
            System.out.println("paths not possible !");
            return 0;
        }
    
    }
    public static void main(String[] args){
        int maze[][] = {{1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {0, 1, 0, 0},
                        {1, 1, 1, 1} 
                    }; // yaha pe 1 wo positions hai jisme rat jaa skta hai or 0 wo positions hai jisme rat nahi jaa skta hai
        int n = maze.length;
        int m = maze[0].length;
        mazePaths(maze , 0, 0 , n , m);
        }
    }
