import java.util.*;
public class sumOfDigitsInNumber{

    public static int sumofdigits(int num){
        int sum = 0 ;
        while(num > 0){
            int last_digit = num%10;
            sum += last_digit;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println("Program to print sum of digits in a number");
        System.out.println("Enter the number :");
        Scanner sc = new Scanner(System.in);
        
        if(!sc.hasNextInt()){
            System.out.println("invalid input! Please enter an integer !");
        }
       
            int num = sc.nextInt();
        
        
        System.out.println("Sum of Digits of given number " + num + " is : " + sumofdigits(num));

    }
}