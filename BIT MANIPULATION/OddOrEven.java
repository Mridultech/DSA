import java.util.Scanner;
public class OddOrEven{

    /*
     * mehtodology :
     * jo bhi number hoga uska last bit (lsb) 1 hoga to wo odd hoga 
     * jo bhi number hoga uska last bit (lsb) 0 hoga to wo even hoga
     */

    public static void oddOrEven(int number){
        int n = number;
        int bitmask = 1; // bit manipulation mein ham jis number ko given number ke sath operate karte hai use bitmask kehte hai 
        // ise bitmask isiliye bhi kehte hai kyunki ye main number ki sabhi bit ko mask kr rha hai 
        // The above line is the same as writing 00000001 in binary
        if((n & bitmask) == 1){ // (n & bitmask) isiliye kara to avoid wrong interpretation due to order of precedence
            System.out.println("The number is odd");
        }
        else{
            System.out.println("The number is even");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Program to analyse whether a number is odd or even using bitwise operators");
        System.out.println("Enter a number to check whether it is odd or even");
        int number = sc.nextInt();
        oddOrEven(number);
        sc.close();
    }
}