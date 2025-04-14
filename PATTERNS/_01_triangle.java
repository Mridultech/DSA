import java.util.*;

public class _01_triangle{

    public static void $01_triangle(int rows){
        int num = 1;
        for(int i = 1 ; i <= rows ; i++){
            for(int j = 1 ; j <= i ; j++){
                //Main logic
                if((i+j)%2==0){
                    System.out.print(1 + " ");
                }
                else{
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        
        System.out.println("Program to print 0-1 trianle : ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows you want in pattern :");
        int rows = sc.nextInt();
        $01_triangle(rows);

    }
}