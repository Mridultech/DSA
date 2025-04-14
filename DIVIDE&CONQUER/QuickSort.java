public class QuickSort{

    /*
     * time complexity : average : n*logn , worst : n^2
     * space complexity : O(1)
     * 
     * approach : 
     * 
     * 1. Choose a Pivot :  mostly last element is used 
     * 
     * 2. Partition : using pivot part the array so that all the elements greater than pivot goes on right while smaller goes on left.
     * 
     * 3. Apply Quick sort individually for smaller left and right sub parts till every single elements not get sorted.
     * 
     * quick sort logic: i starting from -1 as it's intialized or uske baad sare elements ko ek ek karke pivot se compare krenge if arr[i] > pivot if yes then i elements ke liye jagah banayega by moving forward to one index in array and then swapping current value and smaller element value . note ye sab original array mein hi ho rha hai jaha already elements filled hai. 
     * 
     * at last ek baar or swap ho jayega between pivot and i+1.
     * 
     * uske baad ham smaller sub parts ke liye same process apply karenge till they hits base cases respectively.
     * 
     * important note : Worst time complexity of quick sort : ye jab aayegi jab yah to pivot largest ho ya smallest kyuki fir hame jo comparison karne padenge after each partitioning that sum ups to an ap of n naturals which tells us that time complexity becomes O(n^2) at worst cast.
     * 
     */

    public static void printArr(int arr[]){
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int arr[] , int si /*starting index */ , int ei /*ending index */){

        /* step 1 : find pivot : last element of array */

        /* step 2 : creating partition function for partitioning during whole sorting */
        
        //base case 

        if(si >= ei){
            return;
        }
        
        int pIdx = partition(arr,si,ei); // for whole major array
        quickSort(arr,si,pIdx-1); //for left partitioned sub array
        quickSort(arr,pIdx+1,ei); //for left partitioned sub array
       
    }

    public static int  partition(int arr[], int s , int e){
        int pivot = arr[e];
        int i = s - 1; // to make place for smaller elements than pivot

        for(int j = s ; j < e ; j++){
            if(arr[j] <= pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[e]; // call by reference indirectly implements in java in objects and arrays
        arr[e] = temp;
        return i;

    }
    public static void main(String[] args){
        int arr[] = {2,3,6,1,3,6,1,6,4};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}