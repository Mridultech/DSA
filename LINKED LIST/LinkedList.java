
import java.security.DrbgParameters;

public class LinkedList{
     /*
         * Linked list : linked list ek linear collection of data hai jismein data elements ko nodes ke roop mein store kiya jata hai.
         * Har node mein data aur next node ka reference hota hai. Linked list ko dynamic memory allocation ke liye use kiya jata hai.
         * 
         * isme har node ke do parts hote hain:
         * 1. Data: isme data store hota hai.
         * 2. Next: isme next node ka reference hota hai.
         * 
         * ye end waha hota hai jahan next node ka reference null hota hai.sabse pehle node ko head node kehte hain.
         * 
         * reference variables : ye variables hote hain jo kisi object ya memory location ka address store karte hain.
         * 
         * node class kaise banegi ?
         * 
         * class Node{
         * int data;
         * Node next;
         * public Node(int data){
         * this.data = data;
         * this.next = null;
         * }
         * 
         * linked list ke do special nodes hote hain:
         * Head node: ye linked list ka pehla node hota hai. isse linked list ke starting point ke roop mein use kiya jata hai.
         * Tail node: ye linked list ka last node hota hai jisme data stored hai. isse linked list ke end point ke roop mein use kiya jata hai.
         * 
         * note : jab ham linked list pe traverse kr rhe hai hamare pas ek time pe keval ek node ka data hi hota hai.next node ka reference hota hai.
         */

    
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

        public int recursiveSearchHelper(Node head, int key){/*need more practice on this */ // Time complexity : O(n) : kyuki sabhi elements pe traverse kara hai
            //Space complexity : O(n) : kyuki recursion ki wajah se stack mein function call store hota hai jo ki linear space leta hai.
            //base case : agar linked list khali hai to return -1
            if(head == null){
                return -1;
            }
            //recursive case : agar head ka data key ke barabar hai to return index
            if(head.data == key){
                return 0; // matlab 0 index pr hai
            }
            //agar head ka data key ke barabar nahi hai to recursive call karenge aur index ko increment karenge
            int index = recursiveSearchHelper(head.next, key);
            if(index == -1){
                return -1; // matlab key nahi mila
            }
            return index + 1; // matlab key mila aur index ko increment karna hai
        }

        public int recursiveSearch(int key){
            return recursiveSearchHelper(head, key);
        }

        public void reverse(){ //important ise bhi dubara dekhna hai
            Node prev = null;
            Node curr = tail = head; // kyuki ham linked list reverse kr rhe hai to tail ko head se point karna hai
            Node next; // next node ka reference store karne ke liye
            while(curr != null){
                next = curr.next; // next node ka reference store karne ke liye
                curr.next = prev; // current node ka next ko previous node se point karna hai
                prev = curr; // previous node ko current node se point karna hai
                curr = next; // current node ko next node se point karna hai
            }
            head = prev; // head ko previous node se point karna hai kyuki linked list reverse ho gayi hai
        }
    
    public static void main(String[] args) {
        
        //creating a linked list class object
        
        LinkedList list = new LinkedList();

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

        //How to remove nodes in linked list ?

        // 1. Remove First : Matlab first head node ki taraf se remove karna

        list.removeFirst();
        list.printList();

        // 2. Remove Last : Matlab last tail node ki taraf se remove karna

        list.removeLast();
        list.printList();
 
        // Linear Search in a linked list 
        int key = 2;
        list.linearSearch(key);

        // Recursive search in a linked list : Time complexity : O(n) : linear & Space complexity : O(n) : linear
        // isme recursion ki wajah se stack mein function call store hota hai jo ki linear space leta hai.
        key = 8;
        list.recursiveSearch(key);

        // Reverse a linked list using iterative approach : Time complexity : O(n) : linear & Space complexity : O(1) : constant
        // isme koi extra space nahi le rahe hai.
        // isme sirf 3 variables ka use kar rahe hai : prev, curr aur next.

        list.reverse();
        list.printList(); // ab linked list reverse ho gayi hai


    }

    }
