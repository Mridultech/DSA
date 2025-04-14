import java.util.*;
public class NextGreaterElement { // Time complexity : O(n)

    /*
     * is savaal ka logic important hai kyuki kayi jagah or questions mein use hoga 
     * Problem statement : ek array de rkhi hai to us array mein ek element at particular index ka just next greater element after it moving from left to right.
     * ex arr = [6,8,0,1,3] nextgreater = [8,-1,1,3,-1] : jaha particular element se bada kuch nahi hoga wha -1 return hoga . we're assuming that koi next greater hai hi nahi
     * 
     * //bruteforce : nested loop se traverse krke find  , time comlexity : O(N^2)
     * 
     * //for optimized time complexity 
     * 
     * approach using stacks : 
     *  ek array banegi jisme elements honge , ek stack banega , ek aur array banegi jisme ith index pe ith element of original element wali array ke ith element ka nextGreater store hoga.
     * 3-step approach hai
     * step 1 : ya to jab tak stack khali nahi hota ya fir jab tak stack ka top element array ke current element se chota hai to pop krte rhe 
     * step 2 : agar stack khali ho to nextGreater -1 return kardo nahi to top element of stack
     * step 3 : current element of array ke index ko stack mein push krdo jisse age wale or elements proper tracking kr paye.
     * 
     * possible variations of this question : 
     * 1. next smaller element to left : isme step 1 mein chota hona chahiye bada nahi
     * 2. next greater element to left : isme step 1 mein left se right ki jagah right se left karna padega
     * 3. next smaller element to right : isme step 1 mein left se right ki jagah right se left karna padega and step 1 mein bada hona chahiye chota nahi
     * 4. next greater element to right : isme step 1 mein left se right ki jagah right se left karna padega and step 1 mein chota hona chahiye bada nahi
     */
    public static void main(String[] args){
        int arr[] = {1,3,5,7,6,4,2};
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for(int i = arr.length-1 ; i >= 0 ; i--){ // for left condition : for(int i = 0 ; i < arr.length ; i++)

            //step 1

            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){ // for next smaller condition : while(!s.isEmpty() && arr[s.peek()] >= arr[i])
                s.pop();
            }

             // step 2 

             if(s.isEmpty()){
                nextGreater[i] = -1;
            }else{
                nextGreater[i] = arr[s.peek()];
            }

            //step 3 
            
            s.push(i);
        }

        // nextGreater wali array ko print kara rhe hai

        for(int i = 0 ; i < nextGreater.length; i++){
            System.out.print(nextGreater[i]+" ");
        }
        System.out.println();   
    }   

}
