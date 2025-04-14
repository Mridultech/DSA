import java.util.Scanner;

public class SelectionSort { //Time complexity : O(n^2) , Space complexity : O(1)
    static int swap;

    /*
     * ex : array : 2.4.3.1.5
     * 1. smallest = 1 , 1 comes to starting of array and rest : 2,4,3,5 is unsorted array
     * 2. smallest = 2 , 2 comes to starting of array and rest : 4,3,5 is unsorted array
     * 3. smallest = 3 , 3 comes to starting of array and rest : 4,5 is unsorted array
     * 4. smallest = 4 , 4 comes to starting of array and rest : 5 is unsorted array
     * 5. smallest = 5 , 5 comes to starting of array and rest : nothing is left in unsorted array
     * hence array is sorted
     */

    public static void selectionSort(int numbers[]){ // sabse chota element nikalo puri array mein se or use starting mein daldo
        int n = numbers.length;
        //outer loop
        for(int i = 0 ; i < n-1 ; i++){ // n-1 because last element will be automatically sorted
            int minPos = i;
            //inner loop
            for(int j = i+1 ; j < n ; j++){
                if(numbers[j] < numbers[minPos]){
                    minPos = j;
                }
            }
            if(numbers[minPos] != numbers[i]){
                int temp = numbers[i];
                numbers[i] = numbers[minPos];
                numbers[minPos] = temp;
                swap++;
            }
            else{
                continue;
            } 
        }

        if(swap == 0){
            System.out.println("Array is already sorted");
            System.out.println("The sorted array is :");
            for(int i = 0 ; i < numbers.length ; i++){
                System.out.print(numbers[i] + " ");
            }
        }
        else{
            System.out.println("The sorted array is :");
            for(int i = 0 ; i < numbers.length ; i++){
                System.out.print(numbers[i] + " ");
            }
        }
    }
    
 public static void main(String[] args) {
        System.out.println("Program for Selection sort to sort an array :");
        Scanner sc = new  Scanner(System.in);

        // Logic to create array using user input :
        System.out.println("Enter the size of array :");
        int size = sc.nextInt();
        int numbers[] = new int[size];

        System.out.println("Enter the elements within the array:");
        for(int i = 0 ; i < numbers.length ; i++){
            numbers[i] = sc.nextInt();
        }

        selectionSort(numbers);

    }   
}
