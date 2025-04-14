import java.util.ArrayList;
import java.util.Collections;
public class SortingArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(4);

        Collections.sort(numbers); // for ascending order
        System.out.println(numbers); // print the sorted list
        Collections.sort(numbers, Collections.reverseOrder()); // for descending order
        System.out.println(numbers); // print the sorted list
    }
}
