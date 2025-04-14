public class QueueLinkedList {

    /*
     * QueueLinkedList class implements a queue using a linked list.
     */

     // Node class represents a node in the linked list.
        static class Node {
        int data; // Data stored in the node
        Node next; // Pointer to the next node

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class Queue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty(){
            return head == null && tail == null;
        }

        //add 
        public static void add(int data){ // O(1)
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        //remove 

        public static int remove(){ // O(1)
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            int front = head.data;
            //single element
            if(tail == head){
                tail = head = null;
            }else{
                head = head.next;
            }
            return front;
        }

        //peek 

        public static int peek(){ // O(1)
            if(isEmpty()){
                System.out.println("Queue is empty!");
                return -1;
            }
            
            return head.data;
        }
    }
         
    public static void main(String[] args){
        Queue q = new Queue();
        q.add(10);
        q.add(20);
        q.add(30);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
