
public class StackLinkedList {

    static class Node{ // stack mein nodes bnane ke liye

        int data;
        Node next;

        Node(int data){

            this.data = data;
            this.next = null;

        }

    }
    
    static class Stack{
        
        static Node head = null;

        //push 

        public static void push(int data){

            Node newNode = new Node(data); // pehle ek node banaya data ke sath

            if(isEmpty()){ // check kr rhe hai agar linkedlist khali hai to head hi naya node hai 
                head = newNode;
                return;
            }

            // agar linked list khali nahi hai to head ki taraf se ek node enter kra denge

            newNode.next = head;
            head = newNode;
        }
        
        //pop
            public static int pop(){

                if(isEmpty()){ // checking if stack is empty or what?
                    System.out.println("UNDERFLOW!");
                    return 0;
                }

                // if not then

                int top = head.data;
                head = head.next;
                return top;
            }

        //peek 

            public static int peek(){
                
                if(isEmpty()){ // checking if stack is empty or what?
                    System.out.println("UNDERFLOW!");
                    return 0;
                }

                //if not then 

                return head.data;
            }

        //isEmpty()

        public static boolean isEmpty(){
            return head == null;
        }

    }
    public static void main(String[] args) {

        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
