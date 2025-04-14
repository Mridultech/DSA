public class RemoveNthFromEnd{

    
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //head create krne ke liye
    public static Node head;
    //tail create krne ke liye
    public static Node tail;
    //size determine karne ke liye size variable intialize kara hai 
    public static int size; // static isiliye kyuki agar linked list mein kahi bhi changes ho to same size mein hi changes ho .

    public void addFirst(int data){
        //step 1 : Node create karenge
        Node newNode = new Node(data);
        size++;
        //step 2 : agar linked list khali hai to head aur tail dono ko newNode se point karenge
        if(head == null){
            head = tail = newNode;
        }    
        //step 3 : agar linked list khali nahi hai to newNode ko head se point karenge aur head ko newNode se point karenge
        else{
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(int data){
        //step 1 : Node create karenge

        Node newNode = new Node(data);
        size++;
        //if list is empty 

        if(head == null){
            head=tail=newNode;
        }

        //step 2 : tail ke next ko newNode ka reference de denge

        tail.next = newNode;

        //step 3 : newNode ko tail bana denge

        tail = newNode;
    }
    
    public void printList(){ // Time complexity : O(n) : linear
        //Linked list ko print karne ke liye head se lekar tail tak traverse karenge aur data print karenge . Note : temp isiliye banaya hai kyuki head ko change nahi karna hai.
        //step 1 : agar linked list khali hai to null print karenge
        if(head == null){
            System.out.println("Linked list is empty");
            return;
        }
        //step 2 : agar linked list khali nahi hai to head se lekar tail tak traverse karenge aur data print karenge
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addMiddle(int index , int data){
        //handling corner cases : agar linked list mein ek bhi node na ho to
        if(head == null){
            head = tail = null;
        } // 
        //agar data address 0 pe add krna ho to (matlab pehle address pr)
        if(index == 0){
            addFirst(data); //yaha pe size++ isiliye add nahi krenge kyuki yaha already addFirst mein size ++ kr rkha hai to do baar ho jayega
            return; 
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0; // for tracking index of temporary variable
        while(i < index-1){
            temp = temp.next;
            i++;
        }

        //jab i == index - 1 ho gaya matlab jaaha insert karna hai usse just pichle node pe pahuch gaya hai
        // ab hame previous node ke next ko newnode ki taraf point krna hai or newnode ke next ko agle node ki taraf
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteNthFromEnd(int index){

        //calculate size of linked list
        Node temp = head;
        int calculatedSize = 0;
        while(temp != null){
            temp = temp.next;
            calculatedSize++;
        }
        //case : agar head ko delete krna ho to matlab last se length of linkedlist wale node ko

        if(index == calculatedSize){
            head = head.next;
            size--; // Decrement size only when a valid deletion occurs
            return;
        }

        //baki cases ke liye : size-index
        
        int i = 1 ;
        int indexToFind = size-index; // agar hame end se nth node chaiye to wo hame size of linked list - n karke mil jata hai starting se gino to uska wohi index hota hai
        Node prev = head;
        while(i < indexToFind){
            prev = prev.next;
            i++;
        }
        if (prev.next != null) { // Ensure valid deletion
            prev.next = prev.next.next;
            size--; // Decrement size only when a valid deletion occurs
        }
    }
    public static void main(String[] args){
        
        //creating a linked list class object
        
        RemoveNthFromEnd list = new RemoveNthFromEnd();

        // Add in linked list

        //1. Add at first position : Time complexity : O(1) : constant
        list.printList();
        list.addFirst(2);
        list.printList();
        list.addFirst(1);

        //2. Add at last position : Time complexity : O(1) : constant
        list.printList();
        list.addLast(3);
        list.printList();
        list.addLast(4);
        list.printList();

        //Linked list ko print karana hai : 
        //head se lekar tail tak traverse karenge temporary node ki madad (head ko temp mein head ki value ko store karke) se aur data print karenge

        //Middle of linked list mein enter karana hai. : Time complexity : O(n) : linear
        
        list.addMiddle(1,8);
        list.printList();
        System.out.println("Size of linked list is : " + size);
        
        //End se nth node ko hatana hai 
        int index = 4;
        list.deleteNthFromEnd(index);
        list.printList();
        System.out.println("Size of linked list is : " + size);
        int index2 = 3;
        list.deleteNthFromEnd(index2);
        list.printList();
        System.out.println("Size of linked list is : " + size);
       }
    }

