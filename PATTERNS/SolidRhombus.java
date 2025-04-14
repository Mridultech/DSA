import java.util.*;

public class SolidRhombus{

    public static void solidRhombus(int rows,int stars){
        for(int i = 1 ; i <= rows ; i++){

            // spaces - (n-i)

            for(int j = 1 ; j <= (rows-i) ; j++){
                System.out.print(" " + " ");
            }

            // stars = 5(let)

            for(int j = 1 ; j <= stars ; j++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        
        System.out.println("Program to print Solid Rhombus : ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows you want in pattern :");
        int rows = sc.nextInt();
        System.out.println("Enter the number of stars you want in pattern :");
        int stars = sc.nextInt();
        solidRhombus(rows,stars);

    }
}
