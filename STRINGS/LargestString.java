public class LargestString {
    public static void main(String[] args){
        System.out.println("Program to find largest string in an array of strings through lexico-graphical comparison"); 
        /*
         * methodology : 
         * lexico-graphical comparison is done by comparing the strings character by character
         * if the characters are same, then the next character is compared
         * if the characters are different, then the string with the larger character is considered as the larger string
         * if the characters are same till the end of the string, then the string with the larger length is considered as the larger string
         * 
         * example :
         * string1 = "abc"
         * string2 = "abcd"
         * 
         * string2 is larger than string1 because the characters are same till the end of string1, but string2 has an extra character
         * 
         * java mein ham lexicographic comparison ke liye compareTo() method ka use kar sakte hain
         * or agar hame comparison case sensitive nahi karna hai toh compareToIgnoreCase() method ka use kar sakte hain
         * 
         * compareTo() method ka return type integer hota hai
         * agar string1 > string2, toh return value positive hoti hai
         * agar string1 < string2, toh return value negative hoti hai
         * agar string1 == string2, toh return value 0 hoti hai
         */

        String[] fruits = {"apple", "banana", "mango", "orange", "kiwi", "grapes", "watermelon", "papaya", "guava", "pineapple"};
        String largestString = fruits[0];
        for(int i=1; i<fruits.length; i++){ //time complexity of this loop is O(x * n) where x is the number of comparisons per length of the largest string and n is the number of strings in the array being compared.
            if(fruits[i].compareTo(largestString) > 0){
                largestString = fruits[i];
            }
        }  
        System.out.println("Largest string in the array is : " + largestString);

    }
}
