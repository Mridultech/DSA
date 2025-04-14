import java.util.*;

public class PalindromeLinkedList{

        class Node {

        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }

    }
    public static Node head;
    public static Node tail;

    public static boolean isPalindrome(Node head){

        Node slow = head;
        boolean isPalindrome = true;
        Stack<Integer> stack = new Stack<>();
        //push the new node to the stack

        while(slow != null){
            stack.push(slow.data);
            slow = slow.next;
        }
        slow = head;

        //pop the node from the stack and compare with the original linked list
        while(slow != null){
            if(slow.data != stack.pop()){
                isPalindrome = false;
                break;
            }
            slow = slow.next;
        }
        return isPalindrome;
    }

    
    /*
     * Problem Statement: Given a singly linked list, determine if it is a palindrome using stacks.
     * A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward as forward.
     */
    public static void main(String[] args){
       
            PalindromeLinkedList list = new PalindromeLinkedList(); // Create an instance of PalindromeLinkedList
            Node one = list.new Node(0); // Use the instance to create a new Node
            Node two = list.new Node(1);
            Node three = list.new Node(2);
            Node four = list.new Node(2);
            Node five = list.new Node(1);
            Node six = list.new Node(0);

            //creating linked list 0->1->2->3->4->5
            list.head = one;
            list.tail = six;
            one.next = two;
            two.next = three;
            three.next = four;
            four.next = five;
            five.next = six;
            six.next = null;

            System.out.println("Linked List is Palindrome: " + list.isPalindrome(head)); // Check if the linked list is a palindrome
        }
       
    
}