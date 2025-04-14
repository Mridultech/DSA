import java.util.*;

public class UnionAndIntersectionOf2Arrays {

    /*
     * Problem Statement:
     * Write a program to find the union and intersection of two arrays.
     *
     * 👉 Union: The union of two arrays is the set of elements that are in either array (without duplicates).
     * 👉 Intersection: The intersection of two arrays is the set of elements that are in both arrays.
     */

    public static void main(String[] args) {

        // ✅ Input arrays
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 6, 7, 8};

        // ==========================
        // ✅ Finding Union of arr1 & arr2
        // ==========================

        // Using HashSet to avoid duplicates automatically
        HashSet<Integer> unionSet = new HashSet<>();

        // Add all elements of arr1 to the set
        for (int num : arr1) {
            unionSet.add(num);
        }

        // Add all elements of arr2 to the same set
        for (int num : arr2) {
            unionSet.add(num);
        }

        // Print the union set and its count
        System.out.println("Union : " + unionSet);
        System.out.println("Union Count : " + unionSet.size());

        // ================================
        // ✅ Finding Intersection of arr1 & arr2
        // ================================

        // Store all elements of arr1 in a HashSet
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : arr1) {
            set1.add(num);
        }

        // Create a new set to store intersection elements
        HashSet<Integer> intersectionSet = new HashSet<>();

        // Check for each element in arr2, if it exists in set1
        for (int num : arr2) {
            if (set1.contains(num)) {
                intersectionSet.add(num); // common element
            }
        }

        // Print the intersection set and its count
        System.out.println("Intersection : " + intersectionSet);
        System.out.println("Intersection Count : " + intersectionSet.size());
    }
}
