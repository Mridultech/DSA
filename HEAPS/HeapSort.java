public class HeapSort {
    /*
     * approach of heap sort : 
     * step 1 : jo tree hai usme pehle step mein ham max heap banayenge to sabse upar sabse bada element aajayega.
     * max heap kaise banayenge : non leaf nodes ko heapify method se process krke.
     * step 2 : ab jo max heap ban gaya hai usme sabse bada element root node hai usse ham last node of array se swap karenge.
     * step 3 : ab jo last node hai usse ham ignore karenge kyuki wo sorted hai.
     * ab same repeat karenge step 1 se step 3 tak jatak sabhi elements sorted nahi ho jate.
     * 
     * heap sort mein hamne ksii extra space ka use nahi kra this is it's plus point.
     * 
     * important sorting technique.
     */

     public static void heapify(int arr[],int i , int size){
        int left = 2*i + 1;
        int right = 2*i + 2;
        int maxIndex = i;

        if(left < size && arr[left] > arr[maxIndex]){
            maxIndex = left;
        }

        if(right < size && arr[right] > arr[maxIndex]){
            maxIndex = right;
        }

        if(maxIndex != i){
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;

            heapify(arr,maxIndex,size);
        }
     }
     public static void dheapify(int arr[],int i , int size){
        int left = 2*i + 1;
        int right = 2*i + 2;
        int minIndex = i;

        if(left < size && arr[left] < arr[minIndex]){
            minIndex = left;
        }

        if(right < size && arr[right] < arr[minIndex]){
            minIndex = right;
        }

        if(minIndex != i){
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            heapify(arr,minIndex,size);
        }
     }
    
     public static void heapSort(int arr[]){ // 2 * O(nlogn) => O(nlogn)
        //step 1 - build maxheap 
        int n = arr.length;
        for(int i = n/2; i >= 0; i--){ // O(n/2 * logn) => O(nlogn)
            // heapify(arr, i , n); // for ascending order
            dheapify(arr, i , n); // for descending order
        }

        //step 2 - push largest at end

        for(int i = n -1 ; i > 0 ; i--){ // O(nlogn)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp; 

            // heapify(arr ,0 , i); for ascending order
            dheapify(arr ,0 , i); // for descending order
        }
     }

     
    public static void main(String[] args){
        int arr[] = {1,5,2,6,3};
        heapSort(arr);
        //print
        for(int i = 0 ; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
