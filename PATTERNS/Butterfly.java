import java.util.*;

public class Butterfly{

    public static void butterfly(int rows){
        for (int i=1 ;i<=rows;i++){
            //stars - i
            for(int j=1;j<=i;j++){
                System.out.print("*" + " ");
            }
            //spaces - 2(i-1)
            for(int j=1;j<=(2*(rows-i));j++){
                System.out.print(" " + " ");
            }
            //stars - i
            for(int j=1;j<=i;j++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }   

            for(int i = rows ; i >= 1 ; i--){
                
                //stars - i

                for(int j=1;j<=i;j++){
                System.out.print("*" + " ");
                }

                //spaces - 2(i-1)

                for(int j=1;j<=(2*(rows-i));j++){
                System.out.print(" " + " ");
                }

                //stars - i

                for(int j=1;j<=i;j++){
                System.out.print("*" + " ");
                }
                
                System.out.println();
            }

    }
    public static void main(String[] args) {
        
        System.out.println("Program to print butterfly pattern   : ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows you want in pattern :");
        int rows = sc.nextInt();
        butterfly(rows);

    }
}
