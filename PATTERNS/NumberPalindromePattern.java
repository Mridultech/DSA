import java.util.*;

public class NumberPalindromePattern{

    public static void numberPalindrome(int rows){
        //outer loop for rows

        for(int i = 1 ; i <= rows ; i++){

            // first inner loop for spaces - rows-i

            for(int j = 1 ; j <= (rows-i) ; j++){
                System.out.print(" ");
            }

            // Second inner loop for descending half pattern of numbers 

            for(int j = i ; j >= 1 ; j--){
                System.out.print(j);
            }

            // Third inner loop for ascending half pattern of numbers 

            for(int j = 2 ; j <= i ; j++){
                System.out.print(j);
            }

            System.out.println();

        }
    }
    public static void main(String[] args) {
        
        System.out.println("Program to print number palindromic pattern : ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows you want in pattern :");
        int rows = sc.nextInt();
        numberPalindrome(rows);

    }
}
