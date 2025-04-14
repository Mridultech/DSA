import java.util.*;
public class Basics{
    /*
     * Recursion is a method to solve a computational problem by dividing it into further small problems.
     * 
     * Base Case : The smallest possible problem that can be solved directly.
     * Recursive Case : The problem that can be s]]olved by breaking it into smaller problems. 
     * 
     * recursion steps 
     * Base Case pata hona chaiye
     * function ke andr kya kaam hona hai wo pata hona chaiye
     * inner call lagani jisse wo sub smaller problems ko solve kare.
     * 
     * Memory mein chize kaam kaise karti hai ?
     * jab bhi koi bhi ek function dusre function ko call lagata hai to call stack banta hai 
     * 
     * 
     * yaha pe jo meine niche program banaya hai usko stack ki form mein niche banate hai 
     * let say agar n = 10 hai 
     * 
     * call stack for print decreasing : 
     * 
     * | printDecreasing(1)  | value jo print hogi = 9
     * | printDecreasing(2)  | value jo print hogi = 8
     * | printDecreasing(3)  | value jo print hogi = 7
     * | printDecreasing(4)  | value jo print hogi = 6
     * | printDecreasing(5)  | value jo print hogi = 5
     * | printDecreasing(6)  | value jo print hogi = 4
     * | printDecreasing(7)  | value jo print hogi = 3
     * | printDecreasing(8)  | value jo print hogi = 2
     * | printDecreasing(9)  | value jo print hogi = 1 iske baad bas conditions check karte raho
     * | printDecreasing N = 10 | iske baad main fucntion printDecreasing(10) ko call karega
     * | main N = 10 | sabse pehle main fucntion mein value of n hai 10
     * 
     * isme top be hamara base case hai to jo hai n == 1 jaha se fir return ho jayega or sari values reverse fashion mein print ho jayegi.
     * 
     *  Stack Overflow : 
     * jab bhi recursion mein koi bhi function infinite times call hoti hai to stack overflow ho jata hai.
     * stack overflow ka karan hai ki jab ek function dusre ko call kr rha hai to har baar mulitple parameters ban rhe hai or aagr recursion bahut badi hai to memory bhar jati hai jisse or call karne ki jagah nahi bachti hai .
     * ex : infinite recursion loops.
     * 
     * call stack for print Increasing : 
     * 
     * |printIncreasing n =1 | printIncreasing n =1 ko call kiya 
     * |printIncreasing n =2 | printIncreasing n =1 ko call kiya
     * |printIncreasing n =3 | printIncreasing n =2 ko call kiya
     * |printIncreasing n =4 | printIncreasing n =3 ko call kiya
     * |printIncreasing n =5 | pi ne pi(n-1) ko call kiya
     * |Main n = 5 | //main function ne pi ko call kiya with n = 5
     * 
     * note is call stack ko dhyan se analyze kre to printing jab shuru hogi jab call stack upar se niche ki taraf khatam hona shuru hoga upar jate hue to keval base case i.e n == 1 ki taraf jaa rhe hai .
     */

    public static void printDecreasing(int n){
        //Base case 
        if(n == 1){ // base case ki condition laga di
            System.out.println(1);
            return;
        }
        System.out.println(n + " "); // pehla number print kara liya
        printDecreasing(n-1); // decreasing order ko recursion mein dall diya
    }

    public static void printIncreasing(int n){
        if(n ==1){
            System.out.println(1);
            return;
        }
        printIncreasing(n-1);
        System.out.println(n + " ");

    }
    public static void main(String[] args){

        // Example 1 : Print numbers from n to 1 .
        System.out.println("Enter the number :");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter the number n : ");
        printIncreasing(n);
        printDecreasing(n);

    }  
}