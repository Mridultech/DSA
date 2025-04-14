import java.util.*;
public class BinarySearch{

    public static int binarySearch(int numbers[],int key){
        int start = 0;
        int end = numbers.length-1;

        // Logic for binary search : 
        while(start <= end){
        int mid = (start + end)/2;
        if(numbers[mid]==key){
            System.out.println("key found !");
            return mid;
        }
        else{
            if(key > numbers[mid]){
                start = mid + 1;
            }
            else{
                end = mid - 1 ;
            }
        }
    }   
        return -1;
    }
    public static void main(String[] args){
        System.out.println("Program for binary search in array");
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter the key you want to find within array");
        int key = sc.nextInt();

        int result = binarySearch(numbers, key);

        if(result == -1){
            System.out.println("key not found in given array !");
        }
        else{
            System.out.println("Given key is found at " + result + "th" + " location ");
        }
    }
}