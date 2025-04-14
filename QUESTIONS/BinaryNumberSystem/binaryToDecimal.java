import java.util.*;
public class binaryToDecimal {
    public static void main(String[] args){
        /*Decimal number system - (0-9)
        Binary number system(0,1)*/
        /*
         * Methodology for given problem 
         * 
         * let say given number in binary hai 101
         * to hame ise convert karna ho to ham 2 ki subsequent powers ki madad se karte hai 
         * to ham ek var. banayenge power or ek banayenge decimal
         * pow 2 ki power inc. karne ke liye or decimal final decimal result ke liye.
         * jo given binary hai usse last digit nikalenge or parallel 2 to the power se multiply krke final decimal mein add karte jayenge .
         * note: decimal and power ko ham 0 se initialize karenge
         * formula by observation is : decimal(final) = decimal(initial) + [(last digit of binary)*2^(power)]
         */
        
        //Driver Program

        binaryToDecimal();
    }

    public static void binaryToDecimal(){
        int power = 0;
        int decimal = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the given binary number you want to convert :");
        int binarybyuser = sc.nextInt();
        int mynum = binarybyuser;
        while(binarybyuser > 0){
            int last_digit = binarybyuser % 10;
            decimal = decimal + last_digit * (int) Math.pow(2, power);

            power++;
            binarybyuser /= 10; // Add this line to reduce the binary number
        }

        System.out.println("The decimal equivalent of " + mynum + " is: " + decimal);
    }
}
