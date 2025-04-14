import java.util.*;
public class GenerateBinaryNumbers {

    /*
     * problem statement : Given a number n, generate all binary numbers from 1 to n.
     * 
     * Example:
     * Input : 5
     * Output : 1 10 11 100 101
     * 
     * Approach:
     * 1. Number is given in decimal format.
     * 2. We need to convert the decimal number to binary.
     * 3. We can use stack to convert decimal to binary.
     * 4. We can use the following steps to convert decimal to binary:
     *   a. Divide the number by 2 and push the remainder to stack.
     *  b. Repeat the process until the number becomes 0.
     *  c. Pop the elements from stack and print them.
     * 5. Repeat the process for all numbers from 1 to n.
     * 6. Time complexity: O(n * log n) where n is the number of elements and log n is the time taken to convert decimal to binary.
     * 7. Space complexity: O(log n) where n is the number of elements and log n is the space taken by stack.
     * 8. We can also use the built-in function Integer.toBinaryString() to convert decimal to binary.
     * 9. But we will use stack to convert decimal to binary.
     * 
     */

     public static void decimalToBinary(int n){
        Stack<Integer> s = new Stack<>();
        while(n > 0){
            int remainder = n % 2;
            s.push(remainder);
            n = n/2;
        }
        
        while(!s.isEmpty()){
            System.out.print(s.pop());
        }
        System.out.println();
     }

     public static void generateBinary(int n){
        for(int i = 1 ; i <= n ; i++){
            decimalToBinary(i);
        }

     }
    public static void main(String[] args){

        int num = 5 ; 
        generateBinary(num);

    }
}
