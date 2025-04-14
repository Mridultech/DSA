import java.util.*;
public class Swap{

    public static void swapnum(int a , int b){ /*yaha pe call by value ki wajah se function ne args ki copy banai thi to original args mein change hone ki bajai copy mein change hota hai isiliye func. mein values swap ho gayi lekin original mein nahi !!! */
        int temp = a;
        a = b;
        b = temp;
        System.out.println("here in function only a is : " + a);
        System.out.println("here in function only b is : " + b);

        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of a :");
        int a = sc.nextInt();
        System.out.println("Enter the value of b :");
        int b = sc.nextInt();

        //Program to swap two numbers using third variable temp 

        swapnum(a,b);
        System.out.println("a is : " + a);
        System.out.println("b is : " + b);
    }
}