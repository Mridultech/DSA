import java.util.*;
public class Inverted_rotated_halfpyramid {
    
    //function for pattern
    
    public static void Invertedrotatedhalfpyramid(int rows){
        
        // For number of rows - outer loop
        for(int i = 1 ; i <= rows ; i++){
            //spaces - first nested loop
            for(int j = 1 ; j <= (rows-i) ; j++){
                System.out.print(" ");
            }
            //stars
            for(int k = 1 ; k <= i ; k++){
                System.out.print("*");
            }
            
            System.out.println();
        }       
    }
    public static void main(String[] args) {
        System.out.print("Enter the number of rows you want in pattern :");
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        Invertedrotatedhalfpyramid(rows);
    }
}
