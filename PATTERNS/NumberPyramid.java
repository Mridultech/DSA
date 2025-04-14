import java.util.*;

public class NumberPyramid{

    public static void numberPyramid(int rows){
        
        for(int i = 1 ; i <= rows ; i++){

            //spaces = rows-i

            for(int j = 1 ; j <= (rows-i) ; j++){
                System.out.print(" ");
            }

            //numbers = i 

            for(int j = 1 ; j <= i ; j++){
                System.out.print(i + " ");
            }

            System.out.println();
        }
        
    }
    public static void main(String[] args) {
        
        System.out.println("Program to print 0-1 trianle : ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows you want in pattern :");
        int rows = sc.nextInt();
        numberPyramid(rows);

    }
}
