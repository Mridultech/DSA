public class FirstOccurence {

    public static int firstOccurence(int numbers[] , int i , int key ){ // Time complexity : O(n) , Space complexity : O(n) , n is the number of elements in the array.
        if(i > numbers.length -1){
            return -1;
        }
        if(numbers[i] == key){
            return i;
        }

        return firstOccurence(numbers, i+1, key);
    }
    public static void main(String[] args){

     int numbers[] = { 1,2,5,2,6,2,16,6,1,14,2,3,62};
     int key = 6;
     if(firstOccurence(numbers,0,key) == -1){
        System.out.println("Key not found !");
     }
     else if(firstOccurence(numbers, 0, key) > 0){
        System.out.println("key found at : " + firstOccurence(numbers, 0, key) + "th location");
     }
        
    }
}
