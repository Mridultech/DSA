import java.util.*;
public class Reverse_number {
    public static void main(String[] args) {
        System.out.println("Program for Reverse Number");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(num > 0){
            System.out.print(num % 10);
            num = num / 10;
        }
    }
}