public class ZigZagLinkedList {

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
    
    public int removeFirst(){
        //corner case 1 : agar linked list empty ho i.e size = 0
        if(size == 0){
            System.out.println("Linked list is empty !");
            return Integer.MIN_VALUE;
        }
        // corner case 2 : agar linked list mein keval ek element hi ho to 
        if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // baki bache hue cases ke liye :
        int val = head.data;
        head = head.next;
        size--;
        
        return val;
    }

    public int removeLast(){
        //corner case 1 : agar linked list empty ho to 
        if(size == 0){
            System.out.println("Linked list is empty !");
            return Integer.MIN_VALUE;
        }
        //corner case 2 : agar linked list ka size 1 hai : matlab ek hi node hai
        if(size == 1){
            int val = head.data; // tail.data bhi kr skte hai lekin agar ek hi node hai to dono ke data ki value same hi hogi
            head = tail = null;
            size = 0;
            return val;
        }
        // baki cases ke liye 

        Node temp = head;
        int i = 0;
        while(i < size-2){
            temp = temp.next;
            i++;
        }
        int value = tail.data; // or temp.next.data ki jaha temp.next = tail 
        temp.next = null;
        tail = temp;
        size--;
        return value;

    }

    public int linearSearch(int key){ // Time complexity : O(n) : kyuki sabhi elements pe traverse kara hai
        int index = 0;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
            index++;
            if(temp.data == key){
                System.out.println("Key found! at index :" + index);
            }
            else{
                return Integer.MIN_VALUE;
            }
        }
        return -1;
    }

    public void zigZag(){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow is mid node
        Node mid = slow;

        // reverse 2nd half of the linked list
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // alternate merge - zig zag merge
        while(left != null && right != null){
            nextL = left.next;
            nextR = right.next;

            left.next = right;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] args) {
        
        /*
         * Problem statement - ZigZag Linked List
         * Given a linked list, rearrange the nodes in such a way that they are in zigzag order. 
         * 
         * approach : 
         * 
         * step 1 : Find mid node : 
         * 
         * a. for odd length of linked list : exact middle node
         *    first-last , first+1-last-1, first+2-last-2, ... middle
         * b. for even length of linked list : first half ka last node
         *   first-last, first+1-last-1, first+2-last-2, ... middle-1, middle+1
         * 
         * 2. Reverse the second half of the linked list.
         * 
         * 3. Merge the two halves of the linked list in zigzag order.(alternate merging )
         * 
         */
        ZigZagLinkedList ll = new ZigZagLinkedList();

         ll.addLast(1);
         ll.addLast(2);
         ll.addLast(3);
         ll.addLast(4);
         ll.addLast(5);
         ll.addLast(6);

         // 1 -> 2 -> 3 -> 4 -> 5 -> null

         ll.printList(); // print linked list
         ll.zigZag(); // zigzag linked list banaenge
         ll.printList(); // print linked list after zigzag
    }
}
