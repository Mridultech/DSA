public class Question1 {

    public static void changeArr(int arr[] , int index , int value){ // Time complexity : O(n) and Space complexity : O(n) where n is the length of the array ,kyuki call stack mein n calls hui dono side uptodown and downtoup => 2n => n and space complexity is O(n) kyuki n elements ka array banaya hai.
        //base case

        if(index == arr.length){
            printArr(arr);
            return;
        }

        //kaam
        arr[index] = value; // pehli value daldi
        //recursive calls for rest of the array
        if(index < arr.length){
            changeArr(arr,index+1,value+1);
    }
        //backtracking
        arr[index] = arr[index] - 2;
    }

    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] ars){
        int arr[] = new int[5];
        changeArr(arr,0,1);
        printArr(arr);

        //Problem statement : First we have to take a array as an input and then backtrack the given array by decreasing all values by -2 from end to start.
        //Example : [1,2,3,4,5] => [1,0,1,2,3]
        //approach : We will use backtracking to solve this problem. We will start from the end of the array and decrease the value by 2 and then move to the next element.
        // Note : backtracking is always done after function call not before it.


    }
}
