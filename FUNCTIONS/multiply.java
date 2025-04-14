import java.util.*;
public class multiply{

    static int mul(int a,int b){
        return a*b;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the two numbers you want to multiply :");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int result = mul(a,b);
        System.out.print(result);
    }
}