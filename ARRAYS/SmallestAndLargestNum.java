import java.util.*;
public class SmallestAndLargestNum {

    public static int smallest(int numbers[]){
        int smallest = Integer.MAX_VALUE;

        //logic to find smallest

        for(int i = 0 ; i < numbers.length ; i++){
            if(smallest > numbers[i]){
                smallest = numbers[i];
            }
        }
        return smallest;
    }

    public static int largest(int numbers[]){
        int largest = Integer.MIN_VALUE;

        // Logic to find largest 

        for(int i = 0 ; i < numbers.length ; i++){
            if(largest < numbers[i]){
                largest = numbers[i];
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        
        //Note : Integer.MAX_VALUE = -INFINITY
        //       Integer.MIN_VALUE = +INFINITY

        Scanner sc = new Scanner(System.in);

        //Initialization of array
        System.out.println("Enter the size of array :");
        int size = sc.nextInt();
        int numbers[] = new int[size];

        // logic for creation of array 
        System.out.println("Enter " + size + " elements wtihin array :");
        for(int i = 0 ; i < numbers.length ; i++){
            numbers[i] = sc.nextInt();
        }

        int sresult = smallest(numbers);
        int lresult = largest(numbers);

        System.out.println("Smallest value within given array is : " + sresult);
        System.out.println("Largest value within given array is : " + lresult);
    }
}
