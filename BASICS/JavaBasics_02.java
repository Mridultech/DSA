import java.util.*;

public class JavaBasics_02 {
    private static final double TAX_RATE_10 = 0.1;

    private static final double TAX_RATE_20 = 0.2;

    private static final double TAX_RATE_30 = 0.3;

    private static final double TAX_RATE_40 = 0.4;


    public static void main(String[] args) {
        System.out.println("Program to make income tax calculator");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your income: ");
        
        if (!sc.hasNextFloat()) {
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }
        
        float income = sc.nextFloat();
        if (income < 0) {
            System.out.println("Income cannot be negative. Please enter a valid income.");
            return;
        }

        double incomeTax = calculateIncomeTax(income);

        System.out.printf("Your income tax is: %.2f%n", incomeTax);
    }

    private static double calculateIncomeTax(float income) {

        if (income > 100000 && income < 300000) {
            System.out.println("You need to pay 10% tax");
            return income * TAX_RATE_10;

        } else if (income > 300000 && income < 500000) {
            System.out.println("You need to pay 20% tax");
            return income * TAX_RATE_20;

        } else if (income > 500000 && income < 1000000) {
            System.out.println("You need to pay 30% tax");
            return income * TAX_RATE_30;

        } else if (income > 1000000) {
            System.out.println("You need to pay 40% tax");
            return income * TAX_RATE_40;

        } else {
            System.out.println("You don't need to pay any tax");
            return 0;
        }
    }
}
</create_file>
