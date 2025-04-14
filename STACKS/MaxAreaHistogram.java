import java.util.*;

public class MaxAreaHistogram { // Time complexity: O(n)

    /*
     * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle that can be formed in the histogram.
     * 
     * Approach:
     * 1. Use two auxiliary arrays to store the next smaller left and next smaller right indices.
     * 2. Use these arrays to calculate the area for each bar.
     * 3. Area formula: (right[i] - left[i] - 1) * heights[i], where right[i] is the next smaller right index and left[i] is the next smaller left index.
     * 4. Find the maximum area among all bars.
     */

    public static void maxArea(int arr[]) {
        if (arr == null || arr.length == 0) { // Handle empty array
            System.out.println("Max area rectangle in histogram is: 0");
            return;
        }

        int maxArea = 0;
        int nextSmallerLeft[] = new int[arr.length];
        int nextSmallerRight[] = new int[arr.length];

        // Step 1: Calculate next smaller right indices (O(n))
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextSmallerRight[i] = arr.length;
            } else {
                nextSmallerRight[i] = s.peek();
            }
            s.push(i);
        }

        // Step 2: Calculate next smaller left indices (O(n))
        s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextSmallerLeft[i] = -1;
            } else {
                nextSmallerLeft[i] = s.peek();
            }
            s.push(i);
        }

        // Step 3: Calculate the maximum area (O(n))
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nextSmallerRight[i] - nextSmallerLeft[i] - 1;
            int currentArea = width * height;
            maxArea = Math.max(currentArea, maxArea);
        }

        System.out.println("Max area rectangle in histogram is: " + maxArea);
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 2, 3}; // Heights in histogram
        maxArea(arr);
    }
}