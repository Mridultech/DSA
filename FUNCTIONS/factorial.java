import java.util.*;
public class factorial {

    static int fact(int number){
        int factorial = 1;

        for(int i = 1;i <= number;i++){
            factorial = factorial*i;
        }
        return factorial;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number whose factorial you want to find :");
        int number = sc.nextInt();
        System.out.println(fact(number));
    }
}
