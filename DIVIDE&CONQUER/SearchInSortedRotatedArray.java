public class SearchInSortedRotatedArray {

    /*
     * mehtodology : to search for a target in rotated Sorted array : 
     * 
     * ex : array given : 4 5 6 7 0 1 2
     * rotated at pivot index 3
     * 
     * that means array before rotation is : 0 1 2 4 5 6 7
     * 
     * this can be solved by linear search too but that will take O(n) time so for sake of time complexity we will use form of binary search.
     * 
     * if we visualize the array on graph we can see that there are two parts of array which are sorted as two parallel lines.
     * 
     * so we can use binary search to find the target in this array.
     * 
     * we have here 2 major cases and 2 sub cases each for the major cases.
     * 
     * case 1 : when mid element is greater than start element : target lies on line 1
     * 
     * sub case 1 : when target is greater than start element and less than mid element : target lies on line 1 left side
     * sub case 2 : when target is greater than mid element  : target lies on right of mid element
     * 
     * case 2 : when target element is less than end element : target lies on line 2
     * 
     * sub case 1 : when target is less than end element and greater than mid element : target lies on line 2 right side
     * sub case 2 : when target is less than mid element : target lies on left of mid element
     * 
     */

     public static int searchTarget(int arr[] , int tar , int si , int ei){

        //BASE CASE 
        if(si > ei){
            return -1;
        }

        //kaam 

        int mid = si + (ei-si)/2; // to avoid overflow 

        //Case 1 : agar mid pe hi target mil gaya

        if(arr[mid] == tar){
            return mid;
        }

        // mid on line 1

        if(arr[si] <= arr[mid]){
            //lie on line 1 left side
            if(arr[si] <= tar && tar <= arr[mid]){
                return searchTarget(arr,tar,si,mid-1);
            }
            //lie on line 1's mid right side
            else{
                return searchTarget(arr,tar,mid+1,ei);
            }
        }
        //lie on line 2 
        else{
            //lie on line 2's mid right side
            if(tar < arr[ei] && tar > arr[mid]){
                return searchTarget(arr,tar,mid+1,ei);
            }
            //lie on line 2's mid left side
            else{
                return searchTarget(arr,tar,si,mid-1);
            }

        }

     }
    public static void main(String[] args){
        int arr[] = {4,5,6,7,0,1,2};
        int target = 0;
        int targetIdx = searchTarget(arr,target,0,arr.length-1);
        if(targetIdx == -1){
            System.out.println("Target not found");
        }
        else{
            System.out.println("Target found at index : "+targetIdx);
        }

    }
}
