import java.util.ArrayList;
/**
 * This program demonstrates how to create and initialize a 2D ArrayList in Java.
 * It creates a 2D ArrayList with 3 rows and 4 columns, filling it with some values.
 */
public class MultiDimensionalArrayList {
    public static void main(String[] args){
        // Create a 2D ArrayList
        ArrayList<ArrayList<Integer>> arrayList2D = new ArrayList<>();

        // Initialize the 2D ArrayList with 3 rows and 4 columns
        for (int i = 0; i < 3; i++) {
            arrayList2D.add(new ArrayList<>());
            for (int j = 0; j < 4; j++) {
                arrayList2D.get(i).add(i * j); // Fill with some values
            }
        }

        // Print the 2D ArrayList
        for (ArrayList<Integer> row : arrayList2D) {
            System.out.println(row);
        }
    }
}
