import java.util.Scanner; // super important algorithm 

// kya ho rha hai : array ke sub arrays ka sum karte chalo or agar negative aaye to current sum ko 0 krdo aur aakhir mein max sum ko print kardo 
// note : ek corner case hai jisme ki agar array ke sare element negative ho to uske liye special cases banane padte hai as shown below

public class MaxSubarraySum_Kadane {

    public static void kadane(int numbers[]){
        int currentsum = 0;
        int maxsum = Integer.MIN_VALUE;

        //corner case : if all the elements within array is negative

        boolean allNegative = true;
        for(int num : numbers){
            if(num > 0){
                allNegative = false;
                break;
            }

        }

        if(allNegative){
            for(int num : numbers){
            maxsum = Math.max(maxsum,num);
            }
            System.out.println("Maximum sum for subarrays is : " + maxsum);
            return;
        }

        for(int i = 0 ; i < numbers.length ; i++){
            currentsum += numbers[i];
            if(currentsum < 0){
                currentsum = 0;
            }

            maxsum = Math.max(currentsum,maxsum);
        }
        System.out.println("Maximum sum of sub-arrays is : " + maxsum);

    }
    public static void main(String[] args) {
          System.out.println("Program to print Maximum sum of  subarrays from an array using kadane's algorithm :");

        Scanner sc = new Scanner(System.in);
        // Logic to create array using user input :
        System.out.println("Enter the size of array :");
        int size = sc.nextInt();

        int numbers[] = new int[size];

        System.out.println("Enter the elements within the array :");
        for(int i = 0 ; i < numbers.length ; i++){
            numbers[i] = sc.nextInt();
        }

        kadane(numbers);
        
}
}

// here time complexity is much better than previous two as because we only used a single loop here so time complexity becomes : O(n)