import java.util.*;
public class LinearSearch {

    public static int linearSearch(int numbers[],int key){
      for(int i = 0 ; i < numbers.length ; i++){ // Time complexity = O(n)
        if(numbers[i] == key){
            return i;
        }
      } 
      return -1; 
    }
    public static void main(String[] args) {
        
        System.out.println("Program for linear search in array :");

        // matlab - ek ek karke linearly starting se end tak check karna 
        Scanner sc = new Scanner(System.in);
        int numbers[]= {1,2,3,4,5,6,7,8,9};
        System.out.println("Enter the value of key to find in array :");
        int key = sc.nextInt();
        int result = linearSearch(numbers,key);

        if(result == -1 ){
            System.out.println("Key not found !");
        }
        else{
            System.out.println("key " + key + " found at " + result +"th location");
        }
    }
}
