import java.util.*;
public class IndianCoins { //similar problem like knapsack problem

    /*
     * systems on which greedy approach works are known as canonical systems.
     * Problem statement : Given a set of coins of different denominations, find the minimum number of coins required to make a given amount.
     * Input : coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000}, amount = 1234
     * Output : 6 (1000 + 200 + 20 + 10 + 2 + 1)
     * 
     * Approach : 
     * 1. Sort the coins in descending order.
     * 2. Initialize a variable to keep track of the number of coins used.
     * 3. Iterate through the coins and subtract the coin value from the amount until the amount is less than the coin value.
     * 4. Increment the number of coins used for each coin used.
     */
    public static void main(String[] args) {

        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};

        Arrays.sort(coins,Comparator.reverseOrder()); // agar coins ko integer nahi bnate to reverse mein sort nahi hoga kyu reverseOrder keval objects ke liye hota hai.
        
        int countOfCoins = 0;
        int amount = 590;
        ArrayList<Integer> coinsUsed = new ArrayList<>(); // to store the coins used

        for(int i = 0 ; i < coins.length ; i++){
            if(coins[i] <= amount){
                while(coins[i] <= amount){
                    countOfCoins++;// number of coins used
                    coinsUsed.add(coins[i]);
                    amount -= coins[i]; // subtract the coin value from the amount
                }
            }
        }
        System.out.println("Total coins used: " + countOfCoins); // output the total number of coins used

        for(int i = 0 ; i< coinsUsed.size() ; i++){
            System.out.print(" | Coin used: " + coinsUsed.get(i)); // output the coins used
        }
        System.out.println();
    }
}
