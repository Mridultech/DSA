import java.util.Scanner;

public class InsertionSort { // array mein do part mein divide karte hai, ek sorted aur ek unsorted
    // sorted part mein ek ek element ko insert karte hai jab tak puri array sorted nahi ho jati or har element ko uski sahi jagah pe rkhte jate hai
    // Time complexity : O(n^2) , Space complexity : O(1)
    /*
     * ex - array : 5 4 3 2 1 : sorted let say 5 and unsorted 4 3 2 1 now we have chosen first element of unsorted array i.e 4
     * now we will compare 4 with 5 if 4 < 5 then we will swap 4 and 5 and now 4 will be at its correct position
     * now sorted array will be 4 5 and unsorted array will be 3 2 1
     * now we will choose 3 and compare it with 5 and 4 if 3 < 5 and 3 < 4 then we will swap 3 with 4 and 5 and now 3 will be at its correct position
     * now sorted array will be 3 4 5 and unsorted array will be 2 1
     * similarly we will choose 2 and compare it with 5, 4 and 3 if 2 < 5, 2 < 4 and 2 < 3 then we will swap 2 with 3, 4 and 5 and now 2 will be at its correct position
     * now sorted array will be 2 3 4 5 and unsorted array will be 1
     * similarly we will choose 1 and compare it with 5, 4, 3 and 2 if 1 < 5, 1 < 4, 1 < 3 and 1 < 2 then we will swap 1 with 2, 3, 4 and 5 and now 1 will be at its correct position
     * now sorted array will be 1 2 3 4 5 and unsorted array will be empty
     * so the final sorted array will be 1 2 3 4 5
     */

    public static void insertionSort(int numbers[]){
        int n = numbers.length;
        for(int i = 0 ; i < n-1 ; i++){
            int current = numbers[i+1];
            int previous = i;
            while(previous >=0 && numbers[previous] > current){
                numbers[previous+1] = numbers[previous];
                previous = previous - 1;
            }
            numbers[previous+1] = current; // inserting the current element at its correct position
        }
    }
    public static void main(String[] args) {
        System.out.println("Program for Insertion sort to sort an array :");
        Scanner sc = new  Scanner(System.in);

        // Logic to create array using user input :
        System.out.println("Enter the size of array :");
        int size = sc.nextInt();
        int numbers[] = new int[size];

        System.out.println("Enter the elements within the array:");
        for(int i = 0 ; i < numbers.length ; i++){
            numbers[i] = sc.nextInt();
        }

        insertionSort(numbers);

        System.out.println("The sorted array is :");
        for(int i = 0 ; i < numbers.length ; i++){
            System.out.print(numbers[i] + " ");
        }
    }
}
