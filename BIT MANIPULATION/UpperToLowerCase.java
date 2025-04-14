/**
 * This Java program converts uppercase English alphabets (A-Z) into lowercase (a-z)
 * using the bitwise OR ('|') operator. The technique works by setting the 6th bit of 
 * the character using the ASCII properties.
 * 
 * Explanation:
 * ------------
 * In ASCII:
 * - 'A' to 'Z' have values from 65 to 90.
 * - 'a' to 'z' have values from 97 to 122.
 * 
 * The only difference between uppercase and lowercase letters is the 6th bit.
 * - Uppercase 'A' (ASCII 65) → Binary:  01000001
 * - Space ' '   (ASCII 32) → Binary:  00100000
 * - Performing bitwise OR (|) sets the 6th bit:
 *   (01000001) | (00100000) = (01100001) → 'a' (ASCII 97)
 * 
 * This logic is applied to all uppercase letters to convert them into lowercase.
 */

 public class UpperToLowerCase {
    public static void main(String[] args) {
        // Loop through all uppercase letters from 'A' to 'Z'
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            // Convert uppercase to lowercase using bitwise OR ('|') with space (' ')
            char lowercaseChar = (char)(ch | ' ');

            // Print the converted lowercase character
            System.out.println(lowercaseChar);
        }
    }
}

/**
 * Expected Output:
 * -----------------
 * a
 * b
 * c
 * d
 * e
 * ...
 * z
 *
 * Alternative Methods:
 * --------------------
 * 1. Using ASCII offset:  (char)(ch + 32)
 * 2. Using Java function: Character.toLowerCase(ch)
 *
 * However, using bitwise OR ('|') is the fastest method for this conversion.
 */
