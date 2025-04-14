import java.util.*;
public class CountSetBits {
    
    /*
     * methodology : 
     * set bit : 1 
     * hame count karna hai ki ek binary number mein kitne 1 bits hai .
     * 
     * kaise karenge ?
     * 
     * agar hamare paas number hai let say n to use binary mein represent karne ke liye hame log base(2) to n + 1 bits lagengi at max.
     * 
     * simple process hai 
     * number ki lsb ko check krte rhenge 1 hoga to count bhada denge nahi to kuch nahi krenge 
     * har cycle ke baad number ko ek baar right shift kardenge jisse pichli bit aage aajaye check hone ke liye .
     * loop chalega logn times. 
     * 
     * lsb ko check karne ke liye ham number ko 1 se and karenge .
     */

     public static int countSetBits(int n){
        int count = 0;
        while(n > 0){
        if((n & 1) != 0){
            count++;
        }
        n = n >> 1;
    }
    return count;
     }

    public static void main(String[] args){
        System.out.println("Program to count number of set bits in a program ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number whose set bits you want to count :");
        int number = sc.nextInt();
        System.out.println("Number of set bits in number is : " + countSetBits(number));
        sc.close();
    }
}
