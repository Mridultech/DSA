import java.util.Scanner;
public class SumOfNNatural {

    /*
     * 
     * call stack analysis : let's say for n = 5
     * | sumOfN n = 0 | : returns 0
     * | sumOfN n = 1 | : 0 + 1 = 1
     * | sumOfN n = 2 | : 1 + 2 = 3
     * | sumOfN n = 3 | : 3 + 3 = 6
     * | sumOfN n = 4 | : 6 + 4 = 10 
     * | sumOfN n = 5 | : 10 + 5 = 15
     * | main n = 5 | : 15
     */

    public static int sumOfN(int number){
        if(number == 0){
            return 0;
        }
        int sumnm1 = sumOfN(number-1); 
        int sum = number + sumnm1;

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number till which you want to find the sum : ");
        int number = sc.nextInt();
        System.out.println("The sum of first " + number + " natural numbers is : " + sumOfN(number));
        sc.close();
    }
}