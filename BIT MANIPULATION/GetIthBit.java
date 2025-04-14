import java.util.*;
public class GetIthBit {
    
    /*
     * mehtodology : 
     * 1 manlo koi bhi number hai 5 = 00000000101
     * 2 ab hume is number ka 3rd bit nikalna hai ( hamesha lsb se count hoga) i.e 1 or hamesha count aise hoga like 0 1 2 3 4 ... so on.
     * 3 jaise hamne odd even wale mein kra waise hi jo bhi bit nikalna hai usko chodke baki sab 0 ho jaye kuch aisa karenge
     * 4 agar ham 1 << i where i is the index of bit we want to find kare to hame ek aisa number milega jisme keval us bit ki position pe 1 hoga or baki sab 0
     * ex : 1 << 3 = 00001000
     * 5 agar ham apne orignal number ko ise end karde to jo bit hume chahiye tha wahi bachega 
     * case 1 : agar woh bit 0 tha to hame 0 number mil jayega
     * case 2 : agar woh bit 1 tha to hame non zero number mil jayega
     * 
     * formula kya banega : 1 << ith bit & given number , yaha pe bitmask hai 1 << ith bit
     */

    public static int getIthBit(int number , int ithBit){
        int i = ithBit;
        int bitmask = 1 << i;
        if((number & bitmask) == 0){
            System.out.println("0");
            return 0;
        }
        else{
            System.out.println("1");
            return 1;
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int number = sc.nextInt();
        System.out.println("Enter the bit you want to find : ");
        int ithbit = sc.nextInt();
        getIthBit(number, ithbit);

    }
}
