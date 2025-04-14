import java.util.*;
public class Basic_Array{

    public static void update(int test[]){
        for(int i = 0 ; i < test.length ; i++){
            test[i] = test[i] + 1;
        }
    }
    public static void main(String[] args){
        /*arrays : List iof elemments of same type placed in contiguous(next to each other in contact with something) memory location
        * 0-based indexing : indexing start from 0
        */

        /*operation in arrays 
         * create - dataType arrayName[ ] = new datatype[size]; new helps to find location for data structure 
         */

         int marks[] = new int[50]; // array size cant be changed at run time as it's static.
         int numbers[] = {1,2,3};
         String names[] = {"mridul","purnima"};
         //note : jab tak array mein kuch na store ho tab tak usme ya to 0 ya khali strings ya char store hote hai memory location pe.

        /*  
         * input and output
         */ 
        Scanner sc = new Scanner(System.in);
        int num[ ] = new int[10];
        num[0] = sc.nextInt();
        System.out.println(num[0]);

      
         /* update once declared values at locations of arrays can be updated too !
         */
        num[0] = 2;
        System.out.println(num[0]);

        //modification is also possible 

        System.out.println(num[0] + 2);

        // length method within array - used to find length of array

        //syntax arrayName.length

        System.out.println(num.length);

        //passing arrays as argument to functions - passed by reference(changes done reflected at orignal memory location)

        int test[] = {92,93,94};
        update(test);

        for(int j = 0 ; j < test.length ; j++){ // array ko hamesh 0 se shuru kro kyuki usme 0 based indexing hai 
            System.out.println(test[j]);
        }
    }
}