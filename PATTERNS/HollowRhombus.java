import java.util.*;

public class HollowRhombus{

    public static void hollowRhombus(int rows,int stars){
        for(int i = 1 ; i <= rows ; i++){

            // spaces - (n-i)

            for(int j = 1 ; j <= (rows-i) ; j++){
                System.out.print(" " + " ");
            }

            // stars - same as that in hollow rectangle
            for(int j = 1 ; j <= stars ; j++){
                if(i == 1 || i == rows || j == 1 || j == rows){
                System.out.print("*" + " ");
                }
                else{
                    System.out.print(" " + " ");
                }
            }    
            System.out.println();


            }
        }
    
    public static void main(String[] args) {
        
        System.out.println("Program to print Hollow Rhombus : ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows you want in pattern :");
        int rows = sc.nextInt();
        System.out.println("Enter the number of stars you want in pattern :");
        int stars = sc.nextInt();
        hollowRhombus(rows,stars);

    }
}
