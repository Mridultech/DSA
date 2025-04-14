import java.util.*;
public class IsPowerOf2 {
    /*
     * methodology : 
     * 
     * agar koi number let say n 2 ki power hai to hamesha n and n-1 ka AND 0 hoga.
     * i.e n & (n-1) = 0 for all n which are power of 2.
     * aisa kyu hota hai ? 
     * kyuki jo bhi number 2 ki power wala hoga usme msb hamesha 1 hoga aur baki sab 0 honge.
     * or usse ek chota number me msb 0 hoga aur baki sab 1 honge.
     * isiliye end karne pe 000..000 aayega.
     * 
     */

    public static boolean isPowerOf2(int number){
        return (number & (number-1)) == 0;
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number you want to check if it is power of 2 or not");
        int number = sc.nextInt();

        if(isPowerOf2(number) == true){

            System.out.println("Number is power of 2");

        }
        else{

            System.out.println("Number is not power of 2");

        }
        sc.close();
    }
}
