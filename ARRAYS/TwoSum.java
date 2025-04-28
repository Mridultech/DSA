import java.util.*;

// Class ka naam aur file ka naam same hona chahiye --> TwoSum.java
public class TwoSum {

    // Main method: yahi se program start hota hai
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input le rahe hain
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter the target sum: ");
        int target = sc.nextInt();

        // Object banake twoSum method call karenge
        Solution obj = new Solution();
        int[] result = obj.twoSum(nums, target);

        // Output show karenge
        if(result.length == 2) {
            System.out.println("Indices of the two numbers are: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No valid pair found!");
        }

        sc.close();
    }
}

// Separate Solution class jisme Two Sum ka logic hoga
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Step 1: HashMap banate hain (number -> index)
        Map<Integer, Integer> numMap = new HashMap<>();

        // Step 2: Array ko ek hi baar traverse karenge (One Pass)
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Mujhe kya chahiye iske saath milake target banane ke liye

            // Step 3: Agar complement already map me hai to answer mil gaya
            if (numMap.containsKey(complement)) {
                // complement ka index + current index return kar dena
                return new int[]{numMap.get(complement), i};
            }

            // Step 4: Nahi mila to current number ko map me daal do
            numMap.put(nums[i], i);
        }

        // Step 5: Agar nahi mila koi bhi valid pair
        return new int[]{};
    }
}
