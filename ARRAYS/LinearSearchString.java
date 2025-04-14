import java.util.*;
public class LinearSearchString {

    public static int linearSearch(String names[],String key){
      for(int i = 0 ; i < names.length ; i++){ // Time complexity = O(n)
        if(names[i].equals(key)){ // key concept string ko compare karne ke liye .equals method use hota hai 
            return i;
        }
      } 
      return -1; 
    }
    public static void main(String[] args) {
        
        System.out.println("Program for linear search in array :");

        // matlab - ek ek karke linearly starting se end tak check karna 
        Scanner sc = new Scanner(System.in);
        String names[]= {"mridul","purnima","rohit","monika"};
        System.out.println("Enter the value of key to find in array :");
        String key = sc.next();
        int result = linearSearch(names,key);

        if(result == -1 ){
            System.out.println("Key not found !");
        }
        else{
            System.out.println("key " + key + " found at " + result +"th location");
        }
    }
}

