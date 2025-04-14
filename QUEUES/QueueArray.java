public class QueueArray {

    /*
     * here we are creating a queue using an array
     * but by making queue from array there are certain disadvantages such as :
     * 1. we have to define the size of the queue at the beginning and can change it as it's fixed.
     * 2. if we remove an element from the queue then the space will be wasted and we can't use it again.
     * 3. if we want to add an element in the queue and there is no space left then we can't add it.
     * 4. time complexity of adding and removing an element is O(1) but in case of array we have to shift the elements which will take O(n) time.
     */

     static class Queue{
        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty(){
            return rear == -1;
        }

        //add

        public static void add(int data){
            if(rear == size - 1){
                System.out.println("Queue is full!");
                return;

            }else{
                rear += 1;
                arr[rear] = data;
                System.out.println("Added " + data + " to the queue.");
            }
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty!");
                return -1;
            }

            int front = arr[0]; 
            for(int i = 0 ; i < rear ; i++){
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty!");
                return -1;
            }
            return arr[0];
        }
     }
    public static void main(String[] args){
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
