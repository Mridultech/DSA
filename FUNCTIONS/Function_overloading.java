import java.util.*;
public class Function_overloading {

    //Function overloading using parameters

    public static int sum(int a , int b){
        return a + b;
    }

    public static int sum(int a , int b, int c){
        return a + b + c;
    }

    public static int mul(int d , int e){
        return d*e;
    }

    public static float mul(float d , float e){
        return d*e;
    }

    public static void main(String[] args){
        System.out.println("Program for function overloading");
        Scanner sc = new Scanner(System.in);

        //Function overloading using parameters

        System.out.println("Demonstrating Fucntion overloading through parameters :");
        System.out.println("Enter the value of a , b and c :");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(sum(a,b));
        System.out.println(sum(a,b,c));

        //Function overloading for data types :

        System.out.println("Demonstrating Fucntion overloading through data types :");
        System.out.println(mul(2,3));
        System.out.println(mul(2f,3f));

        
        //note : Function overloading mein type of function ka koi role nahi hota wo keval type and number of parameters pe depend hota hai.


    }
} 