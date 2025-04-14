import java.util.*;
public class FractionalKnapSack {

    /*
     * knapsack(bori)
     * Problem statement : Given the weights and values of N items, put these items in a knapsack of capacity W to get maximum total value in the knapsack. 
     * Note : we can also put items in fractional quantities as well.
     * ex : if we have 10 kg of weight and 60 value, we can take 5 kg of weight and 30 value.
     * 
     * Greedy approach : Sort the items in decreasing order of value/weight ratio.
     * Take the item with the highest value/weight ratio and put it in the knapsack.
     * If the item can be put in the knapsack, put it in the knapsack.
     * If the item cannot be put in the knapsack, take the fraction of the item that can be put in the knapsack.
     * 
     * ex : value[60, 100, 120], weight[10, 20, 30], capacity[knapsack] = 50
     * value/weight ratio = [6, 5, 4]
     * Sort the items in decreasing order of value/weight ratio = [60, 100, 120]
     * Take the first item (60) and put it in the knapsack.
     * Remaining capacity = 50 - 10 = 40
     * Take the second item (100) and put it in the knapsack.
     * Remaining capacity = 40 - 20 = 20
     * Take the third item (120) and put it in the knapsack.
     * Now third item can't be put in the knapsack as it has 30 weight and only 20 capacity left.
     * Take the fraction of the item that can be put in the knapsack.
     * Take 20/30 of the item.
     * Total value = 60 + 100 + (20/30)*120 = 240
     * 
     * answer = 240
     * 
     * Time complexity : O(NlogN) + O(N) = O(NlogN)
     * 
     */
    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        int W = 50;

        double ratio[][] = new double[val.length][2];
        //0th col => index; 1st col => ratio 

        for(int i = 0 ; i < val.length ; i++){
            ratio[i][0] = i;
            ratio[i][1] = (double)val[i] / wt[i];
        }

        // Sorting the array in ascending order of value/weight ratio
        Arrays.sort(ratio, Comparator.comparing(o -> o[1]));
        
        int capacity = W;
        int finalValue = 0;

        for(int i = ratio.length-1 ; i >= 0 ; i--){
            int index = (int)ratio[i][0];
            if(capacity >= wt[index]){
                finalValue += val[index];
                capacity -= wt[index];
                System.out.println("Item " + index + " is taken in full.");
            }else{
                //Include fractional item
                finalValue += (ratio[i][1] * capacity);
                capacity = 0; // Reset capacity to 0 after taking the fraction
                System.out.println("Item " + index + " is taken in fraction.");
                break;
            }
        }

        System.out.println("Maximum value in Knapsack = " + finalValue);
        System.out.println("Remaining capacity = " + capacity);

    }
}
