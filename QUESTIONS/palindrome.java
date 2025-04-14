import java.util.*;
public class palindrome {

    // Method to check if a number is a palindrome
    public static boolean isPalindrome(int num) {
        // Negative numbers cannot be palindromes
        if (num < 0) {
            return false;
        }

        int originalNum = num; // Store the original number
        int reversedNum = 0;

        // Reverse the number
        while (num > 0) {
            int lastDigit = num % 10; // Extract the last digit
            reversedNum = reversedNum * 10 + lastDigit; // Build the reversed number
            num /= 10; // Remove the last digit
        }

        // Check if the reversed number is equal to the original number
        return originalNum == reversedNum;
    }

    public static void main(String[] args) {
        System.out.println("Program to check whether the given number is a palindrome or not:");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number you want to check:");
        if (!sc.hasNextInt()) { // Input validation
            System.out.println("Invalid input! Please enter an integer.");
            return;
        }

        int num = sc.nextInt();

        // Call the palindrome checker method
        if (isPalindrome(num)) {
            System.out.println(num + " is a palindrome.");
        } else {
            System.out.println(num + " is not a palindrome.");
        }
    }
}