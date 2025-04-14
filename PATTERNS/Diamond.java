import java.util.*;

public class Diamond {

    public static void diamond(int rows) {
        // First phase of the diamond (upper part)
        for (int i = 1; i <= rows; i++) {
            // Spaces
            for (int j = 1; j <= (rows - i); j++) {
                System.out.print("  ");
            }
            // Stars
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Second phase of the diamond (lower part)
        for (int i = rows - 1; i >= 1; i--) {
            // Spaces
            for (int j = 1; j <= (rows - i); j++) {
                System.out.print("  ");
            }
            // Stars
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Program to print Diamond pattern:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows you want in the pattern:");
        int rows = sc.nextInt();
        diamond(rows);
    }
}