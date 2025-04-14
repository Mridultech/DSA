public class GridwaysPermutations {

    // Method to calculate factorial of a number
    public static long factorial(int num) {
        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    // Method to calculate the number of ways using the formula
    public static long gridWays(int m, int n) {
        // Total moves = (m + n - 2)
        int totalMoves = m + n - 2;

        // Down moves = (m - 1), Right moves = (n - 1)
        int downMoves = m - 1;
        int rightMoves = n - 1;

        // Calculate the number of ways using the formula:
        // (m + n - 2)! / ((m - 1)! * (n - 1)!)
        return factorial(totalMoves) / (factorial(downMoves) * factorial(rightMoves));
    }

    public static void main(String[] args) {
        int m = 3; // Number of rows
        int n = 3; // Number of columns

        System.out.println("Number of ways to reach the bottom-right corner: " + gridWays(m, n));
    }
}