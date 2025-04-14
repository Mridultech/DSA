import java.util.*;
public class MaxSubarraySum{
    
    //kaise kre : ek ek subarray ka sum nikalo or use max sum se compare karate rho jo end mein max sum mile use print karado

    public static void subarrays(int numbers[]){
        int currentsum = 0; 
        int maxSum = Integer.MIN_VALUE;
        System.out.println("Subarrays :");
        for(int i = 0 ; i < numbers.length ; i++){ // for start 
            for(int j = i ; j < numbers.length ; j++){ // for end 
                currentsum = 0;
                for(int k = i ; k <= j ; k++){
                    System.out.print(numbers[k] + " ");
                    currentsum += numbers[k];
                    }
                    System.out.println();
                    System.out.println("Value of sum of this subarray is : " + currentsum);
            
                    if(currentsum > maxSum){
                        maxSum = currentsum;
                    }
            }
            
            System.out.println();
            System.out.println();

        }
        System.out.println("Maximum sum out of all sub arrays are :" + maxSum);

    }
    
  

    public static void main(String[] args){
        System.out.println("Program to print subarrays from an array :");
        // Note : only print pairs with distinct elements ex (4,2) & (2,4) are same and hence to be printed once only 

        Scanner sc = new Scanner(System.in);
        // Logic to create array using user input :
        System.out.println("Enter the size of array :");
        int size = sc.nextInt();

        int numbers[] = new int[size];

        System.out.println("Enter the elements within the array :");
        for(int i = 0 ; i < numbers.length ; i++){
            numbers[i] = sc.nextInt();
        }

        subarrays(numbers);
    }
}
// time complexity for given problem is worst here which is : O(n^3) : By bruteforce approach
