import java.util.*;
public class Factorial {

    /*
     * factorial : n! = n * (n-1) * (n-2) * (n-3) * .... * 1
     * factorial of 0 is 1
     * factorial of 1 is 1
     *  
     * call stack for factorial : let say for n = 5
     * 
     * |fact n = 0| yaha pe f(n-1) = f(0) = 1
     * |fact n = 1| fir ye niche ki tarf values deta rhega or aakhir mein factorial mil jayega. 
     * |fact n = 2|
     * |fact n = 3|
     * |fact n = 4|
     * |fact n = 5|
     * |main(5)| // aakhir main main function output de dega output device pe 
     */

    public static int factorial(int n){
            if(n == 0){
                return 1 ;
            }

        int factnm1 = factorial(n-1);
        int fact = n * factorial(n-1);

        return fact;
    }
    
    
    public static void main(String[] args) {
        System.out.println("Program to find factorial of a number using recursion");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number whose factorial you want to find : ");
        int number = sc.nextInt();
        System.out.println("Factorial of a given number is : " + factorial(number));
        sc.close();
    }   
}
