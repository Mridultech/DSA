import java.util.Scanner;

public class LowercaseVowels{

    public static int lowercaseVowels(String str){
        StringBuilder sb = new StringBuilder(str);
        int n = str.length();
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u'ī){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println("Program to count the number of lowercase vowels in a string");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string :");
        String str = sc.nextLine();
        System.out.println("Number of lowercase vowels in given string is : " + lowercaseVowels(str)); 
        sc.close();
    }
}