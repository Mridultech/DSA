import java.util.*;
public class Loops {
    public static void main(String[] args) {
        System.out.println("Loops!!!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        while(num > 0){
            System.out.println(num);
            num--;
        }
    }
}