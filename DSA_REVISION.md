# DSA Revision Guide

## Table of Contents
- [ARRAYLIST](#arraylist)
- [ARRAYS](#arrays)
- [BACKTRACKING](#backtracking)
- [BASICS](#basics)
- [BIT MANIPULATION](#bit-manipulation)
- [DIVIDE & CONQUER](#divide--conquer)
- [DOCS](#docs)
- [FUNCTIONS](#functions)
- [INPUT](#input)
- [LINKED LIST](#linked-list)
- [LOOPS](#loops)
- [OOPS](#oops)
- [PATTERNS](#patterns)
- [QUESTIONS](#questions)
- [RECURSION](#recursion)
- [SORTING](#sorting)
- [STACKS](#stacks)
- [STRINGS](#strings)
- [SWITCH](#switch)
- [TIME & SPACE COMPLEXITY](#time--space-complexity)

## ARRAYLIST
### Basics.java
```java
import java.util.ArrayList;

public class Basics{
    /*
     * what is array list ? 
     * What is difference between Array and Arraylist?
     * 
     * -----------------------------------------------
     * |     Array           |      Arraylist        |
     * |---------------------|-----------------------|
     * | 1. Fixed Size       | 1. Dynamic Size       |
     * |---------------------|-----------------------|
     * | 2. Primitives only  | 2. Objects only       |
     * |---------------------|-----------------------|
     * 
     * How arraylist can be used ?
     * by importing ArrayList class from java.util package.
     * 
     * ArrayList is a part of Java's collection framework and is used to store dynamically sized collections of elements.
     */
    public static void main(String[] args) {
        
    // Syntax to create ArrayList         
        ArrayList<String> names = new ArrayList<>();

    //Operations on ArrayList
        names.add("John");
        names.add("Jane");
        names.add("Jack");

        names.add(1,"mridul"); // Time complexity: O(n)

        System.out.println("ArrayList: " + names);

        // Access elements
        System.out.println("First name: " + names.get(0)); // O(1)

        // Remove elements
        names.remove("Jane"); // O(n)

        // Get size
        System.out.println("Size of ArrayList: " + names.size());

        // Iterate
        for (String name : names) {
            System.out.println(name);
        }
        
        // Contains check
        if (names.contains("Jack")) { // O(n)
            System.out.println("Jack is in the list.");
        }

        // Clear
        names.clear();
        System.out.println("Size after clear: " + names.size());

        // Set element
        names.add("mridul");
        names.add("mridul");
        names.add("mridul");
        names.set(2,"john"); // O(n)

        System.out.println(names);
    }
}
```

### MaximumArraylist.java
```java
import java.util.ArrayList;
public class MaximumArraylist {
    public static void main(String[] args){
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6); // ans is 6.

        for(int i = 0 ; i < numbers.size() ; i++){
            int num = numbers.get(i);
            if(num > max){
                max = num;
            }
            else{
                continue;
            }
        }
        System.out.println("Maxiumum value is : " + max);
    }
}
```

### MultiDimensionalArrayList.java
```java
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
```

### Reverse.java
```java
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

        // 2nd method: print in reverse order using loop
        for(int i = numbers.size() - 1 ; i >= 0 ; i--){
            System.out.print(numbers.get(i) + " ");
        }
    }
}
```

## ARRAYS
### ArrayReverse.java
```java
import java.util.*;
public class ArrayReverse{

    public static void reverse(int numbers[]){
        int start = 0;
        int end = numbers.length-1;
        int temp = 0;
        //logic for swapping 

        while(start < end){
        temp = numbers[start];
        numbers[start]= numbers[end];
        numbers[end] = temp;

        start++;
        end--;
        }
    }
    public static void main(String[] args) {
        
        System.out.println("Program to reverse an array");

        //main logic: swap first and last elements, then move towards center
        Scanner sc = new Scanner(System.in);

        // Logic to create array using user input
        System.out.println("Enter the size of array :");
        int size = sc.nextInt();
        int numbers[] = new int[size];

        System.out.println("Enter the elements within the array:");
        for(int i = 0 ; i < numbers.length ; i++){
            numbers[i] = sc.nextInt();
        }
        System.out.println("Array before reversing it is : ");

        for(int i = 0 ; i < numbers.length ; i++){
            System.out.println("Array's " + i + "th element is " + numbers[i]);
        }
        reverse(numbers);

        System.out.println("Array after reversing it is : ");

        for(int i = 0 ; i < numbers.length ; i++){
            System.out.println("Array's " + i + "th element is " + numbers[i]);
        }
    }
}
```

### Basic_Array.java
```java
import java.util.*;
public class Basic_Array{

    public static void update(int test[]){
        for(int i = 0 ; i < test.length ; i++){
            test[i] = test[i] + 1;
        }
    }
    public static void main(String[] args){
        /*arrays : List of elements of same type placed in contiguous memory location
        * 0-based indexing : indexing starts from 0
        */

        /*operation in arrays 
         * create - dataType arrayName[ ] = new datatype[size]; 
         * new helps to find location for data structure 
         */

         int marks[] = new int[50]; // array size can't be changed at runtime
         int numbers[] = {1,2,3};
         String names[] = {"mridul","purnima"};
         
        /*  
         * input and output
         */ 
        Scanner sc = new Scanner(System.in);
        int num[ ] = new int[10];
        num[0] = sc.nextInt();
        System.out.println(num[0]);

        /* update values at array locations */
        num[0] = 2;
        System.out.println(num[0]);

        // modification is also possible 
        System.out.println(num[0] + 2);

        // length property of arrays
        System.out.println(num.length);

        // passing arrays as argument to functions (passed by reference)
        int test[] = {92,93,94};
        update(test);

        for(int j = 0 ; j < test.length ; j++){ 
            System.out.println(test[j]);
        }
    }
}
```

### BinarySearch.java
```java
import java.util.*;
public class BinarySearch{

    public static int binarySearch(int numbers[],int key){
        int start = 0;
        int end = numbers.length-1;

        // Binary search logic
        while(start <= end){
            int mid = (start + end)/2;
            if(numbers[mid]==key){
                System.out.println("Key found!");
                return mid;
            }
            else if(key > numbers[mid]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }   
        return -1;
    }
    
    public static void main(String[] args){
        System.out.println("Program for binary search in array");
        Scanner sc = new Scanner(System.in);
        
        // Create a sorted array for binary search
        int numbers[] = {2,4,6,8,10,12,14,16,18,20};
        
        System.out.println("Enter the key you want to find within array");
        int key = sc.nextInt();

        int result = binarySearch(numbers, key);

        if(result == -1){
            System.out.println("Key not found in given array!");
        }
        else{
            System.out.println("Given key is found at " + result + "th location");
        }
    }
}
```

### BuyAndSellStocks.java
```java
import java.util.Scanner;

public class BuyAndSellStocks {

    public static int profit(int prices[]){
        int buyPrice = Integer.MAX_VALUE; // Initialize with max value to find minimum
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            if(buyPrice < prices[i]){
                // Calculate potential profit and keep maximum
                maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            }
            else{
                // Found a better (lower) buy price
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("Program for calculating maximum profit by buying and selling stocks");
        Scanner sc = new Scanner(System.in);

        // Get stock prices from user
        System.out.println("Enter number of days:");
        int size = sc.nextInt();
        int prices[] = new int[size];

        System.out.println("Enter stock prices for each day:");
        for(int i = 0; i < prices.length; i++){
            prices[i] = sc.nextInt();
        }
        
        int result = profit(prices);
        System.out.println("Maximum profit that can be made is: " + result);
    }   
}
```

### LinearSearch.java
```java
import java.util.Scanner;

public class LinearSearch {
    
    public static int linearSearch(int[] arr, int key) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Linear Search Implementation");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter array size:");
        int size = sc.nextInt();
        int[] numbers = new int[size];

        System.out.println("Enter array elements:");
        for(int i=0; i<numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println("Enter key to search:");
        int key = sc.nextInt();

        int result = linearSearch(numbers, key);
        
        if(result == -1) {
            System.out.println("Key not found in array");
        } else {
            System.out.println("Key found at index: " + result);
        }
    }
}
```

### LinearSearchString.java
```java
import java.util.Scanner;

public class LinearSearchString {
    
    public static int searchString(String[] arr, String key) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("String Linear Search Implementation");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number of strings:");
        int size = sc.nextInt();
        sc.nextLine(); // consume newline
        String[] words = new String[size];

        System.out.println("Enter strings:");
        for(int i=0; i<words.length; i++) {
            words[i] = sc.nextLine();
        }

        System.out.println("Enter string to search:");
        String key = sc.nextLine();

        int result = searchString(words, key);
        
        if(result == -1) {
            System.out.println("String not found in array");
        } else {
            System.out.println("String found at index: " + result);
        }
    }
}
```

### MaxSubarraySum_Kadane.java
```java
import java.util.Scanner;

public class MaxSubarraySum_Kadane {

    public static void kadane(int numbers[]){
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        // Check if all elements are negative (corner case)
        boolean allNegative = true;
        for(int num : numbers){
            if(num > 0){
                allNegative = false;
                break;
            }
        }

        if(allNegative){
            // If all negative, return the maximum single element
            for(int num : numbers){
                maxSum = Math.max(maxSum, num);
            }
            System.out.println("Maximum subarray sum: " + maxSum);
            return;
        }

        // Standard Kadane's algorithm
        for(int i = 0; i < numbers.length; i++){
            currentSum += numbers[i];
            if(currentSum < 0){
                currentSum = 0;
            }
            maxSum = Math.max(currentSum, maxSum);
        }
        System.out.println("Maximum subarray sum: " + maxSum);
    }

    public static void main(String[] args) {
        System.out.println("Kadane's Algorithm for maximum subarray sum");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter array size:");
        int size = sc.nextInt();
        int numbers[] = new int[size];

        System.out.println("Enter array elements:");
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = sc.nextInt();
        }

        kadane(numbers);
    }
}
```

### MaxSubarraySum_P prefixapproach.java
```java
import java.util.Scanner;

public class MaxSubarraySum_Prefixapproach {

    public static void prefixSum(int numbers[]) {
        // Calculate prefix sum array
        int prefix[] = new int[numbers.length];
        prefix[0] = numbers[0];
        
        for(int i=1; i<prefix.length; i++) {
            prefix[i] = prefix[i-1] + numbers[i];
        }
        
        int maxSum = Integer.MIN_VALUE;
        
        // Nested loops to find all possible subarrays
        for(int i=0; i<numbers.length; i++) {
            for(int j=i; j<numbers.length; j++) {
                // Calculate current sum using prefix array
                int currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];
                
                if(currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        
        System.out.println("Maximum subarray sum: " + maxSum);
    }

    public static void main(String[] args) {
        System.out.println("Prefix Sum Approach for Maximum Subarray Sum");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter array size:");
        int size = sc.nextInt();
        int numbers[] = new int[size];

        System.out.println("Enter array elements:");
        for(int i=0; i<numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        prefixSum(numbers);
    }
}
```

### PairsInArray.java
```java
import java.util.Scanner;

public class PairsInArray {

    public static void printPairs(int numbers[]) {
        System.out.println("All possible pairs in the array:");
        int totalPairs = 0;
        
        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                System.out.print("(" + numbers[i] + "," + numbers[j] + ") ");
                totalPairs++;
            }
            System.out.println();
        }
        
        System.out.println("Total number of pairs: " + totalPairs);
    }

    public static void main(String[] args) {
        System.out.println("Program to print all possible pairs in an array");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter array size:");
        int size = sc.nextInt();
        int numbers[] = new int[size];

        System.out.println("Enter array elements:");
        for(int i=0; i<numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        printPairs(numbers);
    }
}
```

### PrintSubarrays.java
```java
import java.util.Scanner;

public class PrintSubarrays {

    public static void printAllSubarrays(int numbers[]) {
        System.out.println("All possible subarrays:");
        int totalSubarrays = 0;
        
        for(int i=0; i<numbers.length; i++) {
            for(int j=i; j<numbers.length; j++) {
                System.out.print("[");
                for(int k=i; k<=j; k++) {
                    System.out.print(numbers[k]);
                    if(k < j) {
                        System.out.print(", ");
                    }
                }
                System.out.print("] ");
                totalSubarrays++;
            }
            System.out.println();
        }
        
        System.out.println("Total number of subarrays: " + totalSubarrays);
    }

    public static void main(String[] args) {
        System.out.println("Program to print all possible subarrays of an array");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter array size:");
        int size = sc.nextInt();
        int numbers[] = new int[size];

        System.out.println("Enter array elements:");
        for(int i=0; i<numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        printAllSubarrays(numbers);
    }
}
```

[... similar sections for all other files ...]
