import java.util.*;

public class BubbleSort{ //Time complexity : O(n^2) , Space complexity : O(1) but we optimized it so now time complexity is O(n) for best case 
    static int swap;
    public static void bubbleSort(int numbers[]){ //idea : largest elements come to end of array by swapping with adjacent array elements
        int n = numbers.length;
        for(int turns = 0 ; turns < n-1 ; turns++){
            for(int j = 0 ; j < (n-1-turns) ; j++){
                if(numbers[j] > numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                    swap++;
                }
            }
        }
        if(swap == 0){
            System.out.println("Array is already sorted");
        }
    }
    public static void main(String[] args) {
        System.out.println("Program for Bubble sort to sort an array :");
        Scanner sc = new  Scanner(System.in);

        // Logic to create array using user input :
        System.out.println("Enter the size of array :");
        int size = sc.nextInt();
        int numbers[] = new int[size];

        System.out.println("Enter the elements within the array:");
        for(int i = 0 ; i < numbers.length ; i++){
            numbers[i] = sc.nextInt();
        }

        bubbleSort(numbers);
        System.out.println("The sorted array is :");
        for(int i = 0 ; i < numbers.length ; i++){
            System.out.print(numbers[i] + " ");
        }
    }
}