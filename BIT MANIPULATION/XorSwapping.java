public class XorSwapping {
    public static void main(String[] args) {
        int x = 3, y = 4;

        System.out.println("Before swap: x = " + x + " and y = " + y);

        // Swapping using XOR
        x = x ^ y;  // Step 1: x = x ^ y
        y = x ^ y;  // Step 2: y = x ^ y (which becomes original x)
        x = x ^ y;  // Step 3: x = x ^ y (which becomes original y)

        System.out.println("After swap: x = " + x + " and y = " + y);
    }
}
