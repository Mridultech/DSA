package prime;
import java.util.*;
public class Primeoptimised {

    public static boolean isPrime(int n){
        // corner cases
        
        // for negative numbers :

        if (n<1){
            return false;
        }

        // for n == 2 :

        if (n==2){
            return true;
        }

        // for n > 2

        for(int i = 2;i < Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println("Enter the number for which you want to check whether number is prime or not :");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPrime(n));
    }
}
