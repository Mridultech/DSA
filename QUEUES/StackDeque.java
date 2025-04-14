import java.util.*;

public class StackDeque{

    /*
     * This is a stack implementation using Deque.
     * The stack is a LIFO (Last In First Out) data structure.
     * The stack is implemented using a Deque (double-ended queue).
     * The stack has three main operations:
     * 1. push: adds an element to the top of the stack.
     * 2. pop: removes the top element from the stack.
     * 3. peek: returns the top element of the stack without removing it.
     * 
     * The stack is implemented using a LinkedList as the underlying data structure.
     * The LinkedList class implements the Deque interface, which allows us to add and remove elements from both ends of the list.
     * The stack is implemented using the addLast() and removeLast() methods of the Deque interface.
     * The peek() method uses the peekLast() method of the Deque interface to return the top element of the stack without removing it.
     * 
     */

    static class Stack{

        Deque<Integer> deque = new LinkedList<>();

        public void push(int x){
            deque.addLast(x);
        }

        public int pop(){
            return deque.removeLast();
        }

        public int peek() {
            return deque.peekLast();
        }
    }
    public static void main(String[] args){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("peek = " + s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}