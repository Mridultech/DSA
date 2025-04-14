import java.util.Scanner;

public class Anagrams{

    public static void arraySort(Character chararray){
        StringBuilder sb = new StringBuilder("");
        int l = chararray.length;
        for(int i = 0 ; i < l ; i++){
            if()
            }

    }
    public static void main(String[] args){
        System.out.println("Program to check if two strings are anagrams or not :");

        /*
         * methodology : 
         * 
         * what is anagrams :
         * An anagram of a string is another string that contains same characters, only the order of characters can be different.
         * example :
         * "listen" and "silent" are anagrams.
         * dono strings ke liye pehle ek string ka ek character lo or use puri dusri strin mein har char se compare karlo agar 
         * 
         * kaise banega ? 
         * 
         * 1. take two strings as input from user done 
         * 2. check if length of both strings are same or not done
         * 3. if not same then return false done
         * 4. if same then convert both strings to char array done
         * 5. sort both char arrays
         * 6. compare both char arrays
         * 7. if both are same then return true else return false
         */

        System.out.println("Program to count the number of lowercase vowels in a string");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string first :");
        String str = sc.nextLine();
        System.out.println("Enter the string second :");
        String str1 = sc.nextLine();

        if(str.length() != str1.length()){
            System.out.println("Both strings are not anagrams");
            return;
        }
        
        charArray(str);
        charArray(str1);

        Character chararray[] = new Character[26];

        for(int i = 0 ; i < str.length() ; i++){
            while(i < str.length() && str.charAt(i) != ' '){
                chararray[i] = str.charAt(i);
                i++;
            }
        }

        Character chararray1[] = new Character[26];

        for(int i = 0 ; i < str1.length() ; i++){
            while(i < str1.length() && str1.charAt(i) != ' '){
                chararray[i] = str1.charAt(i);
                i++;
            }
        }

        arraySort(chararray);
        arraySort(chararray1);

    }
}