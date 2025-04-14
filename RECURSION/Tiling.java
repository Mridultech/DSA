import java.util.*;
public class Tiling {

    /*
     * methodology : ek board diya hai let say '2xn' dimension ka with '2x1' dimension of tile so we've to figure out no. of ways or possible arrangements to put tiles to fillup the board.
     * 
     * concept : agar horizontal lagayenge to uske niche confirm horizontal hi lagegi that mean for horizontal f(n-2)  = 2 * (n-2)
     * similarly by observation for vertical f(n-1) = 2 * (n-1)
     * total ways = horizontal + vertical
     * 
     */
    public static int tiling(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        //vertical

        int fnm1 = tiling(n-1);

        //horizontal

        int fnm2 = tiling(n-2);

        int totalways = fnm1 + fnm2;

        return totalways;
    }
    public static void main(String[] args){
        //Problem statement : Given a "2 x n" board and tiles of size "2 x 1", count the number of ways to tile the given board using the 2 x 1 tiles.(The tiles can be placed horizontally or vertically)
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length dimension of the board :");
        int length = sc.nextInt();
        System.out.println("Number of possible arrangements on given length dimension" + length + "of board are : " + tiling(length));
        sc.close();
    }
}
