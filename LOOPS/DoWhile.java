public class DoWhile {
    public static void main(String args[]) {
        System.out.print("Program for do-while");
        int counter = 10; // Declare counter outside the do block
        do { 
            System.out.println("Hello"); // Correct print statement
            counter = counter-1; // Decrement counter
        } while (counter >= 11); // Change condition to ensure loop executes
    }
}
