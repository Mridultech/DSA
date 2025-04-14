import java.util.*;
public class InvertedHalfNumberPyramid{

    public static void invertedPyramidOfNumbers(int rows){
        /* My logic ! but worked correctly
        int temp = rows;
        for(int i = 1 ; i <= rows ; i++){
            for(int j = 1 ; j<=temp ; j++){
                System.out.print(j + " ");
            }
            temp--;

            System.out.println();
            */
        for(int i = 1 ; i <= rows ; i++){
            for(int j = 1 ; j <=(rows-i+1) ; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows you want for your pattern :");
        int rows = sc.nextInt();
        invertedPyramidOfNumbers(rows);
    }
}