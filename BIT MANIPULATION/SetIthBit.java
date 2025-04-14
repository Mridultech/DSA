import java.util.*;

public class SetIthBit {

    /* 
     * methodology : 
     * set ith bit matlab jo given number hai uska ith bit 1 karna hai.
     * iske liye hame koi aisa operation karna pdega ki kuch bhi samne ho 0 ya 1 aaye hamesha 1 hi us position pe or bitmask mein baki sari values 0 karne ke liye bitmask hoga 1 << i
     * operation hoga : number | bitmask
     * 
     * formula : number | (1 << ith bit)
     */

     public static int setIthBit(int number , int ithBit){
        int i = ithBit;
        int bitmask = 1 << i;
        return number | bitmask;
        }
    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int number = sc.nextInt();
        System.out.println("Enter the bit you want to set : ");
        int ithbit = sc.nextInt();
        System.out.println("Result is : " + setIthBit(number, ithbit));
        sc.close();

    }
}
