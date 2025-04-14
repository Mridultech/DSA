import java.util.*;
public class Binomial_Coefficient {
    static int fact(int number){
        int factorial = 1;

        for(int i = 1;i <= number;i++){
            factorial = factorial*i;
        }
        return factorial;
    }

    static int binomial_coefficient(int factn , int factr, int factnmr){
        int bincoeff = factn/(factr*factnmr);
        return bincoeff;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Program for binomial coefficient 
        System.out.print("Enter the value of n to calculate binomial coefficient :");
        int n = sc.nextInt();
        System.out.print("Enter the value of r to calculate binomial coefficient :");
        int r = sc.nextInt();
        int factn = fact(n);
        int factr = fact(r);
        int factnmr = fact(n-r);
        System.out.print(binomial_coefficient(factn,factr,factnmr));
    }
    
}
