import java.util.*;
public class ClearIthBit {

    /* 
     * methodology : just set ith bit ka ulta
     * yaha pe ulta matlab 1 ko 0 kar dena
     * jo hamara bit mask tha 1 << ith wo positively effect krta tha bit ko
     * ab hum usko ulta karenge to woh bit 0 ho jayega or baki sab 1 reh jayenge
     * ex : 1 << 3 = 00001000
     * agar hum isko ulta karenge to 11110111
     * or then hame aisa operation karna hai ki 0 ke sath ko bhi dusra number ho wo bhi 0 ho jaye
     * to ham bitmask aur number ka and karenge (&)
     * 
     * is question ke liye bitmask hai : ~(1 << ith)
     * 
     * formula : number & ~(1 << ith)
     * 
     */

    public static int clearIthBit(int number , int ithBit){
        int i = ithBit;
        int bitmask = ~(1 << i);
        return  (number & bitmask);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int number = sc.nextInt();
        System.out.println("Enter the bit you want to clear : ");
        int ithbit = sc.nextInt();
        System.out.println("Result is : " + clearIthBit(number, ithbit));
        sc.close();
    }
}
