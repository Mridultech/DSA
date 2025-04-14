public class MergeSort{

    /*
     * methodology : 
     * to covert unsorted to sorted
     * 
     * approach : 
     * 1. Divide : Find mid and then divide biggger array in smaller sub arrays till we get smallest unit.
     * 
     * note : yaha ham middle dhundhne ke liye ham formula use karenege start index + (end index - start index)/2 kyuki jo classic formula hai i.e (start+end)/2 isse agar do badi values hui to overflow hone ka chance hai.
     * 
     * 2. Solve : Now, Solve smaller sub poritons of major array individually by merge sort.
     * 
     * 3. Merge : Now, Merge the smaller sub arrays to create complete sorted array step by step using temporary auxillar(helping) array.
     * 
     * note : yeh technique jisme ham depth mein jake solve karte jate hai ise depth first kehte hai.
     */

     public static void printArr(int arr[]){
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
     }

     public static void mergeSort(int arr[], int startIndex , int endIndex){

        // Base case: If the array has one or no elements, it is already sorted
        if (startIndex >= endIndex) {
            return;
        }

        int mid = startIndex + (endIndex - startIndex)/2; // (startIndex + endIndex)/2

        // Left
        mergeSort(arr, startIndex, mid);

        // Right 
        mergeSort(arr, mid+1, endIndex);

        // Merge
        merge(arr,startIndex,mid,endIndex);

     }

     public static void merge(int arr[], int startIndex , int mid , int endIndex){
        int temp[] = new int[endIndex - startIndex + 1]; // size for array : end-start+1
        int i = startIndex; //iterator for left part : iterator : jo traverse karne ke kaam aata hai 
        int j = mid + 1 ; // iterator for left part
        int k = 0; // iterator for temp array

        while(i <= mid && j <= endIndex){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            } else{
                temp[k++] = arr[j++];
            }
        }
        //still some elements remaining for second part i.e right part 

        // For left part remaining elements
        while(j <= endIndex){
            temp[k++] = arr[j++];
        }
        // For right part remaning elements
        while(i <= mid){
            temp[k++] = arr[i++];
        }

        //copy temp. array to orignal array 
        for(k = 0 , i = startIndex ; k < temp.length ; k++ , i++){
            arr[i] = temp[k];
        }
     }  

    public static void main(String[] args){ // Time complexity : nlogn , Space complexity : O(n)
        int arr[] = {6,3,9,5,2,8};
        int arr2[] = {5,2,6,1,2,5,7};
        mergeSort(arr, 0 , arr.length-1);
        mergeSort(arr2, 0 , arr2.length-1);
        printArr(arr);
        printArr(arr2);

    }

}