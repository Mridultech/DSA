import java.util.Scanner;

public class BuyAndSellStocks {

    public static int profit(int numbers[]){

        int buyprice = Integer.MAX_VALUE; // kyuki hame buyprice minimum chahiye isiliye max value se initialize kiya

        int maxProfit = 0;

        for(int i = 0 ; i < numbers.length ; i++){

            if(buyprice < numbers[i]){

                maxProfit = Math.max(maxProfit, numbers[i] - buyprice);

            }
            else{

                buyprice = numbers[i];

            }

        }

        return maxProfit;

    }
    public static void main(String[] args) {

        System.out.println("Program for calculating maximum profit by buying and selling stocks");

        Scanner sc = new  Scanner(System.in);


        // Logic to create array using user input :

        System.out.println("Enter the size of array :");
        int size = sc.nextInt();
        int numbers[] = new int[size];

        System.out.println("Enter the elements within the array:");
        for(int i = 0 ; i < numbers.length ; i++){

            numbers[i] = sc.nextInt();
            
        }
        
        int result = profit(numbers);

        System.out.println("Maximum profit that can be made is : " + result);
    
    }   
}
