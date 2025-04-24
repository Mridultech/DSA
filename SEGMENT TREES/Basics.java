public class Basics {
    /*
     * Segment trees are a data structure that allows for efficient range queries and updates.
     * Range queries can be sum, min, max, gcd, lcm, etc.
     * 
     * Need of segment trees:
     * 1. We need to perform range queries and updates on an array.
     * 2. Questions in which we have to do updations and to do queries within ranges than we use segment trees as here time complexity for both query and update is O(log n).
     * whereas for bruteforce : for update : O(1) and for query : O(n)
     * and in prefix sum approach : for update : O(n) and for query : O(1)
     * total levels = log(n) with base 2
     * total nodes = 2n - 1 but for safety we take 4n so that we can store all the nodes.
     * segment tree is a binary tree.
     * iske har ek node mein subarray ka sum hoga for that particular range. 
     * ex : array = [1, 2, 3, 4, 5] , isme ham mid se batke do portions bnaate hai jisme aadha left portion aur aadha right portion hota hai.
     * left = array[0] to array[mid] and right = array[mid+1] to array[n-1]
     *                         1,2,3,4,5
     *                           /   \
     *                        1,2,3  4,5
     *                       /   \    /  \
     *                     1,2   3   4    5
     *                    /  \
     *                  1    2
     * 
     * har ek node mein uska sum hoga.
     * Note: for n nodes size of segment tree = 4*n
     * segment tree is a full binary tree.
     * full binary tree mein har ek node ke do children hote hai except leaf nodes.
     * we will make segment trees as an array 
     * for parent node with index i ,
     * left child = 2*i + 1
     * right child = 2*i + 2
     * Note : for construction of segment tree : time complexity = O(n)
     * but for query and update : O(log n)
     */

     static int tree[];

     public static void init(int n){
        tree = new int[4*n];
     }

     public static int buildSegmentTree(int arr[], int i, int start, int end){
        if(start == end){
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start + end) / 2;
        buildSegmentTree(arr, 2*i + 1, start, mid); // left child
        buildSegmentTree(arr, 2*i + 2, mid + 1, end);// right child
        tree[i] = tree[2*i + 1] + tree[2*i + 2]; // sum of left and right child
        return tree[i];
     }

     public static int getSumUtil(int i ,int si , int sj , int qi , int qj){ // O(log n) time complexity
        if(qj < si || qi > sj){
            return 0; // no overlap
        }
        else if (si >= qi && sj <= qj){
            return tree[i]; // complete overlap
        }
        else{
            int mid = (si + sj) / 2;
            int leftSum = getSumUtil(2*i + 1, si, mid, qi, qj); // left child
            int rightSum = getSumUtil(2*i + 2, mid + 1, sj, qi, qj); // right child
            return leftSum + rightSum; // partial overlap
        }
     }

     public static int getSum(int arr[], int qi, int qj){
        int n = arr.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
     }

     public static void updateUtil(int i , int si, int sj , int index, int difference){// non overlapping, time complexity = O(log n)
        if(index > sj || index < si){
            return;
        }
        //for rest cases
        tree[i] += difference;

        if(si != sj){ // not a leaf node
            int mid = (si + sj) / 2;
            updateUtil(2*i + 1, si, mid, index, difference); // left child
            updateUtil(2*i + 2, mid + 1, sj, index, difference); // right child
        }
        else {
            return;
        }

     }

     public static void update(int arr[], int index, int newValue){
        int n = arr.length;
        int difference = newValue - arr[index];
        arr[index] = newValue;
        updateUtil(0, 0, n - 1, index, difference);
     }
    public static void main(String[] args){
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        init(n);
        buildSegmentTree(arr, 0, 0, n - 1);

        for(int i = 0; i < 4*n; i++){
            System.out.print(tree[i] + " ");
        }

        System.out.println(getSum(arr, 0, 3)); // sum of range [0, 3]

        System.out.println(getSum(arr, 1, 4)); // sum of range [1, 4]
        update(arr, 1, 10); // update index 2 to 10
        System.out.println(getSum(arr, 1, 4)); // sum of range [1, 4]
    }
}