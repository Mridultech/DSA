import java.util.*;
public class StringPalindrome {

    public static boolean isPalindrome(String str){ // time complexity: O(n) where n is the length of the string
        int n = str.length();
        if(n == 0 || n == 1){
            return true;
        }
        for(int i = 0 ; i < n/2 ; i++){
            if(str.charAt(i) != str.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println("Program to check if a string is palindrome or not");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = sc.nextLine();
        if(isPalindrome(str) == true){
            System.out.println("The string is a palindrome");
        }
        else{
            System.out.println("The string is not a palindrome");
    }
    
}
}
