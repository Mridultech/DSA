import java.util.Scanner;

public class ClearRangeOfBits{

    /*
     * methodology : 
     * agar ek range mein karna hai to aisa bit mask chiaiye jismein range ke coreesponding bits 0 ho or baki sab 1 ho
     * fir us mask ko number ke sath AND kar do
     * to result mil jayega jismein range ke bits 0 ho jayenge
     * 
     * bit mask kaise banega ab ?
     * let say number hai = 1111111011111111
     * range hai = 2(i) to 8(j)
     * to mask banega = 1111111000011111
     * to ye mask banane ke liye
     * hame 2 sub mask banake unki OR karna hoga to ye aayega
     * mask1 = 1111111111111111 (~0) : isme hame j+1 se aage wale bits 1 chahiye or usse pehle wale 0 i.e : 1111111000000000 to ham isse lef shift karenge by j+1 times
     * 
     * *concept : binary mein agar hame left side keval sare 0 chaiye or right mein kuch 1 chaiye to wo hame meilenge by 
     * 2^k - 1 where k is number of 1's
     * ex : 01 = (1)decimal = 2^1 - 1 = 1
     * 001 = (1)decimal = 2^2 - 1 = 3
     * 0001 = (1)decimal = 2^3 - 1 = 7
     * 
     * mask2 = 0000000000000111  to isme hame i se pehle wale bits 1 chaiye or uske baad wale 0 i.e : 1111111111111000 to ham isse right shift karenge by i-1 times
     * mask = mask1 OR mask2
     * 
     */

    public static int clearRangeOfBits(int number , int start , int end){
        int mask1 = (~0) << (end+1);
        int mask2 = (1 << start) - 1;
        int mask = mask1 | mask2;
        int result = number & mask;
        return result;}
    public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int number = sc.nextInt();
        System.out.println("Enter the range of bits you want to clear : ");
        System.out.println("Enter the starting of range : ");
        int start = sc.nextInt();
        System.out.println("Enter the end of range : ");
        int end = sc.nextInt();
        System.out.println("The number after clearing last bits from  "+ start + " to " + end + " is : " + clearRangeOfBits(number, start , end));
        sc.close();
    }
}