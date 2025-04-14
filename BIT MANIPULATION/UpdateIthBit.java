import java.util.*;
public class UpdateIthBit {

    /*
     * methodology :
     * 1st approach :
     * 
     * ya to bas ek additional function bana denge update ith bit ke naam se jo agar newbit 1 hui to set karega
     * agar 0 hui to clear karega
     * 
     * 2nd approach : 
     * 
     * n mein ith bit ko clear kar denge sabse pehle
     * fir bitmask set krenge by left shifting newbit by ith
     * fir n aur bitmask ka or laga denge
     */

    public static int setIthBit(int number , int ithBit){
        int i = ithBit;
        int bitmask = 1 << i;
        return number | bitmask;
        }

    public static int clearIthBit(int number , int ithBit){
        int i = ithBit;
        int bitmask = ~(1 << i);
        return  (number & bitmask);
    }

    public static int updateIthBit(int number , int ithBit , int newBit){
        //first approach 

        // if(newBit == 0){
        //     return clearIthBit(number, ithBit);
        // }
        // else{
        //     return setIthBit(number, ithBit);
        // }
         
        //second approach
        int n = clearIthBit(number, ithBit);
        int bitmask = newBit << ithBit;
        return n | bitmask;
    }

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number : ");
            int number = sc.nextInt();
            System.out.println("Enter the ith bit : ");
            int ithbit = sc.nextInt();
            System.out.println("Enter the newbit you want to enter at place of ith bit : ");
            int newBit = sc.nextInt();
            System.out.println("Result is : " + updateIthBit(number, ithbit , newBit));
            sc.close();
    }
}
