import java.util.*;
public class StockSpan{
    /*
     * problem statement : We've to find span (max. no of consecuctive days for which price <= today's price) or current stock price se pehle last time sabse bada stock price kitne din pehle aaya tha.
     * span = i - previousHigh
     * 
     * ek array banegi span jo ith index ka span store kregi 
     * or ek banega stack stack se pop krte rhenge jab tak greater nahi milega jaise hi milega to previousHigh mein store krake
     * span nikalenge as span[i] = i - previousHigh
     * or then span[i] ko ith index of span array mein store kra denge.
     */

    public static void stockSpan(int stocks[] , int span[]){
        // ek stack ki zarurat hai to pehle wo bnaliya

        Stack<Integer> s = new Stack<>(); 
        //first ka span to hamesha 1 hi hoga 
        span[0] = 1;
        s.push(0);

        //loop for calculating span for each day
        for(int i = 1 ; i < stocks.length; i++){
            int currentPrice = stocks[i];
            while(!s.isEmpty() && currentPrice > stocks[s.peek()]){
                s.pop(); // jab tak mujhse bada element nahi mil rha jab tak stack se chote elements ko pop krte rhenge
        }
        if(s.isEmpty()){
            span[i] = i+1;
        }
        else{
            int previousHigh = s.peek();
            span[i] = i - previousHigh;
        }

        s.push(i);
        }
    }
    public static void main(String[] args) {
        int stocks[] = {100, 80 , 60, 70, 60 , 85, 100};
        int span[] = new int[stocks.length]; // ye array span store krne ke liye
        stockSpan(stocks,span); // ye function span nikalega

        for(int i = 0 ; i < span.length; i++){
            System.out.println(span[i]);
        }
    }
}