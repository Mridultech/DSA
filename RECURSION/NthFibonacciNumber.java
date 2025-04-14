import java.util.Scanner;
public class NthFibonacciNumber { // Time complexity : O(2^n) , Space complexity : O(n) , kyuki jab 2 ya jada recursion calls hai to pseduo structure kuch tree ke form mein banega jiski height on worst scenario hogi n , so space complexity will be O(n).

    /*
     * Problem : To find the nth Fibonacci number.
     * 
     * Fibonacci series : 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 ...
     * 
     * Formula : fn = fn-1 + fn-2
     */

    public static int fibonacci(int n) {
        if(n == 1 || n == 0) {
            return n;
        }
         int fnm2 = fibonacci(n-2);
         int fnm1 = fibonacci(n-1);
         int fn = fnm1 + fnm2;
        return fn;
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        System.out.println("The " + n + "th Fibonacci number is: " + fibonacci(n));
        sc.close();
    }
}
