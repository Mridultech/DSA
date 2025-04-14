/**
 * This Java program demonstrates how to add 1 to an integer using bitwise operations.
 * It specifically uses the `-~x` trick, which effectively adds 1 to `x`.
 */
public class AddOneToInteger {
    public static void main(String[] args) {
        /**
         * Case 1: When x = 6
         * Step 1: `~x` (Bitwise NOT of 6)
         *   - Binary of 6  =  00000110
         *   - Bitwise NOT   =  11111001  (This is -7 in Two’s Complement)
         * Step 2: `-~x` = -(-7) = 7 (which is x + 1)
         */
        int x = 6;
        System.out.println(x + " + " + 1 + " is " + -~x);

        /**
         * Case 2: When x = -4
         * Step 1: `~x` (Bitwise NOT of -4)
         *   - Binary of -4 in 8-bit Two’s Complement =  11111100
         *   - Bitwise NOT (~-4) = 00000011 (which is 3)
         * Step 2: `-~x` = -3
         *   - Since -4 + 1 = -3, our trick works!
         */
        x = -4;
        System.out.println(x + " + " + 1 + "is" + -~x);

        /*
         * Case 3: When x = 0
         * Step 1: `~x` (Bitwise NOT of 0)
         *   - Binary of 0 = 00000000
         *   - Bitwise NOT (~0) = 11111111 (which is -1)
         * Step 2: `-~x` = -(-1) = 1
         *   - Since 0 + 1 = 1, our trick works again!
         */
        x = 0;
        System.out.println(x + " + " + 1 + "is" + -~x);
    }
}
