public class LastOccurence {

    public static int lastOccurence(int arr[] , int key , int i){
        if(i == arr.length){ // agar puri array check ho chuki hai is point tak or kuch nahi mila hai to
            return -1;
        }
        int isFound = lastOccurence(arr,key,i+1); // fucntion aage wali array mein search karne ke liye

        if(isFound != -1){ // matlab kuch mila hai 
            return isFound;
        }

        if(arr[i] == key){
            return i;
        }
      
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = { 1,2,3,6,1,3,6,1,4,6,1,4,6};
        if(lastOccurence(arr, 3 , 0) == -1){
            System.out.println("Key dosen't exist here !");
        }
        else{
            System.out.println("key found at : " + lastOccurence(arr, 3, 0) + "th index");
        }
    }
}
