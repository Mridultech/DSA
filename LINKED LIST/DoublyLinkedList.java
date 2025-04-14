

public class DoublyLinkedList{
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //add

    //addFirst
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        //corner case : if there is no node in linked list
    if(head == null){
        head = tail = newNode;
        return;
    }
    
    newNode.next = head;
    head.prev = newNode;
    head = newNode;
    }
     
    //addLast
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        //corner case : if there is no node in linked list
        
        if(head == null){
            head=tail=newNode;
        }

        //tail ke next node ko newNode ka refererence de denge

        tail.next = newNode;
        newNode.prev = tail;

        // newNode ko tail bana denge

        tail = newNode;
    }

    //remove 

    //removeFirst

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
        head.prev = null;
        size--;
        return val;
    }

    //removeLast
    public int removeLast(){
    //corner case : if linked list is empty
    if(size == 0){
        System.out.println("Linked list is empty!");
        return 0;
    }
    //corner case : if linked list having only single element.
    if(size == 1){
        int val = tail.data;
        head = tail = null;
        return val;
    }
    // for other cases
    int val = tail.data;
    tail.prev.next= null;
    tail.prev = null;
    tail = tail.prev;
    return val;
    }

    //print
    public void print() {
        Node temp = head;
        System.out.println("null");
        while(temp != null){
            System.out.print(temp.data + "<-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;

        }
        head = prev;
    }

    
    public static void main(String[] args){
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.print();

        // dll.removeFirst();
        // dll.print();
        
        // dll.removeLast();
        // dll.print();

        // dll.removeFirst();
        // dll.print();

        dll.reverse();
        dll.print();
    }
}