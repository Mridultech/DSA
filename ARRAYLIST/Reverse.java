import java.util.ArrayList;
import java.util.Collections;
public class Reverse {
    public static void main(String[] args) {
        
        // Create an array list of integers
        ArrayList<Integer> numbers = new ArrayList<>();
        
        // Add some numbers to the list
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        
        // Print the original list
        System.out.println("Original list: " + numbers);
        
        // Reverse the list
        Collections.reverse(numbers);
        
        // Print the reversed list
        System.out.println("Reversed list: " + numbers);

        // 2nd method : we can simply print each value in list in reverse order loop.

        for(int i = numbers.size() - 1 ; i >= 0 ; i--){
            System.out.print(numbers.get(i) + " ");
        }
    }
}