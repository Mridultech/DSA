import java.util.*;
public class ArrayReverse{

    public static void reverse(int numbers[]){
        int start = 0;
        int end = numbers.length-1;
        int temp = 0;
        //logic for swapping 

        while(start < end){
        temp = numbers[start];
        numbers[start]= numbers[end];
        numbers[end] = temp;

        start++;
        end--;
        }
    }
    public static void main(String[] args) {
        
        System.out.println("Program to reverse an array");

        //main logic kya hai - just first value shuru se first index nikalo or end se last dono ko swap karo and then first index bhadado or last wala kam karo or same process repeat karo jab tak start jo hai end se kam ho 
        Scanner sc = new  Scanner(System.in);


        // Logic to create array using user input :
        System.out.println("Enter the size of array :");
        int size = sc.nextInt();
        int numbers[] = new int[size];

        System.out.println("Enter the elements within the array:");
        for(int i = 0 ; i < numbers.length ; i++){
            numbers[i] = sc.nextInt();
        }
        System.out.println("Array before reversing it is : ");

        for(int i = 0 ; i < numbers.length ; i++){
            System.out.println("Array's " + i + "th element is " + numbers[i]);
        }
        reverse(numbers);

        System.out.println("Array after reversing it is : ");

        for(int i = 0 ; i < numbers.length ; i++){
            System.out.println("Array's " + i + "th element is " + numbers[i]);
        }
    }
}