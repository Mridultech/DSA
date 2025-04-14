public class CircularQueueArray {

    /*
     * circular queue implementation using array
     * it is a linear data structure in which the last element is connected to the first element to make a circle
     * isme ye fayda hai ki jab ham normal array se queue implement karte hain to jab ham dequeue karte hain to front pointer ko aage badhana padta hai
     * or sare elements ko aage shift krna pdta tha jiski wajah se time complexity O(n) ho jati thi
     * but circular queue me aisa nahi hota hai
     * ham sirf front pointer ko aage badhate hain aur jab front pointer last element pe pahuchta hai to usse first element pe le jate hain
     * isse time complexity O(1) ho jati hai
     * or rear pointer ke liye yaha formula hota hai : (rear + 1) % size
     * isse rear pointer last element pe pahuchne par first element pe le jata hai
     * similarly front ka formula hota hai : (front + 1) % size
     * isse front pointer last element pe pahuchne par first element pe le jata hai
     */

     
     static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        // isEmpty method to check if the queue is empty or not
        public static boolean isEmpty(){
            return rear == -1 && front == -1;
         }

        // isFull method to check if the queue is full or not
         public static boolean isFull(){
            return (rear + 1) % size == front;
         }

        //add

        public static void add(int data){
            if(isFull()){ // check if queue is full
                System.out.println("Queue is full!");
                return;

            }else{
                if(front == -1){ // agar front -1 hai to queue empty hai
                    front = 0; // set front to 0 if queue is empty
                }
                rear = (rear+1)%size;
                arr[rear] = data;
                System.out.println("Added " + data + " to the queue.");
            }
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty!");
                return -1;
            }

            int result = arr[front]; 
            
            //last element 
                if(rear == front){
                    rear = front = -1;
                }else{
                    front = (front + 1) % size; // move front pointer to next element
                }
            return result;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty!");
                return -1;
            }
            return arr[0];
        }
     }
    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
