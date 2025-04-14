public class IsArraySorted {

    public static boolean isArraySorted(int arr[] , int i){ // Time complexity : O(n) , Space complexity : O(n)

        if(i == arr.length - 1){
            return true;
        }
        
        if(arr[i] > arr[i+1]){
            return false;
        }

        return isArraySorted(arr, i+1);
         
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        if(isArraySorted(arr, 0) == true){
            System.out.println("Array is sorted !");
        }
        else{
            System.out.println("Array is not sorted !");
        }
    }
}
