import java.util.*;
public class SubArray{
    static int counter;
    
    public static void subarrays(int numbers[]){
        System.out.println("Subarrays :");
        for(int i = 0 ; i < numbers.length ; i++){ // for start 
            for(int j = i ; j < numbers.length ; j++){ // for end 
                for(int k = i ; k <= j ; k++){
                    System.out.print(numbers[k] + " ");
                    }
                    System.out.println();
            counter++;

            }
            
            
            System.out.println();
            System.out.println();

        }
    System.out.println("Total number of subarrays that can be formed is : " + counter); // pehle 4 subarrays bane fir 3 fir 2 fir 1 kyuki ham unique distinct subarrays ki search mein hai to ye pattern kuch sum of n natural numbers jaisa hai isiliye formula to find numbers of subarrays in a given array having n distinct elements are : [n(n+1)]/2

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
