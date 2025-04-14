import java.util.Scanner;

public class CountingSort { // usually used where range of numbers is small and we'll consider only positive numbers here.

//methodology : we'll create a count array of size max+1 and then we'll store the count of each element in the array.
// then we'll update the count array to store the actual position of the element in the sorted array.
// then we'll create a new array to store the sorted array.
// ye mainly waha use hoga jaha numbers ki range choti ho and numbers are positive fir chahe numbers kitne bhi ho.

    public static void countingSort(int numbers[]){ // time complexity : O(n+k) where n is the number of elements in the array and k is the range of the numbers.
        int largest = Integer.MIN_VALUE;
        for(int i = 0 ; i < numbers.length ; i++){
            largest = Math.max(largest,numbers[i]);
            }
        
        int count[] = new int[largest+1];
        for(int i = 0 ; i < numbers.length ; i++){
            count[numbers[i]]++;
        }
        
        //sorting
        int j = 0;
        for(int i = 0 ; i < count.length ; i++){
            while(count[i]>0){
                numbers[j] = i;
                j++;   
                count[i]--;
            }
        }
    }

    
    public static void main(String[] args) {
        System.out.println("Program for Counting sort to sort an array :");
        Scanner sc = new  Scanner(System.in);

        // Logic to create array using user input :
        System.out.println("Enter the size of array :");
        int size = sc.nextInt();
        int numbers[] = new int[size];

        System.out.println("Enter the elements within the array:");
        for(int i = 0 ; i < numbers.length ; i++){
            numbers[i] = sc.nextInt();
        }

        countingSort(numbers);
        System.out.println("The sorted array is :");
        for(int i = 0 ; i < numbers.length ; i++){
            System.out.print(numbers[i] + " ");
        }
    }    
}
