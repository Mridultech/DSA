import java.util.*;
public class Switch {
    public static void main(String[] args) {
        System.out.println("Program for Switch Statement");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        switch(num){
            case 1 : System.out.println("One");
            break;
            case 2 : System.out.println("Two");
            break;
        }
    }
}