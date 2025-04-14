import java.util.*;

public class FloydTriangle{
 
    public static void floydTriangle(int rows){
        int num = 1 ;
        for(int i = 1 ; i <= rows ; i++){
            for(int j = 1 ; j <= i ; j++){
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        System.out.println("Program to print floyd's triangle");
        System.out.println("Enter the number of rows you want to print in pattern :");
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        floydTriangle(rows);
    }
}