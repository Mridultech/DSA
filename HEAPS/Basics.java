import java.util.*;
public class Basics {
    /*
     * Heap is a complete binary tree that satisfies the heap property.
     * Heap property:
     * 1. Properties of binary tree must be satisfied.
     * 2. For max heap, the value of each node is greater than or equal to the values of its children.
     * 3. For min heap, the value of each node is less than or equal to the values of its children.
     * 4. Heap must be a complete binary tree.
     * 
     * complete binary tree:
     * 1. All levels are completely filled except possibly the last level.
     * 2. The last level has all nodes as left as possible.
     * 3. The last level is filled from left to right.
     * 
     * we'll visualize heap as binary tree and implement it using arrays and then using heap we'll implements queues.
     * 
     * Why heap is not implemented as a class ? : due to inefficiency in time complexity it will take O(n)+ time to get implemented from a class.
     * 
     * Note : 
     * heap ke liye array ka index 0 se start hota hai.
     * then for any node at index i:
     * 1. left child = 2*i + 1
     * 2. right child = 2*i + 2
     * 3. parent = (i-1)/2
     * 
     * here in arraylist ham heap mein element ko O(1) time mein add kr paa rhe hai due to add operation of arraylist which is less than O(n).
     * 
     */

     static class Heap {
        ArrayList<Integer> heap = new ArrayList<>(); // heap is implemented using arraylist

        //adding element in heap using arraylist :
        public void add(int data){
            
        //step 1 : add the element at the end of the heap

        heap.add(data); // O(1) time complexity

        int index = heap.size() - 1; // index of the last element in the heap or of let say child
        int parent = (index - 1) / 2; // index of the parent of the last element

        //step 2 : check if the heap property is satisfied or not
            // For min heap, the value of each node is less than or equal to the values of its children.
        while(heap.get(index) < heap.get(parent) && index > 0){ // if the heap property is not satisfied then swap the element with its parent , time complexity is O(log n) in worst case.
            int temp = heap.get(index); // store the value of child in temp variable
            heap.set(index, heap.get(parent)); // set the value of parent to child
            heap.set(parent, temp); // set the value of child to parent

            index = parent; // update the index of child to parent
            parent = (index - 1) / 2; // update the index of parent to new parent

        }
     }
            // peek element from heap : peek element is topmost element of heap and first element in array/arraylist i.e. arr.get(0)
            public int peek(){
                if(heap.size() == 0){ // if heap is empty then return -1
                    return -1;
                }
                return heap.get(0); // return the first element of the heap
            }

            // remove element from heap : 
            // 1. remove the topmost element of heap and replace it with the last element of the heap.
            // 2. remove the last element of the heap.
            // 3. check if the heap property is satisfied or not.
            // 4. if not then swap the element with its child and repeat the process until the heap property is satisfied.

            private void heapify(int index){
                int leftChild = 2 * index + 1; //index of left child
                int rightChild = 2 * index + 2; // index of right child

                int minIndex = index; // index of the minimum element

                if(leftChild < heap.size() && heap.get(leftChild) < heap.get(minIndex)){ // check if left child is less than the minimum element
                    minIndex = leftChild; // update the index of the minimum element to left child
                }
                if(rightChild < heap.size() && heap.get(rightChild) < heap.get(minIndex)){ // check if right child is less than the minimum element
                    minIndex = rightChild; // update the index of the minimum element to right child
                }

                if(minIndex != index){
                    int temp = heap.get(index); // store the value of parent in temp variable
                    heap.set(index, heap.get(minIndex)); // set the value of minimum element to parent
                    heap.set(minIndex, temp); // set the value of parent to minimum element

                    heapify(minIndex); // repeat the process for the minimum element
                }

            }
            public int remove(){

                // step 1. remove the topmost element of heap and replace it with the last element of the heap.
                int data = heap.get(0); // store the value of topmost element in data variable

                //swapping the topmost element with the last element of the heap.

                int temp = heap.get(0); // store the value of topmost element in temp variable
                heap.set(0 , heap.get(heap.size() - 1)); // set the value of last element to topmost element
                heap.set(heap.size() - 1, temp); // set the value of topmost element to last element

                // step 2 : remove the last element of the heap.

                heap.remove(heap.size() -1); // remove the last element of the heap

                //step 3 : check if the heap property is satisfied or not.

                heapify(0); // check if the heap property is satisfied or not
                return data; // return the value of topmost element
            }

            public boolean isEmpty(int index){
                return heap.size() == 0; // check if the heap is empty or not
            }
    }   


    public static void main(String[] args){

        //working as priority queue and hence ham conclude kr skte hai ki jcf mein priority queue ka implementation heap se hota hai.
        Heap h = new Heap(); // create an object of heap class
        h.add(10); // add element to heap
        h.add(20); // add element to heap
        h.add(5); // add element to heap
        h.add(30); // add element to heap
        h.add(15); // add element to heap
        h.add(25); // add element to heap

        while(!h.isEmpty(0)){ // check if the heap is empty or not
            System.out.print(h.peek() + " "); // print the topmost element of the heap
            h.remove(); // remove the topmost element of the heap
        }
    }
}
