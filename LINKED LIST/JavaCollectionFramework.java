import java.util.LinkedList;
public class JavaCollectionFramework {

    /*
     * java collection framework : 
     * collection of multiple data structures within java with predefined attributes
     * yehi use karne hai hame for questions 
     * piche jo hamne devlop krna sikha ds ko wo to jab use hoga jab hame ya to scratch se banane ko bola jae ya thodi ds ki implementatiton badlani ho
     * java collection framework ka yeh bhi fayda hai ki sare functions pehle se hi max. optimize till knowledge of now ke according likhe hai.
     */
    public static void main(String[] args){

        // banane ka syntax : arraylist jaisa hi hai

        LinkedList<Integer> ll = new LinkedList<>();

        //add
        ll.addLast(2);
        ll.addLast(1);
        ll.addFirst(0);
        // 0 -> 1 -> 2
        System.out.println(ll);
        //remove
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);
    }
}
