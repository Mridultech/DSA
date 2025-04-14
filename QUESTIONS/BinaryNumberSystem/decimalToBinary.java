import java.util.*;
public class decimalToBinary {

    public static void decimalToBinary(){
    int binarynum = 0;
    int power = 0;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the decimal whose binary equivalent you want : ");
    int decimal = sc.nextInt();
    int mynum = decimal;
    // Logic for main working of program

    while(decimal > 0){
        int remainder = decimal%2;
        binarynum = binarynum + remainder*(int)Math.pow(10,power);

        power++;
        decimal = decimal/2;
    }
    System.out.print("Binary equivalent of given decimal "+ mynum +" is : " + binarynum);
    }
    public static void main(String[] args){
        decimalToBinary();
    }
    
}
