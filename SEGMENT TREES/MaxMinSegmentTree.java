import java.util.*;
public class MaxMinSegmentTree {

    /*
     * Given an array of integers, we need to find : 
     * 1. the maximum and minimum element in a given range i to j.
     * 2. Update the element at a given index.
     */
    static int tree[];

    public static void inti(int n){
        tree = new int[4 * n]; // 4n size of segment tree
    }

    public static void buildSegmentTree(int i , int si, int sj, int arr[]){
        if(si == sj){
            tree[i] = arr[si];
            return;
        }

        int mid = (si + sj) / 2; // si + (sj - si) / 2;
        buildSegmentTree(2 * i + 1, si, mid, arr); // left child
        buildSegmentTree(2 * i + 2, mid + 1, sj, arr); // right child
        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]); // max of left and right child
    }

    public static int getMaximumUtil(int i, int si, int sj, int qi, int qj){
        if(si > qj || sj < qi){ // no overlap
            return Integer.MIN_VALUE; // return min value for max query
        }
        else if(si >= qi && sj <= qj){ // complete overlap
            return tree[i];
        }
        else {
            int mid = (si + sj) / 2; // si + (sj - si) / 2;
            int leftMax = getMaximumUtil(2 * i + 1, si, mid, qi, qj); // left child
            int rightMax = getMaximumUtil(2 * i + 2, mid + 1, sj, qi, qj); // right child
            return Math.max(leftMax, rightMax); // max of left and right child
        }
    }

    public static int getMaximum(int arr[], int qi, int qj){
        int n = arr.length;
        return getMaximumUtil(0, 0, n - 1, qi, qj); // root node is at index 0 and range is from 0 to n-1
    }

    public static void updateUtil(int i, int si, int sj, int index, int newValue){
        if(index < si || index > sj){ // no overlap
            return;
        }
       
        if(si == sj){ // leaf node
            tree[i] = newValue; // update the value in the segment tree
            return;
        }
        tree[i] = Math.max(tree[i], newValue); // update the value in the segment tree
        if(si != sj){
            int mid = (si + sj) / 2; // si + (sj - si) / 2;
            updateUtil(2 * i + 1, si, mid, index, newValue); // left child
            updateUtil(2 * i + 2, mid + 1, sj, index, newValue); // right child
        }
    }

    public static void update(int arr[], int index, int newValue){
        arr[index] = newValue; // update the value in the original array
        int n = arr.length;
        // update the segment tree
        updateUtil(0, 0, n-1,index, newValue); // update the segment tree
    }
    public static void main(String[] args){
        int arr[] = {6, 8, -1, 2, 17 , 1, 3, 2, 4};
        int n = arr.length;
        inti(n);
        buildSegmentTree(0, 0, n - 1, arr); // root node is at index 0 and range is from 0 to n-1
 
        for(int i = 0; i < tree.length; i++){
            System.out.print(tree[i] + " ");
        }

        int max = getMaximum(arr, 2, 5); // range from 2 to 5
        System.out.println("\nMax in range 2 to 5 is: " + max); // 17

        update(arr, 2, 20); // update the value at index 2 to 20
        
        max = getMaximum(arr, 2, 5); // range from 2 to 5
        System.out.println("Max in range 2 to 5 after update is: " + max); // 20
    }
}
