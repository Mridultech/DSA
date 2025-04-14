import java.util.*;
public class ClearLastIBits {

    /*
     * methodology : isme hame last se (from side of lsb se) i bits ko clear krne hain. 
     * toh hame ek mask bnana hoga jisme last i bits 0 honge aur baki sab 1 honge.
     * toh mask bnane ke liye hame ek number chahiye jisme last i bits 0 honge.
     * toh hame ek number chahiye jisme last i bits 1 honge.
     * ham use karenege -1 ka kyuki binary mein (-1) = 1111...1111
     * or ham -1 ko i times right shift karenge toh hamara mask ban jayega.
     * fir ham us mask ko original number se and karenge toh hamara answer aa jayega.
     * 
     * formula : n & mask , where mask = -1 << i
     */

    public static int clearLastIBits(int n, int i){
        int mask = -1 << i; // i be the number of bits to clear
        return n & mask; // n be the number to clear last i bits
    }
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int number = sc.nextInt();
        System.out.println("Enter the number of bits you want to clear : ");
        int i = sc.nextInt();
        System.out.println("The number after clearing last " + i + " bits is : " + clearLastIBits(number, i));
        sc.close();
    }
}