import java.util.*;
public class PairsInArray{
    static int counter;
    
    public static void pairs(int numbers[]){
        System.out.println("Pairs :");
        for(int i = 0 ; i < numbers.length ; i++){
            int currentnumber = numbers[i];
            for(int j = i+1 ; j < numbers.length ; j++){
                System.out.print("(" + currentnumber + "," + numbers[j] + ")");
                counter++; // agar koi variable ko class ke andr or method ke andr intialize krdiya to default starting mein uski koi value nahi hogi lekin agar class ke andr lekin method se bahar intialize kra to wo by default 0 value le lega.
            }
            System.out.println();
        }
        System.out.println("Total number of pairs that can be formed is : " + counter); // pehle 4 pairs bani fir 3 fir 2 fir 1 kyuki ham unique distinct pairs ki search mein hai to ye pattern kuch sum of n natural numbers jaisa hai isiliye formula to find numbers of pairs in a given array having n distinct elements are : [n(n+1)]/2


    }
    public static void main(String[] args){
        System.out.println("Program to print pairs from an array :");
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

        pairs(numbers);
    }
}