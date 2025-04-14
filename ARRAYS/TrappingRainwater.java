import java.util.*;

public class TrappingRainwater { // very important question
      
    public static int trappedRainwater(int height[]){ // time complexity : O(n)

        //calculate left max - array

        int leftMax[] = new int[height.length];

        //corner case for leftmost bar 

        leftMax[0] = height[0];

        for(int i = 1 ; i < height.length ; i++){
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        }

        //calculate right max - array

        int rightMax[] = new int[height.length];
        
        //corner case for rightmost bar 

        rightMax[height.length-1] = height[height.length-1];

        for (int i = (height.length-2); i >= 0; i--) {
            rightMax[i] = Math.max(height[i],rightMax[i+1]);
        }

        int trappedWater = 0;

        //loop for summing up trapped water at each bar or elevation

        for(int i = 0 ; i < height.length ; i++){
            
            //water level = min(leftmax bound , rightmax bound)
            int waterlevel = Math.min(leftMax[i],rightMax[i]); 

            //trapped water = waterlevel - height[i]
            trappedWater += waterlevel - height[i];
        }

        return trappedWater;

    }
    public static void main(String[] args ){

System.out.println("Program to find amount of trapped rainwater :");

        Scanner sc = new Scanner(System.in);
        // Logic to create array using user input :
        System.out.println("Enter the size of array :");
        int size = sc.nextInt();

        int height[] = new int[size];

        System.out.println("Enter the elements within the array :");
        for(int i = 0 ; i < height.length ; i++){
            height[i] = sc.nextInt();
        }

        int trappedWater = trappedRainwater(height);

        System.out.println("Trapped rainwater in following elevation map is : " + trappedWater);

    }

}
 