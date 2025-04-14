import java.util.*;
public class XToPowerN { // Time Complexity : O(n) and Space Complexity : O(n) for first less optimized approach
    /*
     * call stack analysis : let say for base nubmer 2 and power 5
     * 
     * |power x = 2 n = 0 | yaaha pe 1 return hoga 
     * |power x = 2 n = 1 | : 2 * 1 = 2 return hoga
     * |power x = 2 n = 2 | : 2 * 2 = 4 return hoga
     * |power x = 2 n = 3 | : 2 * 4 = 8 return hoga
     * |power x = 2 n = 4 | : 2 * 8 = 16 return hoga
     * |power x = 2 n = 5 | : 2 * 16 = 32 return hoga
     * | main x = 2 n = 5 | : 32 return hoga
     */

    public static int power(int x , int n){
        //less optimized approach 

        // if(n == 0){
        //     return 1;
        // }
        
        // return x * power(x,n-1);

        //optimized approach : For this time complexity is O(logn) and space complexity is O(logn)
        
        if (n == 0){
            return 1;
        }
        int halfpower = power(x,n/2);
        if(n % 2 != 0){
            int xn = halfpower * halfpower * x;
            return xn;
        }
        else{
            int xn = halfpower * halfpower;
            return xn;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int x = sc.nextInt();
        System.out.println("Enter the power :");
        int n = sc.nextInt();
        System.out.println(x + " to the power " + n +  " is : " + power(x,n));
    }
}
