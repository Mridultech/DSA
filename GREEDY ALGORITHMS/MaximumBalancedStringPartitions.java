public class MaximumBalancedStringPartitions{

    /*
     * Problem statement : We have a balanced string of size n with equal number of 'L' and 'R' characters. We can partition the string into k substrings such that each substring is also balanced. Find the maximum value of k.
     * Input : A balanced string is string with equal number of 'L' and 'R' characters.
     * 
     * ex : str = "LRLRLR" => k = 3
     * ex : str = "LRRLLR" => k = 2
     * ex : str = "LRRLL" => k = 1
     * 
     * approach : 
     * 1. Initialize a counter to 0.
     * 2. Iterate through the string and for each character, increment the counter if it is 'L' and decrement it if it is 'R'.
     * 3. If the counter is 0, increment the number of partitions.
     * 4. Return the number of partitions.
     */

     public static int maximumBalancedStringPartitions(String s){
        int count = 0; // counter to keep track of the number of partitions
        int partitions = 0; // variable to store the number of partitions

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                count++; // increment the counter if the character is 'L'
            } else {
                count--; // decrement the counter if the character is 'R'
            }

            if (count == 0) { // if the counter is 0, we have found a balanced substring
                partitions++; // increment the number of partitions
            }
        }

        return partitions; // return the number of partitions
     }
    public static void main(String[] args){
        String str = "LRRRRLLRLLRL";
        System.out.println("Maximum number of balanced string partitions: " + maximumBalancedStringPartitions(str));
    }
}