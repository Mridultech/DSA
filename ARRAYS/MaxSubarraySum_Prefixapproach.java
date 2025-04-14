import java.util.*;
public class MaxSubarraySum_Prefixapproach{
    
    //kaise kre : ek array banayenge prefix array or uski help se current sum nikalenge by formula prefix[end] - prefix[start-1] or use max sum se compare krayenge end tak fir end mein max sum print kara denge
    // prefix array wo array hai jisme particular index pe us index tak jitne bhi elements hai sabka sum usme present hota hai for given array : ex given array : 1 2 3 4 5 prefix array : 1 3 6 10 15 ek tarike se fibonacci wala logic hi hai
    
    public static void subarrays(int numbers[]){
        int prefix[] = new int[numbers.length];
        int currentsum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        //logic to fill prefix array
        prefix[0] = numbers[0];
        for(int i = 1 ; i < prefix.length ; i++){
            prefix[i] = prefix[i-1] + numbers[i];
        }

        System.out.println("Subarrays :");
        for(int i = 0 ; i < numbers.length ; i++){ // for start 
            for(int j = i ; j < numbers.length ; j++){ // for end 
                currentsum = i==0 ? prefix[j] : prefix[j] - prefix[i-1]; // here i = start and j = end as per terminology
                
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
// time complexity for given problem is better than bruteforce approach here by prefix subarray approach which is : O(n^2) : By bruteforce approach
