import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
public class InbuiltSort { // for sorting in a single line we can use inbuilt sort function

    public static void main(String[] args) {
        System.out.println("Program for Inbuilt sort to sort an array :");
        Scanner sc = new  Scanner(System.in);

        // Logic to create array using user input :
        System.out.println("Enter the size of array :");
        int size = sc.nextInt();/*primitive data types ke liye kaam nahi krega objects ke liye kaam krega */
        Integer numbers[] = new Integer[size];

        System.out.println("Enter the elements within the array:");
        for(int i = 0 ; i < numbers.length ; i++){
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers); // Inbuilt sort function to sort the array
        //Arrays.sort(numbers,1/*starting index */,4/*ending index */); // Inbuilt sort function to sort the array
        System.out.println("The sorted array is :");
        for(int i = 0 ; i < numbers.length ; i++){
            System.out.print(numbers[i] + " ");


        // descending order mein sort karna hai toh
        //collections.reverseOrder() use karna padega
        // Arrays.sort(numbers,Collections.reverseOrder());

        Arrays.sort(numbers,Collections.reverseOrder());
        System.out.println("The sorted array in descending order is :");
        for(i = 0 ; i < numbers.length ; i++){
            System.out.print(numbers[i] + " ");
        }
    }
    }
}
